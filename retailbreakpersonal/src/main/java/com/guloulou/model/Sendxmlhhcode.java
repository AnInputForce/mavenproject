/*
 * Document   : Sendxmlhhcode
 * Created on : 2011-10-20, 17:21:58
 * Author     : Kang.Cunhua
 */
package com.guloulou.model;

/**
 *
 * @author Kang.Cunhua
 */
public class Sendxmlhhcode {

  /* 行号 */
  private String hh;
  /* 行编号 */
  private String jhdh;
  /* 机构17位编码 */
  private String orgcode;
  /* 填报人 */
  private String fill;
  /* 机构电话 */
  private String phone;
  /* 复核人 */
  private String verify;
  /* 版本号 */
  private String version_val;
  /* 数据生成年份（4位） */
  private String year_val;
  /* 数据生成月份（2位） */
  private String month_val;

  public Sendxmlhhcode() {
  }

  public Sendxmlhhcode(String jhdh) {

    this.jhdh = jhdh;
  }

  /**
   * @return the hh
   */
  public String getHh() {
    return hh;
  }

  /**
   * @param hh the hh to set
   */
  public void setHh(String hh) {
    this.hh = hh;
  }

  /**
   * @return the jhdh
   */
  public String getJhdh() {
    return jhdh;
  }

  /**
   * @param jhdh the jhdh to set
   */
  public void setJhdh(String jhdh) {
    this.jhdh = jhdh;
  }

  /**
   * @return the orgcode
   */
  public String getOrgcode() {
    return orgcode;
  }

  /**
   * @param orgcode the orgcode to set
   */
  public void setOrgcode(String orgcode) {
    this.orgcode = orgcode;
  }

  /**
   * @return the fill
   */
  public String getFill() {
    return fill;
  }

  /**
   * @param fill the fill to set
   */
  public void setFill(String fill) {
    this.fill = fill;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * @return the verify
   */
  public String getVerify() {
    return verify;
  }

  /**
   * @param verify the verify to set
   */
  public void setVerify(String verify) {
    this.verify = verify;
  }

  /**
   * @return the version_val
   */
  public String getVersion_val() {
    return version_val;
  }

  /**
   * @param version_val the version_val to set
   */
  public void setVersion_val(String version_val) {
    this.version_val = version_val;
  }

  /**
   * @return the year_val
   */
  public String getYear_val() {
    return year_val;
  }

  /**
   * @param year_val the year_val to set
   */
  public void setYear_val(String year_val) {
    this.year_val = year_val;
  }

  /**
   * @return the month_val
   */
  public String getMonth_val() {
    return month_val;
  }

  /**
   * @param month_val the month_val to set
   */
  public void setMonth_val(String month_val) {
    this.month_val = month_val;
  }
}
