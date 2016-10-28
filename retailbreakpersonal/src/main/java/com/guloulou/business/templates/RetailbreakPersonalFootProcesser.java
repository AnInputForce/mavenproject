/*
 * Document   : RetailbreakPersonalFootProcesser
 * Created on : 2011-10-22, 13:26:20
 * Author     : Kang.Cunhua
 */
package com.guloulou.business.templates;

import com.guloulou.model.Sendxmlhhcode;
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
public class RetailbreakPersonalFootProcesser extends ReportMessageProcesserSupport {

  public RetailbreakPersonalFootProcesser() {
  }

  public String getReportMessageContent() throws ParseException {
    StringTemplateGroup group = new StringTemplateGroup("seleniumGroup");//模板存储的位置
    group.setStringTemplateWriter(NoIndentWriter.class);
    group.setFileCharEncoding("utf8");//指定模板的编码，避免中文乱码问题；
    StringTemplate data = group.getInstanceOf("com/guloulou/business/templates/retailbreakPersonalFooter");//读入模板不包括.st后缀
    //retailbreakPersonalFooter.st

    // 底部模板无替换内容
    //data.setAttribute("Sendxmlhhcode", (Sendxmlhhcode) sendxmlhhcode);

    return data.toString();
  }

  public String persisteReportMessageToFile() {
    String fileName = generateFileName();
    if (fileName.equals("error")) {
      System.out.println("使用此方法generateFileName()之前需要 先给 sendxmlhhcode 赋值!");
      return "error";
    } else {
      File file = new File(fileName);
      System.out.println("=====开始持久化报文=====");
      try {
        fileContent = getReportMessageContent();
      } catch (ParseException ex) {
        Logger.getLogger(RetailbreakPersonalHeadProcesser.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
        FileUtils.writeStringToFile(file, fileContent, "UTF-8", true); //追加的方式写报文结尾
      } catch (IOException ex) {
        Logger.getLogger(RetailbreakPersonalHeadProcesser.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println("fileContent is =" + fileContent);
      System.out.println("=====结束持久化报文=====");
      return "success";
    }
  }

  public static void main(String[] args) throws ParseException {



    Sendxmlhhcode sxc = new Sendxmlhhcode();
    sxc.setFill("Fill康存化");
    sxc.setHh("01211017");
    sxc.setJhdh("10001");
    sxc.setMonth_val("10");
    sxc.setOrgcode("0001");
    sxc.setPhone("13718775407");
    sxc.setVerify("谭老");
    sxc.setVersion_val("20101020");
    sxc.setYear_val("2010");

    System.out.println("SendxmlhhcodeProcesser is " + new RetailbreakPersonalHeadProcesser().getReportMessageContent());

    System.out.println("==========static test========");
    // List<Sendxmlhhcode> list = new SendxmlhhcodeServiceImpl().getScrollData(Sendxmlhhcode.class, "999999999").getResultlist();
    RetailbreakPersonalFootProcesser rbpfp = new RetailbreakPersonalFootProcesser();
    rbpfp.setSendxmlhhcode(sxc);
    System.out.println("SendxmlhhcodeProcesser is \t " + rbpfp.getReportMessageContent());
    rbpfp.persisteReportMessageToFile();
    System.out.println("============dbtest=========");
    List<Sendxmlhhcode> list = new SendxmlhhcodeServiceImpl().getScrollData(Sendxmlhhcode.class, "999999999").getResultlist();
    rbpfp.setSendxmlhhcode(list.get(0));
    System.out.println("SendxmlhhcodeProcesser is \t " + rbpfp.getReportMessageContent());
    rbpfp.persisteReportMessageToFile();
  }
}
