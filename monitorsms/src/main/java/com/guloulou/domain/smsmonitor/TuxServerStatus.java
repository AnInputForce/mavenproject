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
public class TuxServerStatus {

  private int hostID;
  private String hostDesc;
  private String srvname;
  private int srvnum;
  private int totalreq;
  private int maxreq;
  private int minreq;
  private int idlenum;
  private int busynum;
  private int suspendnum;
  private int othernum;
  private String updatetime;
  /**
   * 1 绿色 正常 2 黄色 告警 3 红色 失败
   */
  private int alertflag;
  private String alertContent;

  public TuxServerStatus(String hostDesc) {
    this.hostDesc = hostDesc;
  }

  public TuxServerStatus() {
  }

  /**
   * @return the hostID
   */
  public int getHostID() {
    return hostID;
  }

  /**
   * @param hostID the hostID to set
   */
  public void setHostID(int hostID) {
    this.hostID = hostID;
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
   * @return the srvname
   */
  public String getSrvname() {
    return srvname;
  }

  /**
   * @param srvname the srvname to set
   */
  public void setSrvname(String srvname) {
    this.srvname = srvname;
  }

  /**
   * @return the srvnum
   */
  public int getSrvnum() {
    return srvnum;
  }

  /**
   * @param srvnum the srvnum to set
   */
  public void setSrvnum(int srvnum) {
    this.srvnum = srvnum;
  }

  /**
   * @return the totalreq
   */
  public int getTotalreq() {
    return totalreq;
  }

  /**
   * @param totalreq the totalreq to set
   */
  public void setTotalreq(int totalreq) {
    this.totalreq = totalreq;
  }

  /**
   * @return the maxreq
   */
  public int getMaxreq() {
    return maxreq;
  }

  /**
   * @param maxreq the maxreq to set
   */
  public void setMaxreq(int maxreq) {
    this.maxreq = maxreq;
  }

  /**
   * @return the minreq
   */
  public int getMinreq() {
    return minreq;
  }

  /**
   * @param minreq the minreq to set
   */
  public void setMinreq(int minreq) {
    this.minreq = minreq;
  }

  /**
   * @return the idlenum
   */
  public int getIdlenum() {
    return idlenum;
  }

  /**
   * @param idlenum the idlenum to set
   */
  public void setIdlenum(int idlenum) {
    this.idlenum = idlenum;
  }

  /**
   * @return the busynum
   */
  public int getBusynum() {
    return busynum;
  }

  /**
   * @param busynum the busynum to set
   */
  public void setBusynum(int busynum) {
    this.busynum = busynum;
  }

  /**
   * @return the suspendnum
   */
  public int getSuspendnum() {
    return suspendnum;
  }

  /**
   * @param suspendnum the suspendnum to set
   */
  public void setSuspendnum(int suspendnum) {
    this.suspendnum = suspendnum;
  }

  /**
   * @return the othernum
   */
  public int getOthernum() {
    return othernum;
  }

  /**
   * @param othernum the othernum to set
   */
  public void setOthernum(int othernum) {
    this.othernum = othernum;
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
}
