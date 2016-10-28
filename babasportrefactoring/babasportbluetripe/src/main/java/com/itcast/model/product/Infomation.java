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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 产品信息
 * @author Kang.Cunhua
 */
@Entity
@Table(name = "productinfomation") //指定表名为productinfomation
public class Infomation implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;
  /* 货号 */
  @Column(length = 30)
  private String code;
  /* 产品名称 */
  @Column(length = 50, nullable = false)
  private String name;
  /* 产品品牌 */
  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "brandid")
  private Brand brand;
  /* 型号 */
  @Column(length = 20)
  private String model;
  /* 底价（采购进来的价格） */
  @Column(nullable = false)
  private Float baseprice;
  /* 市场价 */
  @Column(nullable = false)
  private Float markprice;
  /* 销售价 */
  @Column(nullable = false)
  private Float sellprice;
  /* 重量 单位：克 */
  private Integer weight;
  /* 产品简介 */
  @Lob // 大文本
  @Column(nullable = false)
  private String description;
  /* 购买说明 */
  @Column(length = 30)
  private String buyexplain;  // explain 居然是mysql关键字
  /* 是否可见 */
  @Column(nullable = false)
  private Boolean visible = true;
  /* 产品类型 */
  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "typeid")
  private Type type;
  /* 上架日期 */
  @Temporal(TemporalType.DATE)
  private Date createdate = new Date();
  /* 人气指数 */
  @Column(nullable = false)
  private Integer clickcount = 1;
  /* 销售量 */
  @Column(nullable = false)
  private Integer sellcount = 0;
  /* 是否推荐 */
  @Column(nullable = false)
  private Boolean commend = false;
  /* 性别要求 */
  @Enumerated(EnumType.STRING)
  @Column(length = 5, nullable = false)
  private Sex sexrequest = Sex.NONE;
  /* 产品样式 */
  @OneToMany(mappedBy = "infomation", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
  private Set<Style> styles = new HashSet<Style>();

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
   * @return the brand
   */
  public Brand getBrand() {
    return brand;
  }

  /**
   * @param brand the brand to set
   */
  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  /**
   * @return the baseprice
   */
  public Float getBaseprice() {
    return baseprice;
  }

  /**
   * @param baseprice the baseprice to set
   */
  public void setBaseprice(Float baseprice) {
    this.baseprice = baseprice;
  }

  /**
   * @return the markprice
   */
  public Float getMarkprice() {
    return markprice;
  }

  /**
   * @param markprice the markprice to set
   */
  public void setMarkprice(Float markprice) {
    this.markprice = markprice;
  }

  /**
   * @return the sellprice
   */
  public Float getSellprice() {
    return sellprice;
  }

  /**
   * @param sellprice the sellprice to set
   */
  public void setSellprice(Float sellprice) {
    this.sellprice = sellprice;
  }

  /**
   * @return the weight
   */
  public Integer getWeight() {
    return weight;
  }

  /**
   * @param weight the weight to set
   */
  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
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
   * @return the type
   */
  public Type getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(Type type) {
    this.type = type;
  }

  /**
   * @return the createdate
   */
  public Date getCreatedate() {
    return createdate;
  }

  /**
   * @param createdate the createdate to set
   */
  public void setCreatedate(Date createdate) {
    this.createdate = createdate;
  }

  /**
   * @return the clickcount
   */
  public Integer getClickcount() {
    return clickcount;
  }

  /**
   * @param clickcount the clickcount to set
   */
  public void setClickcount(Integer clickcount) {
    this.clickcount = clickcount;
  }

  /**
   * @return the sellcount
   */
  public Integer getSellcount() {
    return sellcount;
  }

  /**
   * @param sellcount the sellcount to set
   */
  public void setSellcount(Integer sellcount) {
    this.sellcount = sellcount;
  }

  /**
   * @return the commend
   */
  public Boolean getCommend() {
    return commend;
  }

  /**
   * @param commend the commend to set
   */
  public void setCommend(Boolean commend) {
    this.commend = commend;
  }

  /**
   * @return the sexrequest
   */
  public Sex getSexrequest() {
    return sexrequest;
  }

  /**
   * @param sexrequest the sexrequest to set
   */
  public void setSexrequest(Sex sexrequest) {
    this.sexrequest = sexrequest;
  }

  /**
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * @param model the model to set
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * @return the styles
   */
  public Set<Style> getStyles() {
    return styles;
  }

  /**
   * @param styles the styles to set
   */
  public void setStyles(Set<Style> styles) {
    this.styles = styles;
  }

  /**
   * 添加样式到样式集合
   * @param style
   */
  public void addProductStyle(Style style) {
    if (!this.styles.contains(style)) {
      this.styles.add(style);
      style.setInfomation(this);
    }
  }

  /**
   * 删除样式从样式集合
   * @param style
   */
  public void removeProductStyle(Style style) {
    if (this.styles.contains(style)) {
      this.styles.remove(style);
      style.setInfomation(null);
    }
  }

  /**
   * @return the buyexplain
   */
  public String getBuyexplain() {
    return buyexplain;
  }

  /**
   * @param buyexplain the buyexplain to set
   */
  public void setBuyexplain(String buyexplain) {
    this.buyexplain = buyexplain;
  }
}
