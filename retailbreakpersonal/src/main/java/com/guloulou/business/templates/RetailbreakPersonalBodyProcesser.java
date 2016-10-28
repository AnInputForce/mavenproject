/*
 * Document   : RetailbreakPersonalBodyProcesser
 * Created on : 2011-10-20, 13:28:16
 * Author     : Kang.Cunhua
 */
package com.guloulou.business.templates;

import com.guloulou.model.Retailbreak;
import com.guloulou.model.Sendxmlhhcode;
import com.guloulou.service.retailbreak.RetailbreakPersonalServiceImpl;
import com.guloulou.service.sendxmlhhcode.SendxmlhhcodeServiceImpl;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
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
public class RetailbreakPersonalBodyProcesser extends ReportMessageProcesserSupport {

  private List<Retailbreak> list = null;

  public RetailbreakPersonalBodyProcesser() {
  }

  /**
   * 使用此函数前需对list赋值；
   * @return
   * @throws ParseException
   */
  public String getReportMessageContent() throws ParseException {
    StringBuffer reportMessageContent = new StringBuffer();
    for (Retailbreak rb : list) {
      //System.out.println("===当前body处理记录编号===" + rb.getJhdh() + "_" + rb.getOrgcode());
      reportMessageContent.append(getReportMessageSingleContent(rb));

    }

    return reportMessageContent.toString();
  }

  public static String getReportMessageSingleContent(Object retailbreak) throws ParseException {
    StringTemplateGroup group = new StringTemplateGroup("seleniumGroup");//模板存储的位置
    group.setStringTemplateWriter(NoIndentWriter.class);
    group.setFileCharEncoding("utf8");//指定模板的编码，避免中文乱码问题；
    StringTemplate data = group.getInstanceOf("com/guloulou/business/templates/retailbreakPersonalBodyer");//读入模板不包括.st后缀


    data.setAttribute("Retailbreak", retailbreak);

    return data.toString();
  }

  public String persisteReportMessageToFile() {
    String fileName = generateFileName();
    if (fileName.equals("error")) {
      System.out.println("使用此方法generateFileName()之前需要 先给 sendxmlhhcode 赋值!");
      return "error";
    } else {
      File file = new File(fileName);
      /**
       * 分割一下处理，否则 附加16692次左右：内存溢出；
       */
      List<Retailbreak> retailbreaklist = (new RetailbreakPersonalServiceImpl()).getScrollData(Retailbreak.class, (getSendxmlhhcode().getJhdh())).getResultlist();
      int threadCounts = 5;
      int len = retailbreaklist.size() / threadCounts;//平均分割List
      // 没有记录
      if (retailbreaklist.isEmpty()) {
        System.out.println("该机构===[" + getSendxmlhhcode().getJhdh() + "]===木有违约记录！");
        return "该机构===[" + getSendxmlhhcode().getJhdh() + "]===木有违约记录！";
      }
      //List中的数量没有线程数多（很少存在）
      if (len == 0) {
        threadCounts = retailbreaklist.size();//采用一个线程处理List中的一个元素
        len = retailbreaklist.size() / threadCounts;//重新平均分割List
      }
      // 如果该id的机构存在违约的客户记录

      for (int i = 0; i < threadCounts; i++) {
        final List<Retailbreak> subList;
        if (i == threadCounts - 1) {
          subList = retailbreaklist.subList(i * len, retailbreaklist.size());
        } else {
          subList = retailbreaklist.subList(i * len, len * (i + 1) > retailbreaklist.size() ? retailbreaklist.size() : len * (i + 1));
        }
        list = subList;
        System.out.println("=====开始持久化报文=====");
        try {
          fileContent = getReportMessageContent();
        } catch (ParseException ex) {
          Logger.getLogger(RetailbreakPersonalHeadProcesser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
          FileUtils.writeStringToFile(file, fileContent, "UTF-8", true); //追加的方式写报文主干
        } catch (IOException ex) {
          Logger.getLogger(RetailbreakPersonalHeadProcesser.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("=====结束持久化报文=====");

      }


    }
    return "succes!";
  }

  public static void main(String[] args) throws ParseException {
    RetailbreakPersonalHeadProcesser rbphp = new RetailbreakPersonalHeadProcesser();
    RetailbreakPersonalBodyProcesser rbpbp = new RetailbreakPersonalBodyProcesser();
    RetailbreakPersonalFootProcesser rbpfp = new RetailbreakPersonalFootProcesser();

    System.out.println("============dbtest=========");
    List<Sendxmlhhcode> list = new SendxmlhhcodeServiceImpl().getScrollData(Sendxmlhhcode.class, "999999999").getResultlist();
    rbphp.setSendxmlhhcode(list.get(0));
    rbpbp.setSendxmlhhcode(list.get(0));
    rbpfp.setSendxmlhhcode(list.get(0));
    System.out.println("SendxmlhhcodeProcesser is \t " + rbphp.getReportMessageContent());
    rbphp.persisteReportMessageToFile();
    rbpbp.persisteReportMessageToFile();
    rbpfp.persisteReportMessageToFile();
  }
}
