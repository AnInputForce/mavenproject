/*
 * Document   : DaoSupport
 * Created on : 2011-10-21, 12:06:19
 * Author     : Kang.Cunhua
 */
package com.guloulou.service.dao;

import cn.itcast.jdbc.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Kang.Cunhua
 */
public abstract class DaoSupport implements Dao {

  protected static JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
}
