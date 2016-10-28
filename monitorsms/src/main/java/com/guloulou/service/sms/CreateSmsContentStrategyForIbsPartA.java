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

import com.guloulou.domain.smsmonitor.IbsTransactionSuccessRate;
import com.guloulou.domain.smsmonitor.Webpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 *
 * @author Kang.Cunhua
 */
public class CreateSmsContentStrategyForIbsPartA extends CreateSmsContentStrategyAbst {

  public String editSmsContent() {
    System.out.println("调用策略类：" + "CreateSmsContentStrategyForIbsPartA!");
    String returntmp = "false";
    StringBuilder appendtmp = new StringBuilder();
    String sql = "select  (1- ((select  count(asz0date)  from aspfz0 where asz0date=? "
            + "and asz0trco in ('3650','3651','3652','3653','3654','3670','3665')  "
            + "and asz0rsco !='0000') +(select  count(asz0date)  from aspfz0  "
            + "where asz0date=? "
            + "and  asz0rsco  in ('RC51','LNXF')))/(select count(asz0date)  from aspfz0  "
            + "where  asz0date=? )) * 100  "
            + "as transactionSuccessRate from dual";
    System.out.println("sql = " + sql);
    String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
    List<IbsTransactionSuccessRate> resultlist = simpleOracle.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(IbsTransactionSuccessRate.class), currentDate, currentDate, currentDate);

    System.out.println("list.size:" + resultlist.size());
    // 判断是否有记录
    if (resultlist.size() > 0) {
      float tmprate = resultlist.get(0).getTransactionSuccessRate();
      System.out.println("当前交易成功率为：" + tmprate);
      if (tmprate < Float.parseFloat(properties.getProperty("lowpercent"))) {
        appendtmp.append(resultlist.get(0).getTransactionSuccessRate());
        String tempstr = appendtmp.toString();
        returntmp = updateTemplate(new IbsTransactionSuccessRate(Float.valueOf(tempstr)), properties.getProperty("ibsForPartA"));
      }
    }
    return returntmp;
  }
  public static void main(String [] args){
    new CreateSmsContentStrategyForIbsPartA().editSmsContent();
  }
}
