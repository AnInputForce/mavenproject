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
public class CreatSmsServiceImplForPartBTest {

  public CreatSmsServiceImplForPartBTest() {
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
   * Test of getConditionFromDb method, of class CreatSmsServiceImplForPartB.
   */


  /**
   * Test of processSmsFile method, of class CreatSmsServiceImplForPartB.
   */
  @Test
  public void testProcessSmsFile() {
    System.out.println("processSmsFile");
    CreatSmsServiceImplForPartB instance = new CreatSmsServiceImplForPartB();
    String expResult = "sucess!";
    String result = instance.processSmsFile();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of main method, of class CreatSmsServiceImplForPartB.
   */

}
