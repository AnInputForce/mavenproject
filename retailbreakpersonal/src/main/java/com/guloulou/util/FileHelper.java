/*
 * Document   : FileHelper
 * Created on : 2011-10-20, 13:03:12
 * Author     : Kang.Cunhua
 */
package com.guloulou.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kang.Cunhua
 */
public class FileHelper {

  private File doc;
  private String fileName;
  private String savePath = "/upload";

  public FileHelper() {
  }

  public String creatFile() throws IOException {

    /** 处理文件上传 start */
    String targetDirectory = "/upload";//得到上传路径context.getRealPath(savePath);
    String targetFileName = generateFileName(fileName);
    File target = new File(targetDirectory, targetFileName);

    FileUtils.copyFile(doc, target);
    FileUtils.writeStringToFile(doc, savePath,"utf-8");
    /** 处理文件上传 end */
    return "sucess!";
  }

  /**
   * 使用UUID自动生成文件名
   * @param fileName  文件名
   * @return UUID重命名后的文件名
   */
  private String generateFileName(String fileName) {
    DateFormat format = new SimpleDateFormat("/yy/MM/dd/HH");
    String formatDate = format.format(new Date());
    //此处 需要添加 无后缀名时空指针判断
    String extension = fileName.substring(fileName.lastIndexOf("."));
    return formatDate + UUID.randomUUID().toString() + extension;
  }

  /**
   * @return the doc
   */
  public File getDoc() {
    return doc;
  }

  /**
   * @param doc the doc to set
   */
  public void setDoc(File doc) {
    this.doc = doc;
  }

  /**
   * @return the fileName
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * @param fileName the fileName to set
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
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
