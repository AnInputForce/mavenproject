/*
 * Copyright 2012 待到道成日，纵横天地间.
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
package com.guloulou.service.sms;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kang.Cunhua
 */
public class CreateSmsContentStrategyForTuxDomainPartATest {

  public CreateSmsContentStrategyForTuxDomainPartATest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of editSmsContent method, of class CreateSmsContentStrategyForTuxDomainPartA.
   */
  @Test
  public void testEditSmsContent() {
    System.out.println("editSmsContent");
    CreateSmsContentStrategyForTuxDomainPartA instance = new CreateSmsContentStrategyForTuxDomainPartA();
    String expResult = "个贷主机1和个贷主机2与统版北京、天津、河北、山西、内蒙、辽宁、吉林、黑龙、上海、江苏、浙江、安徽、"
            + "福建、江西、山东、河南、湖北、湖南、广东、广西、海南、重庆、四川、贵州、云南、西藏、陕西、甘肃、青海、宁夏、"
            + "新疆、pbexch域连接都中断了；";
    String result = instance.editSmsContent();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }
}
