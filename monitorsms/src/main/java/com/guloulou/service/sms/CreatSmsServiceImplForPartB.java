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
 * 系统低级别警报，发送短信的业务类：给SmsConfigForPartB定义的对象短信
 *
 * @author Kang.Cunhua
 */
public class CreatSmsServiceImplForPartB extends CreatSmsServiceAbst {

  private static String partbstarttime = null;
  private static String partbendtime = null;

  static {
    partbstarttime = properties.getProperty("partbstarttime");
    partbendtime = properties.getProperty("partbendtime");
  }

  public CreatSmsServiceImplForPartB() {
  }

  @Override
  public Boolean getConditionFromDb() {
    return true;
  }

  /**
   * 持久化各个报警短信为文件
   *
   * @return
   */
  @Override
  public String processSmsFile() {

    writeSmsFileBySmstype(new CreateSmsContentStrategyForIbsPartB(), "ibsForPartB");
    writeSmsFileBySmstype(new CreateSmsContentStrategyForLoanPartB(), "loanForPartB");
    writeSmsFileBySmstype(new CreateSmsContentStrategyForTuxDomainPartB(), "tuxDomainForPartB");
    writeSmsFileBySmstype(new CreateSmsContentStrategyForTuxServicePartB(), "tuxServiceForPartB");

    return "sucess!";
  }
  /*
   * 获得由模版创建的短信内容，判断发短信的时间是否合适，合适则写入文件 处理指定类型的报警短信持久化为文件
   */

  public String writeSmsFileBySmstype(CreateSmsContentStrategy cscsif, String smstype) {
    System.out.println("测试PartB时间是否合适：");
    /**
     * 测试从配置文件中读取的时间和当前时间判断是否符合发短信时段 合适则处理短信行为，不合适不处理 处理各种报警情况
     */
    if (getSendTimeIsOk(partbstarttime, partbendtime)) {
      String smstmp = processSmsFileBySmstype(cscsif);
      // 判断生成的短信内容是否为空，是否为false；false则没有符合条件的短信内容
      if (smstmp != null && !"false".equalsIgnoreCase(smstmp)) {
        writeSmsFile(getSmsfilecontent(properties.getProperty("SmsConfigForPartB"), "SmsTemplate", smstmp), properties.getProperty(smstype));
        //System.out.println(getSmsfilecontent("SmsConfigForPartB", "SmsTemplate", smstmp));
      }
      System.out.println("生成PartB的时间合适");

    } else {
      System.out.println("生成PartB的时间不合适");
    }

    return "sucess!";

  }

  public static void main(String[] args) {
    /**
     * 测试从配置文件中读取的时间和当前时间判断是否符合发短信时段
     */
    String partbstarttime = CreatSmsServiceImplForPartB.getPropertiesValueByKey("partbstarttime");
    String partbendtime = CreatSmsServiceImplForPartB.getPropertiesValueByKey("partbendtime");
    System.out.println("测试PartB时间是否合适："
            + new CreatSmsServiceImplForPartB().getSendTimeIsOk(partbstarttime, partbendtime));
  }
}
