/*
 * Copyright 2011 待到道成日，纵横天地间.
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
package com.guloulou.business.templates;

import com.guloulou.model.Retailbreak;
import com.guloulou.model.Sendxmlhhcode;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Kang.Cunhua
 */
public abstract class ReportMessageProcesserSupport implements ReportMessageProcesser {

  private Sendxmlhhcode sendxmlhhcode = null;
  protected Retailbreak retailbreak = null;
  protected String fileContent = null;
  // 对子类访问友好
  protected static String filepath = null;

  /**
   * 一次性初始化filepath
   */
  static {
    try {
      Properties prop = new Properties();
      InputStream is = ReportMessageProcesserSupport.class.getClassLoader().getResourceAsStream("fileGeneraterConfig.properties");
      prop.load(is);
      filepath = prop.getProperty("filepath");
    } catch (Exception e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  public ReportMessageProcesserSupport() {
  }

  /**
   * 使用此方法之前需要 先给 sendxmlhhcode 赋值
   * @return
   */
  public String generateFileName() {
    String fileName = "c:/11.txt";
    if (sendxmlhhcode != null) {
      fileName = sendxmlhhcode.getJhdh() + "_" + sendxmlhhcode.getOrgcode() + "_" + sendxmlhhcode.getYear_val() + sendxmlhhcode.getMonth_val() + ".xml";
    } else {
      System.out.println("使用此方法generateFileName()之前需要 先给 sendxmlhhcode 赋值!");
      return "error";
    }
    System.out.println("filepath & filename is ==" + filepath + fileName);
    return filepath + fileName;
  }

  /**
   * @return the sendxmlhhcode
   */
  public Sendxmlhhcode getSendxmlhhcode() {
    return sendxmlhhcode;
  }

  /**
   * @param sendxmlhhcode the sendxmlhhcode to set
   */
  public void setSendxmlhhcode(Sendxmlhhcode sendxmlhhcode) {
    this.sendxmlhhcode = sendxmlhhcode;
  }
}
