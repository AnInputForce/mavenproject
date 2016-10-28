/*
 * Copyright 2011 待到道成日，纵横天地间.
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
package com.itcast.model.upload;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kang.Cunhua
 */
@Entity
public class UploadFile implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;
  @Column(nullable = false, length = 80)
  private String filepath;
  @Column(nullable = false, length = 20)
  private String oldname;
  @Column(nullable = false)
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date uploadtime;

  public UploadFile() {
    // 设置默认的上传时间
    this.uploadtime = new Date();
  }

  public UploadFile(String filepath) {
    // 设置默认的上传时间
    this.uploadtime = new Date();
    this.filepath = filepath;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the filepath
   */
  public String getFilepath() {
    return filepath;
  }

  /**
   * @param filepath the filepath to set
   */
  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  /**
   * @return the uploadtime
   */
  public Date getUploadtime() {
    return uploadtime;
  }

  /**
   * @param uploadtime the uploadtime to set
   */
  public void setUploadtime(Date uploadtime) {
    this.uploadtime = uploadtime;
  }

  /**
   * @return the oldname
   */
  public String getOldname() {
    return oldname;
  }

  /**
   * @param oldname the oldname to set
   */
  public void setOldname(String oldname) {
    this.oldname = oldname;
  }


}
