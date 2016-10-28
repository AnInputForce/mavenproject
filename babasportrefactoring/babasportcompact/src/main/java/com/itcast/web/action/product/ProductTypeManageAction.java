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
package com.itcast.web.action.product;

import com.itcast.bean.product.ProductType;
import com.itcast.service.product.ProductTypeService;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Kang.Cunhua
 */
@Scope("prototype")
@Controller("/control/product/type/manage")
public class ProductTypeManageAction {

  @Resource(name = "productTypeServiceBean")
  private ProductTypeService productTypeService;
  private String message;
  private ProductType productType;
  private Integer typeid;
  private Integer parentid;

  /**
   * Use the emplid value that was provided
   * when the user clicked on the edit link
   * get the associated Person object.
   *
   */
//  public String input() {
//
//    productType = productTypeService.find(ProductType.class, getTypeid());
//
//    return "input";
//
//  }
  public String addUI() {

    return "add";
  }

  public String editUI() {
    productType = productTypeService.find(ProductType.class, typeid);
    return "edit";
  }

  public String productTypeAdd() {
    // struts2默认会给父id赋值为0，当父id不存在的时候
    if (parentid != null && parentid > 0) {
      productType.setParent(new ProductType(parentid));
    }

    if (productType.getName() != null && !productType.getName().trim().isEmpty()) {
//      System.out.println("productType.getName()=" + productType.getName());
      productTypeService.save(productType);
      this.setMessage(":>添加产品类型成功!");
    } else {
      this.setMessage(":<出问题啦，检查下看是否填写正确！");
    }
    return "message";
  }

  public String productTypeEdit() {

    if (productType.getName() != null) {
      productTypeService.update(productType);
    }
    this.setMessage("编辑产品类型成功");
    return "message";
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the productType
   */
  public ProductType getProductType() {
    return productType;
  }

  /**
   * @param productType the productType to set
   */
  public void setProductType(ProductType productType) {
    this.productType = productType;
  }

  /**
   * @return the typeid
   */
  public Integer getTypeid() {
    return typeid;
  }

  /**
   * @param typeid the typeid to set
   */
  public void setTypeid(Integer typeid) {
    this.typeid = typeid;
  }

  /**
   * @return the parentid
   */
  public Integer getParentid() {
    return parentid;
  }

  /**
   * @param parentid the parentid to set
   */
  public void setParentid(Integer parentid) {
    this.parentid = parentid;
  }
}
