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
package com.guloulou.domain.smsmonitor;

/**
 * 对应短信文件格式化模版的Domain对象 模版替换的时候需要使用到
 *
 * @author Kang.Cunhua
 */
public class SmsFileFormat {

  private String personname;
  private String mobilephone;
  private String sms;

  public SmsFileFormat() {
  }

  public SmsFileFormat(String personname, String mobilephone, String sms) {
    this.personname = personname;
    this.mobilephone = mobilephone;
    this.sms = sms;
  }

  /**
   * @return the personname
   */
  public String getPersonname() {
    return personname;
  }

  /**
   * @param personname the personname to set
   */
  public void setPersonname(String personname) {
    this.personname = personname;
  }

  /**
   * @return the mobilephone
   */
  public String getMobilephone() {
    return mobilephone;
  }

  /**
   * @param mobilephone the mobilephone to set
   */
  public void setMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
  }

  /**
   * @return the sms
   */
  public String getSms() {
    return sms;
  }

  /**
   * @param sms the sms to set
   */
  public void setSms(String sms) {
    this.sms = sms;
  }
}
