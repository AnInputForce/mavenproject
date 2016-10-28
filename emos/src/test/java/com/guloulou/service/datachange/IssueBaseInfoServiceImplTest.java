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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class IssueBaseInfoServiceImplTest {

  @Autowired
  IssueBaseInfoService issueBaseInfoService;

  public IssueBaseInfoServiceImplTest() {
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

  /**
   * Test of getAllIssueBaseInfo method, of class IssueBaseInfoServiceImpl.
   */
  @Test
  public void testGetAllIssueBaseInfo() {
    System.out.println("getAllIssueBaseInfo");
//    In your test the LoginServiceImpl loginServiceObj = new LoginServiceImpl(); 
//    is not instantiated by spring, thus no annaotions will be applied. 
//    You need to autowire it, or inject it some other way. Spring 3.2 makes this kinda thing super easy and nice to use.
    //IssueBaseInfoServiceImpl issueBaseInfoService = new IssueBaseInfoServiceImpl();


    QueryResult result = issueBaseInfoService.getAllIssueBaseInfo(IssueBaseInfo.class);
    System.out.println("num is:" + ((IssueBaseInfo) (result.getResultlist().get(1))).getIssueSummary());


  }
}