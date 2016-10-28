/*
 * Document   : ReportMessageProcesser
 * Created on : 2011-10-20, 13:17:56
 * Author     : Kang.Cunhua
 */
package com.guloulou.business.templates;

/**
 *
 * @author Kang.Cunhua
 */
public interface ReportMessageProcesser {

  public String getReportMessageContent() throws java.text.ParseException;

  public String persisteReportMessageToFile();

  public String generateFileName();
}
