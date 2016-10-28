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
package com.itcast.web.action.product;

import com.itcast.model.product.Brand;
import com.itcast.model.product.Infomation;
import com.itcast.service.product.BrandService;
import com.itcast.service.product.InfomationService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Kang.Cunhua
 */
@Scope("prototype")
@Controller("/control/product/infomationsaver")
public class InfomationSaver extends ActionSupport {

  @Resource(name = "infomationServiceImpl")
  private transient InfomationService infomationService;
  private String message;
  private Infomation infomation;
  @Resource(name = "brandServiceImpl")
  private transient BrandService brandService;
  private List<Brand> brands;

  @Override
  public String input() {
    this.brands = brandService.getScrollData(Brand.class).getResultlist();
    System.out.println("brands 's num:" + brands.size());
    return INPUT;
  }

  public String selecttype() {
    System.out.println("current method is : selecttype()");
    return "selecttype";
  }

  @Override
  public String execute() {

    if (infomation.getName() != null && !infomation.getName().trim().isEmpty()) {
//      System.out.println("type.getName()=" + type.getName());
      infomationService.save(infomation);
      this.addActionMessage(":>添加产品类型成功!");
    } else {
      this.addActionMessage(":<出问题啦，检查下看是否填写正确！");
      return INPUT;
    }
    return SUCCESS;
  }

  /**
   * @return the brandService
   */
  public BrandService getBrandService() {
    return brandService;
  }

  /**
   * @param brandService the brandService to set
   */
  public void setBrandService(BrandService brandService) {
    this.brandService = brandService;
  }

  /**
   * @return the brands
   */
  public List<Brand> getBrands() {
    return brands;
  }

  /**
   * @param brands the brands to set
   */
  public void setBrands(List<Brand> brands) {
    this.brands = brands;
  }
}
