/*
 * Document   : RetailbreakProcesser
 * Created on : 2011-10-20, 13:25:33
 * Author     : Kang.Cunhua
 */
package com.guloulou.action;

import com.guloulou.business.templates.RetailbreakPersonalBodyProcesser;
import com.guloulou.business.templates.RetailbreakPersonalFootProcesser;
import com.guloulou.business.templates.RetailbreakPersonalHeadProcesser;
import com.guloulou.model.Sendxmlhhcode;
import com.guloulou.service.sendxmlhhcode.SendxmlhhcodeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Kang.Cunhua
 */
public class RetailbreakProcesser {

  private Sendxmlhhcode sendxmlhhcode = null;
  private String fileContent = null;

  public RetailbreakProcesser() {
  }

  public String persisteReportMessageToFile() throws InterruptedException, ExecutionException {
    int threadCounts = 20;
    ExecutorService exec = Executors.newFixedThreadPool(threadCounts);
    List<Callable<String>> callList = new ArrayList<Callable<String>>();
    //得到所有的记录
    List<Sendxmlhhcode> list = (new SendxmlhhcodeServiceImpl()).getScrollData(Sendxmlhhcode.class).getResultlist();

    int len = list.size() / threadCounts;//平均分割List
    //List中的数量没有线程数多（很少存在）
    if (len == 0) {
      threadCounts = list.size();//采用一个线程处理List中的一个元素
      len = list.size() / threadCounts;//重新平均分割List
    }
    System.out.println("====================处理所有记录开始====================");
    for (int i = 0; i < threadCounts; i++) {
      final List<Sendxmlhhcode> subList;
      if (i == threadCounts - 1) {
        subList = list.subList(i * len, list.size());
        System.out.println("===001===" + i * len + "====" + list.size());
      } else {
        subList = list.subList(i * len, len * (i + 1) > list.size() ? list.size() : len * (i + 1));
        System.out.println("===002===" + i * len + "====" + len * (i + 1) + "====" + list.size() + "====");
      }
      //采用匿名内部类实现
      callList.add(new Callable<String>() {

        public String call() throws Exception {
          StringBuffer tmpstat = new StringBuffer();
          String tmp1;
          String tmp2;
          String tmp3;
          for (Sendxmlhhcode sh : subList) {
            System.out.println("开始持久化报文：" + sh.getJhdh());
            RetailbreakPersonalHeadProcesser rbphp = new RetailbreakPersonalHeadProcesser();
            RetailbreakPersonalBodyProcesser rbpbp = new RetailbreakPersonalBodyProcesser();
            RetailbreakPersonalFootProcesser rbpfp = new RetailbreakPersonalFootProcesser();

            rbphp.setSendxmlhhcode(sh);
            rbpbp.setSendxmlhhcode(sh);
            rbpfp.setSendxmlhhcode(sh);

            tmp1 = rbphp.persisteReportMessageToFile();
            tmp2 = rbpbp.persisteReportMessageToFile();
            tmp3 = rbpfp.persisteReportMessageToFile();
            tmpstat.append("===tmp1===").append(tmp1).append("===tmp2===").append(tmp2).append("===tmp3===").append(tmp3);
            //tmpstat.append("Header:").append(rbphp.persisteReportMessageToFile()).append("|Bodyer:").append(rbpbp.persisteReportMessageToFile()).append("|Footer:").append(rbpfp.persisteReportMessageToFile());
            System.out.println("结束持久化报文：" + sh.getJhdh());
          }

          System.out.println("分配给线程：" + Thread.currentThread().getName() + "该记录处理结果为：\tSubSum:" + tmpstat.toString());
          return "success";
        }
      });
    }
    List<Future<String>> futureList = exec.invokeAll(callList);
    for (Future<String> future : futureList) {
      System.out.println("线程处理结果：" + future.get());
    }
    exec.shutdown();
    System.out.println("====================处理所有记录完毕====================");
    return "success";
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

  /**
   * @return the fileContent
   */
  public String getFileContent() {
    return fileContent;
  }

  /**
   * @param fileContent the fileContent to set
   */
  public void setFileContent(String fileContent) {
    this.fileContent = fileContent;
  }

//  @Override
//  public void run() {
//    this.persisteReportMessageToFile();
//  }
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    RetailbreakProcesser retailbreakProcesser = new RetailbreakProcesser();
    retailbreakProcesser.persisteReportMessageToFile();


  }
}
