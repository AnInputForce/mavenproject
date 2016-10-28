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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 系统高级别警报，发送短信的业务类：给SmsConfigForPartA定义的对象短信
 *
 * @author Kang.Cunhua
 */
public class CreatSmsServiceImplForPartA extends CreatSmsServiceAbst {

  private static String partastarttime = null;
  private static String partaendtime = null;

  static {
    partastarttime = properties.getProperty("partastarttime");
    partaendtime = properties.getProperty("partaendtime");
  }

  @Override
  public Boolean getConditionFromDb() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 持久化各个报警短信为文件
   *
   * @return
   */
  @Override
  public String processSmsFile() {
    /*
     * 持久化管理系统的报警信息
     */

    writeSmsFileBySmstype(new CreateSmsContentStrategyForIbsPartA(), "ibsForPartA");
    writeSmsFileBySmstype(new CreateSmsContentStrategyForLoanPartA(), "loanForPartA");
    writeSmsFileBySmstype(new CreateSmsContentStrategyForTuxDomainPartA(), "tuxDomainForPartA");
    writeSmsFileBySmstype(new CreateSmsContentStrategyForTuxServicePartA(), "tuxServiceForPartA");

    return "sucess!";
  }
  /*
   * 获得由模版创建的短信内容，判断发短信的时间是否合适，合适则写入文件 处理指定类型的报警短信持久化为文件
   */

  public String writeSmsFileBySmstype(CreateSmsContentStrategy cscsif, String smstype) {
    System.out.println("测试PartA时间是否合适：");
    /**
     * 测试从配置文件中读取的时间和当前时间判断是否符合发短信时段 合适则处理短信行为，不合适不处理 处理各种报警情况
     */
    System.out.println("partastarttime is " + partastarttime);
    System.out.println("partaendtime is " + partaendtime);

    if (getSendTimeIsOk(partastarttime, partaendtime)) {
      //System.out.println("测试PartA时间是否合适：" + (getSendTimeIsOk(partastarttime, partaendtime)));
      String smstmp = processSmsFileBySmstype(cscsif);
      // 判断生成的短信内容是否为空，是否为false；false则没有符合条件的短信内容
      if (smstmp != null && !"false".equalsIgnoreCase(smstmp)) {
        String tmpcontent = getSmsfilecontent(properties.getProperty("SmsConfigForPartA"), "SmsTemplate", smstmp);
        writeSmsFile(tmpcontent, properties.getProperty(smstype));
      }
      System.out.println("生成PartA的时间合适");

    } else {
      System.out.println("生成PartA的时间不合适");
    }

    return "sucess!";

  }

  public static void main(String[] args) {
    /**
     * 测试从配置文件中读取的时间和当前时间判断是否符合发短信时段
     */
//    String partbstarttime = CreatSmsServiceImplForPartA.getPropertiesValueByKey("partbstarttime");
//    String partbendtime = CreatSmsServiceImplForPartA.getPropertiesValueByKey("partbendtime");
//    System.out.println("测试PartA时间是否合适："
//            + new CreatSmsServiceImplForPartA().getSendTimeIsOk(partbstarttime, partbendtime));
//    CreatSmsServiceImplForAll cssifa = new CreatSmsServiceImplForAll();
//    System.out.println(cssifa.generateFileName(".txt", "loanForPartA"));
//    cssifa.writeSmsFile(new CreateSmsContentStrategyForLoanPartA().editSmsContent(), "loanForPartA");
    System.out.println("写入短信文件：" + new CreatSmsServiceImplForPartA().processSmsFile());
  }
}
