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

/**
 * 策略调用测试类！
 *
 * @author Kang.Cunhua
 */
public class CreateSmsClient {

  public static void main(String[] args) {

//    CreateSmsContentStrategy stgA = new CreateSmsContentStrategyForIbsPartA();
//
//    CreateSmsContent ct = new CreateSmsContent(stgA);
//
//    ct.DoAction();

    System.out.println(new CreateSmsContent(new CreateSmsContentStrategyForIbsPartA()).DoAction());
    System.out.println(new CreateSmsContent(new CreateSmsContentStrategyForIbsPartB()).DoAction());
    System.out.println(new CreateSmsContent(new CreateSmsContentStrategyForLoanPartA()).DoAction());
    System.out.println(new CreateSmsContent(new CreateSmsContentStrategyForLoanPartB()).DoAction());
    System.out.println(new CreateSmsContent(new CreateSmsContentStrategyForTuxDomainPartA()).DoAction());
    System.out.println(new CreateSmsContent(new CreateSmsContentStrategyForTuxDomainPartB()).DoAction());
    System.out.println(new CreateSmsContent(new CreateSmsContentStrategyForTuxServicePartA()).DoAction());
    System.out.println(new CreateSmsContent(new CreateSmsContentStrategyForTuxServicePartB()).DoAction());

  }
}
