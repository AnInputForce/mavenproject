package com.itcast.service.base;

import com.itcast.bean.QueryResult;
import java.util.LinkedHashMap;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kang.cunhua
 */
@Transactional // 后面的方法都会具有默认的事务行为
public abstract class DaoSupport implements DAO {

    @PersistenceContext
    protected EntityManager em; // 允许子类访问，不用再在子类中注入

    @Override
    public void save(Object entity) {
        em.persist(entity);
    }

    @Override
    public void update(Object entity) {
        em.merge(entity);
    }

    @Override
    public <T> void delete(Class<T> entityClass, Object entityid) {
        delete(entityClass, new Object[]{entityid});
    }

    @Override
    public <T> void delete(Class<T> entityClass, Object[] entityids) {
        for (Object id : entityids) {
            em.remove(em.getReference(entityClass, id));
        }
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> T find(Class<T> entityClass, Object entityId) {
        return em.find(entityClass, entityId);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
            int maxresult, String wherejpql, Object[] queryParams, LinkedHashMap<String, String> orderby) {
        QueryResult qr = new QueryResult<T>();
        String entityname = getEntityName(entityClass);
        Query query = em.createQuery("select o from " + entityname + " o " + (wherejpql == null ? "" : "where " + wherejpql) + buildOrderby(orderby));
        setQueryParams(query, queryParams);
        if (firstindex != -1 && maxresult != -1) {
            query.setFirstResult(firstindex);
            query.setMaxResults(maxresult);
            //这两句也可以简写为：query.setFirstResult(firstindex).setMaxResults(maxresult);
        }
        qr.setResultlist(query.getResultList());
        query = em.createQuery("select count(o) from " + entityname + " o " + (wherejpql == null ? "" : "where " + wherejpql));
        setQueryParams(query, queryParams);
        qr.setTotalrecord((Long) query.getSingleResult());

        return qr;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult, LinkedHashMap<String, String> orderby) {
        return getScrollData(entityClass, firstindex, maxresult, null, null, orderby);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult, String wherejpql, Object[] queryParams) {
        return getScrollData(entityClass, firstindex, maxresult, wherejpql, queryParams, null);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult) {
        return getScrollData(entityClass, firstindex, maxresult, null, null, null);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass) {
        return getScrollData(entityClass, -1, -1);
    }

    protected void setQueryParams(Query query, Object[] queryParams) {
        if (queryParams != null && queryParams.length > 0) {
            for (int i = 0; i < queryParams.length; i++) {
                query.setParameter(i + 1, queryParams[i]);
            }
        }
    }

    /**
     * 组装order by 语句
     * @param orderby
     * @return
     */
    protected String buildOrderby(LinkedHashMap<String, String> orderby) {
        StringBuilder orderbyql = new StringBuilder();
        if (orderby != null && orderby.size() > 0) {
            orderbyql.append(" order by ");
            // order by o.key desc,o.key2 asc
            for (String key : orderby.keySet()) {
                orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
            }
            orderbyql.deleteCharAt(orderbyql.length() - 1);
        }
        return orderbyql.toString();
    }

    /**
     * 利用反射技术得到要传递到分页方法中的实体类的名字，简单名字还是自定义名字
     * @param <T>
     * @param entityClass
     * @return
     */
    protected <T> String getEntityName(Class<T> entityClass) {
        String entityname = entityClass.getSimpleName();
        Entity entity = entityClass.getAnnotation(Entity.class);
        if (entity.name() != null && !"".equals(entity.name())) {
            entityname = entity.name();
        }

        return entityname;
    }
}
