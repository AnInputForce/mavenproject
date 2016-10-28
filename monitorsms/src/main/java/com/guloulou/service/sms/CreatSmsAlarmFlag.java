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

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 处理报警标志文件的生成及判断 处理短信文件的移动到接口目录
 *
 * @author Kang.Cunhua
 */
public class CreatSmsAlarmFlag {

  protected static Properties properties = new Properties();
  // 对子类访问友好
  protected static String filepath = null;
  protected static String mvtofilepath = null;

  /**
   * 读取发短信时间、文件路径配置的属性文件：smsconfig.properties *
   */
  static {
    try {
      properties.load(CreatSmsServiceAbst.class.getClassLoader().getResourceAsStream("smsconfig.properties"));
      filepath = properties.getProperty("filepath");
      mvtofilepath = properties.getProperty("mvtofilepath");
    } catch (IOException ex) {
      Logger.getLogger(CreatSmsServiceAbst.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void mvSmsFileToSendDir() throws IOException {
    File dir = new File(filepath);
    String[] files = dir.list(new SuffixFileFilter(".txt"));
    System.out.println("开始批量移动短信文件到接口发短信的目录");
    for (int i = 0; i < files.length; i++) {
      FileUtils.moveToDirectory(new File(filepath + files[i]), new File(mvtofilepath), true);
      System.out.println("移动的短信文件名是：" + files[i]);
    }
    System.out.println("结束批量移动短信文件到接口发短信的目录");
  }

  public void setAlarmflag() {
    writeSmsFile("报警标志文件", "alarmflagfile");
  }

  public Boolean getwarnflag(Boolean delflagfile) {
    Boolean warnflag = true;

    File dir = new File(filepath);
    String[] files = dir.list(new SuffixFileFilter(".i"));
    String tmpStr = null;
    //    for (int i = 0; i < files.length; i++) {
    //      System.out.println(files[i]);
    //    }
    //默认控制只有一个*.i的文件
    if (files.length > 0) {
      System.out.println("短信警告标志文件名字*.i is :" + files[0]);
      tmpStr = files[0].substring(8, 10);
      System.out.println("tmpStr is :" + tmpStr);
      Date currentDate = new Date();
      // 此处时间格式化成字符串与配置文件格式一致,仅得到小时判断即可
      SimpleDateFormat timeformat = new SimpleDateFormat("HH");
      String currentTime = timeformat.format(currentDate);
      System.out.println("currentTime is :" + currentTime + "点");
      // 如果当前报警标志文件的时间hh + 3(来自smsconfig.properties) > 当前时间 hh，则不再生成短信文件
      if ((Integer.parseInt(tmpStr) + Integer.parseInt(properties.getProperty("alarmShortcircuit")))
              > Integer.parseInt(currentTime) && !delflagfile) {
        warnflag = false;
      } else {
        //删除当前报警文件
        FileUtils.deleteQuietly(new File(filepath + files[0]));
      }

    }

    return warnflag;
  }

  public void writeSmsFile(String smscontent, String smsType) {
    String fileName = generateFileName(".i", smsType);
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

  public static void main(String[] args) {
    //new CreatSmsAlarmFlag().setAlarmflag();
    System.out.println("测试是否二次报警" + new CreatSmsAlarmFlag().getwarnflag(false));
  }
}
