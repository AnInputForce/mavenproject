package com.itcast.service.dao;

import com.itcast.model.QueryResult;
import java.util.LinkedHashMap;

/**
 *
 * @author kang.cunhua
 */
public interface Dao {

    /**
     * 保存实体
     * @param entity 实体
     */
    public void save(Object entity);

    /**
     * 更新实体
     * @param entity 实体
     */
    public void update(Object entity);

    /**
     * 删除实体
     * @param <T>
     * @param entityClass 实体类
     * @param entityid
     */
    public <T> void delete(Class<T> entityClass, Object entityid);

    /**
     * 删除实体
     * @param <T>
     * @param entityClass 实体类
     * @param entityids 实体id数组
     */
    public <T> void delete(Class<T> entityClass, Object[] entityids);

    /**
     * 获取实体
     * @param <T>
     * @param entityClass 实体类
     * @param entityId  实体id
     * @return
     */
    public <T> T find(Class<T> entityClass, Object entityId);

    /**
     * 获取分页数据
     * @param <T>
     * @param entityClass 实体类
     * @param firstindex 开始索引
     * @param maxresult 需要获取的记录数
     * @param wherejpql
     * @param queryParams
     * @param orderby
     * @return
     */
    //实体的属性，ASC/DESC
    //order by key1 desc,key2,asc
    //此处用LinkedHashMap而不用HashMap是因为：HashMap会对添加进去的数据进行重排序，我们此处希望按照我们添加的顺序排序，所以LinkedHashMap合适；
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
            int maxresult, String wherejpql, Object[] queryParams, LinkedHashMap<String, String> orderby);

    /**
     *
     * @param <T>
     * @param entityClass
     * @param firstindex
     * @param maxresult
     * @param wherejpql
     * @param queryParams
     * @return
     */
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
            int maxresult, String wherejpql, Object[] queryParams);

    /**
     *
     * @param <T>
     * @param entityClass
     * @param firstindex
     * @param maxresult
     * @param orderby
     * @return
     */
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
            int maxresult, LinkedHashMap<String, String> orderby);

    /**
     *
     * @param <T>
     * @param entityClass
     * @param firstindex
     * @param maxresult
     * @return
     */
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult);

    /**
     *
     * @param <T>
     * @param entityClass
     * @return
     */
    public <T> QueryResult<T> getScrollData(Class<T> entityClass);
}
