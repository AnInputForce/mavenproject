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
 * 短信持久化处理
 * @author Kang.Cunhua
 */
public interface CreatSmsService {

  /**
   * 判断时间：是否满足发短信时间段
   *
   * @return
   */
  public Boolean getSendTimeIsOk(String startTime, String endTime);

  /**
   * 获得条件：是否满足发短信条件
   *
   * @return
   */
  public Boolean getConditionFromDb();

  /**
   * 处理短信文件
   *
   * @return
   */
  public String processSmsFile();

  /**
   * 获得手机号
   *
   * @return
   */
  public String getTelphone();

  /**
   * 获得机主姓名
   *
   * @return
   */
  public String getPersonName();

  /**
   * 获得写入短信到文件
   *
   * @return
   */
  public void writeSmstoFile();
}
