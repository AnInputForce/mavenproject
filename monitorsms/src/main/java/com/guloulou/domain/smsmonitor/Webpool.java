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
public class Webpool {

  private String ipaddr;
  private int status;
  private int port;
  private String demo;
  private String systime;

  public Webpool() {
  }

  public Webpool(String ipaddr) {
    this.ipaddr = ipaddr;
  }

  public String getIpaddr() {
    return this.ipaddr;
  }

  public void setIpaddr(String ipaddr) {
    this.ipaddr = ipaddr;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getPort() {
    return this.port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getDemo() {
    return this.demo;
  }

  public void setDemo(String demo) {
    this.demo = demo;
  }

  public String getSystime() {
    return this.systime;
  }

  public void setSystime(String systime) {
    this.systime = systime;
  }
}
