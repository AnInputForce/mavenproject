/*
 * Copyright 2013 待到道成日，纵横天地间.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.guloulou.service.datachange;

import com.guloulou.domain.common.QueryResult;
import com.guloulou.domain.datachange.IssueBaseInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kang.Cunhua
 */
@Repository // 通过Spring注解定义一个DAO
public class IssueBaseInfoServiceImpl implements IssueBaseInfoService {

  @Autowired // 自动注入JdbcTemplate的Bean
  private JdbcTemplate jdbcTemplate;

  public IssueBaseInfoServiceImpl() {
  }

  @Override
  public <T> QueryResult<T> getAllIssueBaseInfo(Class<T> entityClass) {

    String sqltmp = "select * from issuebaseinfo ";
    QueryResult qr = new QueryResult<IssueBaseInfo>();
    List list = jdbcTemplate.query(sqltmp, new BeanPropertyRowMapper(entityClass));//  .queryForList("select * from issuebaseinfo ", IssueBaseInfo.class);
    System.out.println("total number is : " + list.size());
    qr.setResultlist(list);
    qr.setTotalrecord(new Long(list.size()));
    return qr;
  }

  public <T> QueryResult<T> getIssueByLastupdatetime() {
    return null;
  }

  public <T> QueryResult<T> getIssueBetweenLastupdatetime() {
    return null;
  }
}
