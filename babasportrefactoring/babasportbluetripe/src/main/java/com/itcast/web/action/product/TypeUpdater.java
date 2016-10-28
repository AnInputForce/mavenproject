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

import com.itcast.model.product.Type;
import com.itcast.service.product.TypeService;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Kang.Cunhua
 */
@Scope("prototype")
@Controller("/control/product/typeupdater")
public class TypeUpdater extends ActionSupport {

  @Resource(name = "typeServiceImpl")
  private transient TypeService typeService;
  private String message;
  private Type type;
  private Integer typeid;
  private Integer parentid;

  /**
   *
   * @return
   */
  @Override
  public String input() {
    type = typeService.find(Type.class, typeid);
    return INPUT;
  }

  /**
   *
   * @return
   */
  @Override
  public String execute() {
    if (type.getName() != null) {
      typeService.update(type);
      this.addActionMessage(":>编辑产品类型成功");
    } else {
      this.addActionMessage(":<出问题啦，检查下看是否填写正确！");
      return INPUT;
    }

    return SUCCESS;
  }

  /**
   * @return the typeService
   */
  public TypeService getTypeService() {
    return typeService;
  }

  /**
   * @param typeService the typeService to set
   */
  public void setTypeService(TypeService typeService) {
    this.typeService = typeService;
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
}
