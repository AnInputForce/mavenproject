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
public class CreateSmsContentStrategyForTuxServicePartBTest {

  public CreateSmsContentStrategyForTuxServicePartBTest() {
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
   * Test of editSmsContent method, of class CreateSmsContentStrategyForTuxServicePartB.
   */
  @Test
  public void testEditSmsContent() {
    System.out.println("editSmsContent");
    CreateSmsContentStrategyForTuxServicePartB instance = new CreateSmsContentStrategyForTuxServicePartB();
    String expResult = "小额信贷主机的chibs、小额信贷主机的chibsDQZFILERECV、小额信贷主机的chibsDQZFILESEND、小额信贷主机的chibsFILERECV、小额信贷主机的chibsFILESEND、小额信贷主机的chibsie、小额信贷主机的chuda、小额信贷主机的DMADM、小额信贷主机的GWADM、小额信贷主机的GWTDOMAIN、小额信贷主机的WSL、小额信贷主机的DMADM、小额信贷会计的DQZFILERECV、小额信贷会计的DQZFILESEND、小额信贷主机的GWADM、小额信贷主机的GWTDOMAIN、小额信贷会计的IBSAPS、小额信贷会计的IBSFILERECV、小额信贷会计的IBSFILESEND、小额信贷主机的WSL服务宕了";
    String result = instance.editSmsContent();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }
}
