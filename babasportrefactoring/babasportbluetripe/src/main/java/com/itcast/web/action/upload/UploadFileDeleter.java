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

import com.itcast.model.upload.UploadFile;
import com.itcast.service.upload.UploadFileService;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Kang.Cunhua
 */
@Scope("prototype")
@Controller("/control/upload/uploadfiledeleter")
public class UploadFileDeleter extends ActionSupport {

  @Resource(name = "uploadFileServiceImpl")
  private transient UploadFileService uploadFileService;
  private UploadFile uploadFileTmp;
  private long[] selectedids = new long[]{};
  // 从配置文件中得到 图片保存路径
  private String savePath;
  // 得到Servlet上下文 ：和上传 action 不同，此处需要手工赋值
  private ServletContext context = ServletActionContext.getServletContext();

  @Override
  public String execute() throws Exception {
    System.out.println("所选ids:");
    for (int i = 0; i < this.selectedids.length; i++) {
      //得到对象,删除对应文件
      uploadFileTmp = uploadFileService.find(UploadFile.class, (int) selectedids[i]);
      delSelectedUploadFile();
      // 删除数据库记录
      uploadFileService.delete(UploadFile.class, (int) selectedids[i]);

      System.out.println("删除文件id=" + (int) selectedids[i] + "成功！");
    }
    this.addActionMessage(":>删除所选文件成功!");
    return SUCCESS;
  }

  private void delSelectedUploadFile() {
    System.out.println("savepath:" + savePath);
    System.out.println("context:" + context);
    String targetDirectory = context.getRealPath(savePath);
    /** 删除文件 start */
    String oldFileName = uploadFileTmp.getFilepath();
    oldFileName = oldFileName.substring(oldFileName.indexOf("/", 1)); //截取掉 "/upload"
    File oldFile = new File(targetDirectory, oldFileName);
    //System.out.println(oldFile.getPath());
    if (oldFile.exists()) {
      oldFile.delete();
    }
    /** 删除文件 end */
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
   * @return the context
   */
  public ServletContext getContext() {
    return context;
  }

  /**
   * @param context the context to set
   */
  public void setContext(ServletContext context) {
    this.context = context;
  }

  /**
   * @return the selectedids
   */
  public long[] getSelectedids() {
    return selectedids;
  }

  /**
   * @param selectedids the selectedids to set
   */
  public void setSelectedids(long[] selectedids) {
    this.selectedids = selectedids;
  }

  /**
   * @return the uploadFileTmp
   */
  public UploadFile getUploadFileTmp() {
    return uploadFileTmp;
  }

  /**
   * @param uploadFileTmp the uploadFileTmp to set
   */
  public void setUploadFileTmp(UploadFile uploadFileTmp) {
    this.uploadFileTmp = uploadFileTmp;
  }
}
