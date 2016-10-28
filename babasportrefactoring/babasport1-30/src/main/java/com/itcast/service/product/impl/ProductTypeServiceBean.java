package com.itcast.service.product.impl;

import com.itcast.service.base.DaoSupport;
import com.itcast.service.product.ProductTypeService;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kang.cunhua
 */
@Service  //标注为Spring的Servicebean，供自动扫描机制加载该bean，就不用再beans.xml中声明了
@Transactional
public class ProductTypeServiceBean extends DaoSupport implements ProductTypeService {

    @Override
    public <T> void delete(Class<T> entityClass, Object[] entityids) {
        if (entityids != null && entityids.length > 0) {
            StringBuilder jpql = new StringBuilder();
            for (int i = 0; i < entityids.length; i++) {
                jpql.append("?").append(i + 2).append(",");
            }
            jpql.deleteCharAt(jpql.length() - 1);
            Query query = em.createQuery("update ProductType o set o.visible=?1 where o.typeid in (" + jpql.toString() + ")").setParameter(1, false);
            for (int i = 0; i < entityids.length; i++) {
                query.setParameter(i + 2, entityids[i]);
            }
            query.executeUpdate();
        }
    }
}
