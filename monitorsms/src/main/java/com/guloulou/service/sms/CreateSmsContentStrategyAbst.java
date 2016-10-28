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
import com.guloulou.helper.JdbcUtilsMysql;
import com.guloulou.helper.JdbcUtilsOracle;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.stringtemplate.NoIndentWriter;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * 抽象类，做一些子类都会做的初始化工作。还有不需要放到子类实现的操作：此处仅作初始化
 *
 * @author Kang.Cunhua
 */
public abstract class CreateSmsContentStrategyAbst implements CreateSmsContentStrategy {

  static Properties properties = new Properties();
  static SimpleJdbcTemplate simpleMysql = new SimpleJdbcTemplate(JdbcUtilsMysql.getDataSource());
  static SimpleJdbcTemplate simpleOracle = new SimpleJdbcTemplate(JdbcUtilsOracle.getDataSource());

  static {
    try {
      properties.load(CreateSmsContentStrategyAbst.class.getClassLoader().getResourceAsStream("smsconfig.properties"));
    } catch (IOException ex) {
      Logger.getLogger(CreateSmsContentStrategyAbst.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
/**
 * 得到模版，根据传过来的domain对象进行模版参数替换更新操作
 * @param object 替换时用到的封装对象：模版中对应了domain对象配置替换参数，如 -- $Domian.name$
 * @param tmplatename 替换时使用的模版名字
 * @return 替换过参数后的模版字符串
 */
  public String updateTemplate(Object object, String tmplatename) {

    StringTemplateGroup group = new StringTemplateGroup("seleniumGroup");//模板存储的位置
    group.setStringTemplateWriter(NoIndentWriter.class);
    group.setFileCharEncoding("utf8");//指定模板的编码，避免中文乱码问题；
    StringTemplate data = group.getInstanceOf("com/guloulou/template/smscontent/" + tmplatename);//读入模板不包括.st后缀

    // 得到实例的简单类名，和实例本身一起当作参数对模版文件进行替换
    data.setAttribute(object.getClass().getSimpleName(), object);
    return data.toString();

  }
}
