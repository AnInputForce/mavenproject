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
package com.guloulou.repository.datachange;

import com.guloulou.domain.datachange.IssueBaseInfo;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Kang.Cunhua
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:current-context.xml")
public class IssueBaseInfoRepositoryTest {

  @Autowired
  IssueBaseInfoRepository repository;
  IssueBaseInfo issue = new IssueBaseInfo();

  public IssueBaseInfoRepositoryTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testInsert() {
    issue.setRequestTime(new Date());
    issue.setRequestDepartment("测试一部111");
    issue.setReasonAndContent("啊，啊，啊，啊，嗷嗷，啊，啊，啊，啊，我们业务做不下去了，请求后台处理！");
    issue.setLinkman("陈颖兵");
    issue.setJustEncode("201308098701010");
    issue.setIssueSummary("用户业务发生变化，只能走后台处理！");
    issue.setIssueState("2");
    issue.setIssueCreator("刘畅");
    issue.setHandlingPerson("王启鸣");
    issue.setDealwithTime(new Date());
    issue.setContactNumber("13838884940");
    issue.setBranchHead("白处");
    issue.setAttachmentTitle("附件清单1.txt");
    issue.setAttachmentName("独立评审改联合评审");


    issue = repository.save(issue);
    System.out.println("RequestTime:" + issue.getRequestTime());
    System.out.println("ReasonAndContent:" + issue.getReasonAndContent());
    System.out.println("HandlingPerson:" + issue.getHandlingPerson());

    System.out.println("id:" + issue.getId());


    assertEquals(issue, repository.findOne(issue.getId()));
  }

  @Test
  public void testRead() {



    issue = repository.findOne(new Long(1));
    System.out.println("RequestTime:" + issue.getRequestTime());
    System.out.println("ReasonAndContent:" + issue.getReasonAndContent());
    System.out.println("HandlingPerson:" + issue.getHandlingPerson());

    System.out.println("id:" + issue.getId());


    assertEquals(issue, repository.findOne(issue.getId()));
  }
}