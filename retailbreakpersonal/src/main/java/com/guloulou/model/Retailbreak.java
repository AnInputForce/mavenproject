/*
 * Document   : Retailbreak
 * Created on : 2011-10-20, 13:26:00
 * Author     : Kang.Cunhua
 */
package com.guloulou.model;

/**
 * 零售贷款违约个人客户情况统计表
 * @author Kang.Cunhua
 */
public class Retailbreak {

  /* 行编号 */
  private String jhdh;
  /* 报送机构编码 */
  private String orgcode;
  /* 证件类型 */
  private String identification_type;
  /* 证件号码 */
  private String customer_code;
  /* 客户名称 */
  private String customer_name;
  /* 客户所在地 */
  private String customer_area;
  /* 区划代码 */
  private String region_code;
  /* 违约类型 */
  private String break_type;
  /* 违约天数 */
  private Integer break_time;

  public Retailbreak() {
  }

  public Retailbreak(String jhdh) {
    this.jhdh = jhdh;
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
   * @return the identification_type
   */
  public String getIdentification_type() {
    return identification_type;
  }

  /**
   * @param identification_type the identification_type to set
   */
  public void setIdentification_type(String identification_type) {
    this.identification_type = identification_type;
  }

  /**
   * @return the customer_code
   */
  public String getCustomer_code() {
    return customer_code;
  }

  /**
   * @param customer_code the customer_code to set
   */
  public void setCustomer_code(String customer_code) {
    this.customer_code = customer_code;
  }

  /**
   * @return the customer_name
   */
  public String getCustomer_name() {
    return customer_name;
  }

  /**
   * @param customer_name the customer_name to set
   */
  public void setCustomer_name(String customer_name) {
    this.customer_name = customer_name;
  }

  /**
   * @return the customer_area
   */
  public String getCustomer_area() {
    return customer_area;
  }

  /**
   * @param customer_area the customer_area to set
   */
  public void setCustomer_area(String customer_area) {
    this.customer_area = customer_area;
  }

  /**
   * @return the region_code
   */
  public String getRegion_code() {
    return region_code;
  }

  /**
   * @param region_code the region_code to set
   */
  public void setRegion_code(String region_code) {
    this.region_code = region_code;
  }

  /**
   * @return the break_type
   */
  public String getBreak_type() {
    return break_type;
  }

  /**
   * @param break_type the break_type to set
   */
  public void setBreak_type(String break_type) {
    this.break_type = break_type;
  }

  /**
   * @return the break_time
   */
  public Integer getBreak_time() {
    return break_time;
  }

  /**
   * @param break_time the break_time to set
   */
  public void setBreak_time(Integer break_time) {
    this.break_time = break_time;
  }
}
