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
package com.guloulou.domain.smsmonitor;

/**
 *
 * @author Kang.Cunhua
 */
public class TuxDomainStatus {

  // 统计alertflag是否同时有两个，为partA发短信做判断
  private int num;
  private String hostDesc;
  private String ldomain;
  private String rdomain;
  private int dmstate;
  private String updatetime;
  private int alertflag;
  private String alertContent;

  public TuxDomainStatus() {
  }

  public TuxDomainStatus(String rdomain) {
    this.rdomain = rdomain;
  }

  /**
   * @return the hostDesc
   */
  public String getHostDesc() {
    return hostDesc;
  }

  /**
   * @param hostDesc the hostDesc to set
   */
  public void setHostDesc(String hostDesc) {
    this.hostDesc = hostDesc;
  }

  /**
   * @return the ldomain
   */
  public String getLdomain() {
    return ldomain;
  }

  /**
   * @param ldomain the ldomain to set
   */
  public void setLdomain(String ldomain) {
    this.ldomain = ldomain;
  }

  /**
   * @return the rdomain
   */
  public String getRdomain() {
    return rdomain;
  }

  /**
   * @param rdomain the rdomain to set
   */
  public void setRdomain(String rdomain) {
    this.rdomain = rdomain;
  }

  /**
   * @return the dmstate
   */
  public int getDmstate() {
    return dmstate;
  }

  /**
   * @param dmstate the dmstate to set
   */
  public void setDmstate(int dmstate) {
    this.dmstate = dmstate;
  }

  /**
   * @return the updatetime
   */
  public String getUpdatetime() {
    return updatetime;
  }

  /**
   * @param updatetime the updatetime to set
   */
  public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
  }

  /**
   * @return the alertflag
   */
  public int getAlertflag() {
    return alertflag;
  }

  /**
   * @param alertflag the alertflag to set
   */
  public void setAlertflag(int alertflag) {
    this.alertflag = alertflag;
  }

  /**
   * @return the alertContent
   */
  public String getAlertContent() {
    return alertContent;
  }

  /**
   * @param alertContent the alertContent to set
   */
  public void setAlertContent(String alertContent) {
    this.alertContent = alertContent;
  }

  /**
   * @return the num
   */
  public int getNum() {
    return num;
  }

  /**
   * @param num the num to set
   */
  public void setNum(int num) {
    this.num = num;
  }
}
