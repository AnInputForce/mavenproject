package com.guloulou.test.jdbc.spring;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.guloulou.helper.JdbcUtilsMysql;
import com.guloulou.test.jdbc.domain.User;

/**
 *
 * 2008-12-13
 *
 * @author <a href="mailto:liyongibm@gmail.com">liyong</a>
 *
 */
public class SimpleJdbcTemplateTest {

  static SimpleJdbcTemplate simple = new SimpleJdbcTemplate(JdbcUtilsMysql.getDataSource());

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
  }

  static User find(String name) {
    String sql = "select id, name, money, birthday  from user where name=? and money > ?";
    User user = simple.queryForObject(sql,
            ParameterizedBeanPropertyRowMapper.newInstance(User.class),
            name, 100f);
    return user;
  }
}
