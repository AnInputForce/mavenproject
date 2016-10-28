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

import com.guloulou.domain.smsmonitor.SmsFileFormat;
import com.guloulou.helper.KvCodeHelper;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.stringtemplate.NoIndentWriter;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kang.Cunhua
 */
public abstract class CreatSmsServiceAbst implements CreatSmsService {

  protected static Properties properties = new Properties();
  // 对子类访问友好
  protected static String filepath = null;

  /**
   * 读取发短信时间、文件路径配置的属性文件：smsconfig.properties *
   */
  static {
    try {
      properties.load(CreatSmsServiceAbst.class.getClassLoader().getResourceAsStream("smsconfig.properties"));
      filepath = properties.getProperty("filepath");
    } catch (IOException ex) {
      Logger.getLogger(CreatSmsServiceAbst.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * 客户端调用策略类的入口
   *
   * @param cscsif 策略类的接口，传递子类,由策略执行类CreateSmsContent执行具体的算法
   * @return
   */
  public String processSmsFileBySmstype(CreateSmsContentStrategy cscsif) {
    System.out.println("策略执行：" + new CreateSmsContent(cscsif).DoAction());

    return new CreateSmsContent(cscsif).DoAction();
  }

  /**
   * 根据map中的手机号和名字，以及传递过来的某类型报警短信内容 生成最终的发送给接口的短信文件的内容
   *
   * @param kvcode 传递kvcode的文件名，使用KvCodeHelper.getMap 从配置文件读取手机号和名字的集合
   * @param template 发送给接口的短信文件的模版
   * @return 最终的发送给接口的短信文件的内容
   */
  public String getSmsfilecontent(String kvcode, String template, String smscontent) {
    StringBuilder returnString = new StringBuilder();
//    Map map = KvCodeHelper.getMap(kvcode);
//    for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
//      SmsFileFormat smsFileFormat = new SmsFileFormat((String) it.next(), (String) map.get(it.next()), smscontent);
//      returnString.append(updateTemplate(smsFileFormat, template));
//    }
    Map map = KvCodeHelper.getMap(kvcode);
    Set<Map.Entry<String, String>> set = map.entrySet();
    for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();) {
      Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
      System.out.println(entry.getKey() + "--->" + entry.getValue());
      SmsFileFormat smsFileFormat = new SmsFileFormat(entry.getKey() + "\t", entry.getValue() + "\t", smscontent);
      returnString.append(updateTemplate(smsFileFormat, template)).append("\n");
    }
    return returnString.toString();
  }

  public void writeSmsFile(String smscontent, String smsType) {
    String fileName = generateFileName(".txt", smsType);
    File file = new File(fileName);
    try {
      FileUtils.writeStringToFile(file, smscontent, "gb2312"); //存在则覆盖，不存在则创建
    } catch (IOException ex) {
      Logger.getLogger(CreatSmsServiceImplForAll.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public String generateFileName(String fileName, String smsType) {
    DateFormat format = new SimpleDateFormat("yyyyMMddHH");
    String formatDate = format.format(new Date());
    String extension = fileName.substring(fileName.lastIndexOf("."));
    // 判断后缀名是否为空
    extension = (extension == null) ? "" : extension;
    return filepath + formatDate + smsType + extension;
  }

  /**
   * 得到模版，根据传过来的domain对象进行模版参数替换更新操作
   *
   * @param object 替换时用到的封装对象：模版中对应了domain对象配置替换参数，如 -- $Domian.name$
   * @param tmplatename 替换时使用的模版名字
   * @return 替换过参数后的模版字符串
   */
  public String updateTemplate(Object object, String tmplatename) {

    StringTemplateGroup group = new StringTemplateGroup("seleniumGroup");//模板存储的位置
    group.setStringTemplateWriter(NoIndentWriter.class);
    group.setFileCharEncoding("utf8");//指定模板的编码，避免中文乱码问题；
    StringTemplate data = group.getInstanceOf("com/guloulou/template/smsformat/" + tmplatename);//读入模板不包括.st后缀

    // 得到实例的简单类名，和实例本身一起当作参数对模版文件进行替换
    data.setAttribute(object.getClass().getSimpleName(), object);
    return data.toString();

  }

  /**
   *
   * @param key
   * @return
   */
  public static String getPropertiesValueByKey(String key) {
    return (String) properties.get(key);
  }

  /**
   * 判断时间：是否满足发短信时间段
   *
   * @return
   */
  public Boolean getSendTimeIsOk(String startTime, String endTime) {
    Date currentDate = new Date();
    SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm"); // 此处时间格式化成字符串与配置文件格式一致
    String currentTime = timeformat.format(currentDate);
    System.out.println("currentTime is " + currentTime);
    System.out.println("currentTime.compareTo(startTime) is " + currentTime.compareTo(startTime));
    System.out.println("currentTime.compareTo(endTime) is " + currentTime.compareTo(endTime));
    if ((currentTime.compareTo(startTime) > 0) && (currentTime.compareTo(endTime) < 0)) {
      return true;
    }
    return false;
  }

  /**
   * 获得条件：是否满足发短信条件
   *
   * @return
   */
  public abstract Boolean getConditionFromDb();

  /**
   * 获得短信文本
   *
   * @return
   */
  public abstract String processSmsFile();

  /**
   * 获得手机号
   *
   * @return
   */
  public String getTelphone() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 获得机主姓名
   *
   * @return
   */
  public String getPersonName() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * 获得写入短信到文件
   *
   * @return
   */
  public void writeSmstoFile() {
  }
}
