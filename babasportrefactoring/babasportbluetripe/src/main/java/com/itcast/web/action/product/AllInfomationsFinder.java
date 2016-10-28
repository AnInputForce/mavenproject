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

import com.itcast.model.PageView;
import com.itcast.model.QueryResult;
import com.itcast.model.product.Brand;
import com.itcast.model.product.Infomation;
import com.itcast.service.product.BrandService;
import com.itcast.service.product.InfomationService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Kang.Cunhua
 */
@Scope("prototype")
@Controller("/control/product/allinfomationsfinder")
public class AllInfomationsFinder extends ActionSupport {

  @Resource(name = "infomationServiceImpl")
  private transient InfomationService infomationService;
  private Infomation infomation;
  private int page = 1;
  private int firstindex;
  private LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
  private PageView<Infomation> pageview;// 页面显示对象
  private String query;




  @Override
  public String execute() {
    StringBuilder jpql = new StringBuilder(" o.visible=?1"); //定义一字符串变量存储查询条件
    List<Object> params = new ArrayList<Object>();


    setPage(page < 1 ? 1 : page);
    setPageview(new PageView<Infomation>(10, page, 6));
    setFirstindex((this.pageview.getCurrentpage() - 1) * pageview.getMaxresult());

    orderby.put("createdate", "desc");
    params.add(true);

    if ("true".equals(query)) {  // 如果来自查询页面
      jpql.append(" and o.name like ?").append(params.size() + 1);
      params.add("%" + infomation.getName() + "%"); // 此处暂时没判断输入为空的情况
      //System.out.println("type.getName()=" + type.getName());
    }

    //System.out.println("jpql=" + jpql);
    QueryResult<Infomation> qr = infomationService.getScrollData(
            Infomation.class, firstindex, pageview.getMaxresult(), jpql.toString(), params.toArray(), orderby);
    pageview.setQueryResult(qr);

    return SUCCESS;
  }

  /**
   * @return the infomationService
   */
  public InfomationService getInfomationService() {
    return infomationService;
  }

  /**
   * @param infomationService the infomationService to set
   */
  public void setInfomationService(InfomationService infomationService) {
    this.infomationService = infomationService;
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
  public PageView<Infomation> getPageview() {
    return pageview;
  }

  /**
   * @param pageview the pageview to set
   */
  public void setPageview(PageView<Infomation> pageview) {
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
