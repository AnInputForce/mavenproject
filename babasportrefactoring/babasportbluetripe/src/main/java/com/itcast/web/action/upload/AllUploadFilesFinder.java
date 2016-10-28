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
package com.itcast.web.action.upload;

import com.itcast.model.PageView;
import com.itcast.model.QueryResult;
import com.itcast.model.upload.UploadFile;
import com.itcast.service.upload.UploadFileService;
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
@Controller("/control/upload/alluploadFilefinder")
public class AllUploadFilesFinder extends ActionSupport {

  @Resource(name = "uploadFileServiceImpl")
  private transient UploadFileService uploadFileService;
  private UploadFile uploadFile;
  private String message;
  private int page = 1;
  private int firstindex;
  private LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
  private PageView<UploadFile> pageview;// 页面显示对象
  private String query;

  /**
   * 产品类型列表显示
   * @return
   */
  @Override
  public String execute() {

    StringBuilder jpql = new StringBuilder(" o.id > ?1"); //定义一字符串变量存储查询条件
    List<Object> params = new ArrayList<Object>();


    setPage(page < 1 ? 1 : page);
    setPageview(new PageView<UploadFile>(10, page, 6));
    setFirstindex((this.pageview.getCurrentpage() - 1) * pageview.getMaxresult());

    orderby.put("uploadtime", "desc");
    params.add(0);

    if ("true".equals(query)) {  // 如果来自查询页面
      if (uploadFile.getOldname() == null || "".equals(uploadFile.getOldname())) {
        this.addActionMessage(":>请输入要查询的文件名!");
      } else {
        jpql.append(" and o.oldname like ?").append(params.size() + 1);
        params.add("%" + uploadFile.getOldname() + "%"); // 此处暂时没判断输入为空的情况
        //System.out.println("type.getName()=" + type.getName());
        this.addActionMessage(":>查询成功!");
      }
    }

    //System.out.println("jpql=" + jpql);
    QueryResult<UploadFile> qr = uploadFileService.getScrollData(
            UploadFile.class, firstindex, pageview.getMaxresult(), jpql.toString(), params.toArray(), orderby);
    pageview.setQueryResult(qr);

    return SUCCESS;
  }

  /**
   * @return the uploadFileService
   */
  public UploadFileService getUploadFileService() {
    return uploadFileService;
  }

  /**
   * @param uploadFileService the uploadFileService to set
   */
  public void setUploadFileService(UploadFileService uploadFileService) {
    this.uploadFileService = uploadFileService;
  }

  /**
   * @return the uploadFile
   */
  public UploadFile getUploadFile() {
    return uploadFile;
  }

  /**
   * @param uploadFile the uploadFile to set
   */
  public void setUploadFile(UploadFile uploadFile) {
    this.uploadFile = uploadFile;
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
  public PageView<UploadFile> getPageview() {
    return pageview;
  }

  /**
   * @param pageview the pageview to set
   */
  public void setPageview(PageView<UploadFile> pageview) {
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
