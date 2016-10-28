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

import com.itcast.model.PageView;
import com.itcast.model.QueryResult;
import com.itcast.model.product.Brand;
import com.itcast.service.product.BrandService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Kang.Cunhua
 */
@Scope("prototype")
@Controller("/control/product/allbrandsfinder")
public class AllBrandsFinder extends ActionSupport {

  @Resource(name="brandServiceImpl")
  private transient BrandService brandService;
  private Brand brand;
  private String message;
  private int page = 1;
  private int firstindex;
  private LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
  private PageView<Brand> pageview;// 页面显示对象
  private String query;

  /**
   * 产品类型列表显示
   * @return
   */
  @Override
  public String execute() {

    StringBuilder jpql = new StringBuilder(" o.visible=?1"); //定义一字符串变量存储查询条件
    List<Object> params = new ArrayList<Object>();


    setPage(page < 1 ? 1 : page);
    setPageview(new PageView<Brand>(10, page, 6));
    setFirstindex((this.pageview.getCurrentpage() - 1) * pageview.getMaxresult());

    orderby.put("logopath", "desc");
    params.add(true);

    if ("true".equals(query)) {  // 如果来自查询页面
      jpql.append(" and o.name like ?").append(params.size() + 1);
      params.add("%" + brand.getName() + "%"); // 此处暂时没判断输入为空的情况
      //System.out.println("type.getName()=" + type.getName());
    }

    //System.out.println("jpql=" + jpql);
    QueryResult<Brand> qr = brandService.getScrollData(
            Brand.class, firstindex, pageview.getMaxresult(), jpql.toString(), params.toArray(), orderby);
    pageview.setQueryResult(qr);

    return SUCCESS;
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
   * @return the page
   */
  public int getPage() {
    return page;
  }

  /**
   * @param page the page to set
   */
  public void setPage(int page) {
    this.page = page;
  }

  /**
   * @return the firstindex
   */
  public int getFirstindex() {
    return firstindex;
  }

  /**
   * @param firstindex the firstindex to set
   */
  public void setFirstindex(int firstindex) {
    this.firstindex = firstindex;
  }

  /**
   * @return the orderby
   */
  public LinkedHashMap<String, String> getOrderby() {
    return orderby;
  }

  /**
   * @param orderby the orderby to set
   */
  public void setOrderby(LinkedHashMap<String, String> orderby) {
    this.orderby = orderby;
  }

  /**
   * @return the pageview
   */
  public PageView<Brand> getPageview() {
    return pageview;
  }

  /**
   * @param pageview the pageview to set
   */
  public void setPageview(PageView<Brand> pageview) {
    this.pageview = pageview;
  }

  /**
   * @return the query
   */
  public String getQuery() {
    return query;
  }

  /**
   * @param query the query to set
   */
  public void setQuery(String query) {
    this.query = query;
  }
}
