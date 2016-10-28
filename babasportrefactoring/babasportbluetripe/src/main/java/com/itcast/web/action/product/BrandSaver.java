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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Kang.Cunhua
 */
@Scope("prototype")
@Controller("/control/product/brandsaver")
public class BrandSaver extends ActionSupport implements ServletContextAware {

  @Resource(name = "brandServiceImpl")
  private transient BrandService brandService;
  private String message;
  private Brand brand;
  // 从配置文件中得到 图片保存路径
  private String savePath;
  // jsp页面doc对应三个属性，注意其set方法命名
  private File doc;
  private String fileName;
  private String contentType;
  // 得到Servlet上下文
  private ServletContext context;

  /**
   * Struts2使用开源项目Apache Jakarta Commons FileUpload和内建的FileUploadInterceptor拦截器实现文件上传
   * 在**inputbrandsaver.jsp中，只有doc一个字段，而BrandAction.java中，却有三个字段，
   * Struts2怎么通过页面的一个字段设置Action里的三个字段呢？没错，这就是FileUploadInterceptor的功劳了！
   * 你所要做的只是按照一定的样式命名这三个字段的set方法，而字段名可以任意命名。
   * 第一个File类型的字段的set方法还是以常规的方式命名，
   * 另两个String类型的字段的set方法必须分别以  File字段的set方法名+FileName 和  File字段的set方法名+ContentType 来命名。
   *
   * @return
   * @throws IOException
   */
  @Override
  public String execute() throws IOException {
    if (brand.getName() != null && !brand.getName().trim().isEmpty()) {
      /** 处理文件上传 start */
      if (getDoc() != null && getDoc().length() > 0) {
        String targetDirectory = context.getRealPath(savePath);
        String targetFileName = generateFileName(fileName);
        File target = new File(targetDirectory, targetFileName);

        FileUtils.copyFile(getDoc(), target);
        /** 处理文件上传 end */
        brand.setLogopath(savePath + targetFileName);
        brandService.save(brand);
        this.addActionMessage(":>添加产品品牌成功!");
      } else {
        this.addActionMessage(":>请选择要上传的文件!");
        return INPUT;
      }
    } else {
      this.addActionMessage(":<出问题啦，检查下看是否填写正确！");
      return INPUT;
    }
    return SUCCESS;
  }

  /**
   * 使用UUID自动生成文件名
   * @param fileName  文件名
   * @return UUID重命名后的文件名
   */
  private String generateFileName(String fileName) {
    DateFormat format = new SimpleDateFormat("/yyyy/MM/dd/HH");
    String formatDate = format.format(new Date());
    //此处 需要添加 无后缀名时空指针判断
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

  /**
   * @return the doc
   */
  public File getDoc() {
    return doc;
  }
}
