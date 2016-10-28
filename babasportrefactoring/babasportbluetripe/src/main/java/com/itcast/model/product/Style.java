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
package com.itcast.model.product;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 产品样式
 * @author Kang.Cunhua
 */
@Entity
@Table(name = "productstyle") //指定表名为productstyle
public class Style implements Serializable {

  @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
  @JoinColumn(name = "productinfomationid")
  private Infomation infomation;
  @Id
  @GeneratedValue
  private Integer id;
  @Column(length = 30, nullable = false)
  private String name;
  @Column(length = 40, nullable = false)
  private String imagename;
  private Boolean visible = true;

  public Style() {
  }

  public Style(String name, String imagename) {
    this.name = name;
    this.imagename = imagename;
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
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the imagename
   */
  public String getImagename() {
    return imagename;
  }

  /**
   * @param imagename the imagename to set
   */
  public void setImagename(String imagename) {
    this.imagename = imagename;
  }

  /**
   * @return the visible
   */
  public Boolean getVisible() {
    return visible;
  }

  /**
   * @param visible the visible to set
   */
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  /**
   * @return the infomation
   */
  public Infomation getInfomation() {
    return infomation;
  }

  /**
   * @param infomation the infomation to set
   */
  public void setInfomation(Infomation infomation) {
    this.infomation = infomation;
  }
}
