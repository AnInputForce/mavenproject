/*
 * Document   : RetailbreakPersonalServiceImpl
 * Created on : 2011-10-20, 17:53:10
 * Author     : Kang.Cunhua
 */
package com.guloulou.service.retailbreak;

import com.guloulou.model.Retailbreak;
import com.guloulou.service.dao.DaoSupport;
import com.itcast.model.QueryResult;
import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author Kang.Cunhua
 */
public class RetailbreakPersonalServiceImpl extends DaoSupport implements RetailbreakPersonalService {

  public RetailbreakPersonalServiceImpl() {
  }

  public void save(Object entity) {
//    String sql = "insert into user(name,birthday, money) "
//            + "values (:name,:birthday,:money) ";
//    SqlParameterSource ps = new BeanPropertySqlParameterSource((RetailbreakPersonalService) entity);
//    named.update(sql, ps);
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
    String sql = "select * from bb_loan_retail_break where jhdh=?";
    Object[] args = new Object[]{(String) entityId};
    int[] argTypes = new int[]{Types.VARCHAR};
    List list = jdbcTemplate.query(sql, args, argTypes, new BeanPropertyRowMapper(entityClass));
    qr.setResultlist(list);
    qr.setTotalrecord(Long.valueOf(list.size()));
    System.out.println("list:" + qr);

    return qr;
  }

  public static void main(String[] args) {
    List<Retailbreak> list = new RetailbreakPersonalServiceImpl().getScrollData(Retailbreak.class, "10001").getResultlist();
    System.out.println("list:" + list.size());
    for (Retailbreak retailbreak : list) {
      System.out.println("retailbreak is :" + retailbreak.getCustomer_name() + "|" + retailbreak.getOrgcode()
              + "|" + retailbreak.getCustomer_area() + "|" + retailbreak.getCustomer_name());

    }

  }
}
