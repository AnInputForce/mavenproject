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
 *
 * @author Kang.Cunhua
 */
public class CreateSmsContent {

  private CreateSmsContentStrategy stg;

  /**
   * 默认构造函数，请不要调用
   */
  public CreateSmsContent() {
    System.out.println("CreateSmsContext，请不要调用");
  }

  public CreateSmsContent(CreateSmsContentStrategy theStg) {

    this.stg = theStg;

  }

  public String DoAction() {

    return this.stg.editSmsContent();

  }
}
