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
package com.itcast.model.product;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 产品品牌
 * @author Kang.Cunhua
 */
@Entity
@Table(name = "productbrand") //指定表名为productbrand
public class Brand implements Serializable {

  /** 品牌编号 */
  @Id
  @Column(length = 36)
  private String code;
  /** 品牌名称 */
  @Column(length = 40, nullable = false)
  private String name;
  /** 是否显示 */
  @Column(nullable = false)
  private Boolean visible = true;
  /** 商标路径 */
  @Column(length = 80)
  private String logopath;
  @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
  /** 商品信息 */
  private List<Infomation> infomations;

  public Brand() {
  }

  /**
   *
   * @param name
   */
  public Brand(String name) {
    this.name = name;
  }

  public Brand(String name, String logopath) {
    this.name = name;
    this.logopath = logopath;
  }

  /**
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(String code) {
    this.code = code;
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
   * @return the logopath
   */
  public String getLogopath() {
    return logopath;
  }

  /**
   * @param logopath the logopath to set
   */
  public void setLogopath(String logopath) {
    this.logopath = logopath;
  }

  public List<Infomation> getInfomations() {
    return infomations;
  }

  public void setInfomations(List<Infomation> infomations) {
    this.infomations = infomations;
  }
}
