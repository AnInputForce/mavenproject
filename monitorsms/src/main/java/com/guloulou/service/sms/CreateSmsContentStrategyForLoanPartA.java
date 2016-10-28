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

import com.guloulou.domain.smsmonitor.Webpool;
import java.util.List;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 *
 * @author Kang.Cunhua
 */
public class CreateSmsContentStrategyForLoanPartA extends CreateSmsContentStrategyAbst {

  /**
   * 编辑发给partA分类的 管理系统监控短信内容
   *
   * @return 返回值如果为"false"字符串,则无需继续处理；其他值需继续处理；
   */
  public String editSmsContent() {
    System.out.println("调用策略类：" + "CreateSmsContentStrategyForLoanPartA!");
    String returntmp;
    StringBuilder appendipaddress = new StringBuilder();
    String sql = "select * from WebPool where status=?";
    List<Webpool> resultlist = simpleMysql.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Webpool.class), Integer.parseInt(properties.getProperty("loanhosterror")));

    System.out.println("list.size:" + resultlist.size());
    // 判断主机全部宕机，拼接主机字符串
    if (resultlist.size() == Integer.parseInt(properties.getProperty("loanhostsnum"))) {
      for (int i = 0; i < resultlist.size(); i++) {
        appendipaddress.append(resultlist.get(i).getIpaddr()).append("、");
      }

      String tempstr = appendipaddress.toString();
      tempstr = tempstr.substring(0, tempstr.lastIndexOf("、"));

      // 模版替换 此处做了变通，将遍历得到的 ip 字符串拼接 构造一个Domain对象，以方便进行模版替换操作
      //System.out.println("returnString is :" + "\n" + updateTemplate(webpool));
      returntmp = updateTemplate(new Webpool(tempstr),properties.getProperty("loanForPartA"));

    } else {
      returntmp = "false";
    }
    return returntmp;
  }



  public static void main(String[] args) {
//    StringBuilder returnString = new StringBuilder();
//    String sql = "select * from webpool where status=?";
//    List<Webpool> resultlist = simpleMysql.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Webpool.class), 1);
//
//    System.out.println("list.size:" + resultlist.size());
//    // 拼接主机字符串
//    for (int i = 0; i < resultlist.size(); i++) {
//      returnString.append(resultlist.get(i).getIpaddr()).append("、");
//    }
//
//    String tempstr = returnString.toString();
//    tempstr = tempstr.substring(0, tempstr.lastIndexOf("、"));
//    Webpool webpool = new Webpool();
//    webpool.setIpaddr(tempstr);
//
//    System.out.println("returnString is :" + "\n" + updateTemplate(webpool));

    System.out.println(new CreateSmsContentStrategyForLoanPartA().editSmsContent());

  }
}
