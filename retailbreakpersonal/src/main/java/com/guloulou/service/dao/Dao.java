/*
 * Document   : Dao
 * Created on : 2011-10-21, 12:10:37
 * Author     : Kang.Cunhua
 */
package com.guloulou.service.dao;

import com.itcast.model.QueryResult;
import java.util.LinkedHashMap;

/**
 *
 * @author Kang.Cunhua
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

  public <T> QueryResult<T> getScrollData(Class<T> entityClass, Object entityId);
}
