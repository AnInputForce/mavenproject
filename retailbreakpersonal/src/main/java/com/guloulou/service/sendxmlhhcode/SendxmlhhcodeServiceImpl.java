/*
 * Document   : SendxmlhhcodeServiceImpl
 * Created on : 2011-10-21, 15:56:11
 * Author     : Kang.Cunhua
 */
package com.guloulou.service.sendxmlhhcode;

import com.guloulou.model.Retailbreak;
import com.guloulou.model.Sendxmlhhcode;
import com.guloulou.service.dao.DaoSupport;
import com.itcast.model.QueryResult;
import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author Kang.Cunhua
 */
public class SendxmlhhcodeServiceImpl extends DaoSupport implements SendxmlhhcodeService {

  public void save(Object entity) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void update(Object entity) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public <T> void delete(Class<T> entityClass, Object entityid) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public <T> void delete(Class<T> entityClass, Object[] entityids) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public <T> T find(Class<T> entityClass, Object entityId) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public <T> QueryResult<T> getScrollData(Class<T> entityClass, Object entityId) {
    QueryResult qr = new QueryResult<Retailbreak>();
    String sql = "select * from  bb_sendxml_hhcode where jhdh=?";
    if (entityId == null) {
      sql = "select * from  bb_sendxml_hhcode";
    }
    Object[] args = new Object[]{(String) entityId};
    int[] argTypes = new int[]{Types.VARCHAR};
    List list = jdbcTemplate.query(sql, args, argTypes, new BeanPropertyRowMapper(entityClass));
    qr.setResultlist(list);
    qr.setTotalrecord(Long.valueOf(list.size()));
    System.out.println("list:" + qr);

    return qr;
  }

  public <T> QueryResult<T> getScrollData(Class<T> entityClass) {
    QueryResult qr = new QueryResult<Retailbreak>();
    String sql = "select * from  bb_sendxml_hhcode";

    List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(entityClass));
    qr.setResultlist(list);
    qr.setTotalrecord(Long.valueOf(list.size()));
    System.out.println("list:" + qr);

    return qr;
  }

  public static void main(String[] args) {
    List<Sendxmlhhcode> list = new SendxmlhhcodeServiceImpl().getScrollData(Sendxmlhhcode.class, "10001").getResultlist();
    System.out.println("list:" + list.size());
    for (Sendxmlhhcode sendxmlhhcode : list) {
      System.out.println("Sendxmlhhcode is :" + sendxmlhhcode.getFill() + "|" + sendxmlhhcode.getOrgcode()
              + "|" + sendxmlhhcode.getJhdh() + "|" + sendxmlhhcode.getVerify());

    }

  }
}
