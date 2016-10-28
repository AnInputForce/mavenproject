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

import com.itcast.model.product.Brand;
import com.itcast.service.product.BrandService;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Kang.Cunhua
 */
@Scope("prototype")
@Controller("/control/product/brandupdater")
public class BrandUpdater extends ActionSupport implements ServletContextAware {

  @Resource(name = "brandServiceImpl")
  private transient BrandService brandService;
  private String message;
  private Brand brand;
  private String code;
  // 从配置文件中得到 图片保存路径
  private String savePath;
  // jsp页面doc对应三个属性，注意其set方法命名
  private File doc;
  private String fileName;
  private String contentType;
  // 得到Servlet上下文
  private ServletContext context;

  /**
   *
   * @return
   */
  @Override
  public String input() {
    brand = brandService.find(Brand.class, code);
    return INPUT;
  }

  /**
   *
   * @return
   */
  @Override
  public String execute() throws IOException {
    if (brand.getName() != null) {
      /** 处理旧图片删除和新图片上传 */
      if (doc != null && doc.length() > 0) {
        /** 处理文件上传 start */
        String targetDirectory = context.getRealPath(savePath);
        System.out.println(targetDirectory);
        String targetFileName = generateFileName(fileName);
        File target = new File(targetDirectory, targetFileName);
        FileUtils.copyFile(doc, target);
        /** 处理文件上传 end */
        /** 删除旧图片 start */
        String oldFileName = brand.getLogopath();
        oldFileName = oldFileName.substring(oldFileName.indexOf("/", 1)); //截取掉 "/upload"
        File oldFile = new File(targetDirectory, oldFileName);
        //System.out.println(oldFile.getPath());
        if (oldFile.exists()) {
          oldFile.delete();
        }
        /** 删除旧图片 end */
        brand.setLogopath(savePath + targetFileName);
      }
      brandService.update(brand);
      this.addActionMessage(":>编辑产品品牌成功!");
    } else {
      this.addActionMessage(":<出问题啦，检查下看是否填写正确！");
      return INPUT;
    }

    return SUCCESS;
  }

//  @Override
//  public void validate() {
//    if (brand.getName().length() == 0) {
//      addFieldError("brand.name", "请输入产品品牌名称！");
//    }
//  }
  /**
   * 使用UUID自动生成文件名
   * @param fileName  文件名
   * @return UUID重命名后的文件名
   */
  private String generateFileName(String fileName) {
    DateFormat format = new SimpleDateFormat("/yyyy/MM/dd/HH");
    String formatDate = format.format(new Date());
    String extension = fileName.substring(fileName.lastIndexOf("."));
    return formatDate + UUID.randomUUID().toString() + extension;
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
   *
   * @param context
   */
  @Override
  public void setServletContext(ServletContext context) {
    this.context = context;
  }

  /**
   *
   * @param fileName
   */
  public void setDocFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   *
   * @param contentType
   */
  public void setDocContentType(String contentType) {
    this.contentType = contentType;
  }

  /**
   *
   * @return
   */
  public ServletContext getContext() {
    return context;
  }

  /**
   * @param doc the doc to set
   */
  public void setDoc(File doc) {
    this.doc = doc;
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
   * @return the savePath
   */
  public String getSavePath() {
    return savePath;
  }

  /**
   * @param savePath the savePath to set
   */
  public void setSavePath(String savePath) {
    this.savePath = savePath;
  }
}
