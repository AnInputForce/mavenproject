/*
 * Copyright 2013 待到道成日，纵横天地间.
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
package com.guloulou.domain.datachange;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 功能：变更单基础信息实体类； 将TT（任务审批系统）的全流程变更单信息抽象需要的特征形成此类；
 *
 * @author Kang.Cunhua
 */
@Entity
public class IssueBaseInfo extends AbstractPersistable<Long> {

  //变更单编号
  private String justEncode;
  //提出部门
  private String requestDepartment;
  //联系人
  private String linkman;
  //联系电话
  private String contactNumber;
  //变更原因和内容
  private String reasonAndContent;
  //附件备注信息
  private String attachmentTitle;
  //附件的文件名
  private String attachmentName;
  //变更归档 ： 最后在运维组“数据变更处理人”处理时填写的意见；若不填写，则补录；
  //此处处理仅为：对变更任务定性、打印、分发；
  private String issueSummary;
  // 处室负责人 -- 一般来说是分行发起的多；
  private String branchHead;
  // 总行应用支持组经办人； 
  private String handlingPerson;
  // 总行应用支持组负责人；
  private String headoffice;  
  // 该变更单的处理状态:默认仅抓取状态为2处理完毕的变更单；
  private String issueState;
  //申请提出时间
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date requestTime;
  // 处室负责人审批时间
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date branchTime;
  // 总行经办人审批时间
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date handlingTime;
  // 总行应用支持负责人审批时间；
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date headofficeTime;
  //处理时间（处理时间为TT系统"数据变更操作人确认时间"）
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dealwithTime;
  // 变更单创建人
  private String issueCreator;

  /**
   * @return the justEncode
   */
  public String getJustEncode() {
    return justEncode;
  }

  /**
   * @param justEncode the justEncode to set
   */
  public void setJustEncode(String justEncode) {
    this.justEncode = justEncode;
  }

  /**
   * @return the requestDepartment
   */
  public String getRequestDepartment() {
    return requestDepartment;
  }

  /**
   * @param requestDepartment the requestDepartment to set
   */
  public void setRequestDepartment(String requestDepartment) {
    this.requestDepartment = requestDepartment;
  }

  /**
   * @return the linkman
   */
  public String getLinkman() {
    return linkman;
  }

  /**
   * @param linkman the linkman to set
   */
  public void setLinkman(String linkman) {
    this.linkman = linkman;
  }

  /**
   * @return the contactNumber
   */
  public String getContactNumber() {
    return contactNumber;
  }

  /**
   * @param contactNumber the contactNumber to set
   */
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  /**
   * @return the reasonAndContent
   */
  public String getReasonAndContent() {
    return reasonAndContent;
  }

  /**
   * @param reasonAndContent the reasonAndContent to set
   */
  public void setReasonAndContent(String reasonAndContent) {
    this.reasonAndContent = reasonAndContent;
  }

  /**
   * @return the attachmentTitle
   */
  public String getAttachmentTitle() {
    return attachmentTitle;
  }

  /**
   * @param attachmentTitle the attachmentTitle to set
   */
  public void setAttachmentTitle(String attachmentTitle) {
    this.attachmentTitle = attachmentTitle;
  }

  /**
   * @return the attachmentName
   */
  public String getAttachmentName() {
    return attachmentName;
  }

  /**
   * @param attachmentName the attachmentName to set
   */
  public void setAttachmentName(String attachmentName) {
    this.attachmentName = attachmentName;
  }

  /**
   * @return the issueSummary
   */
  public String getIssueSummary() {
    return issueSummary;
  }

  /**
   * @param issueSummary the issueSummary to set
   */
  public void setIssueSummary(String issueSummary) {
    this.issueSummary = issueSummary;
  }

  /**
   * @return the branchHead
   */
  public String getBranchHead() {
    return branchHead;
  }

  /**
   * @param branchHead the branchHead to set
   */
  public void setBranchHead(String branchHead) {
    this.branchHead = branchHead;
  }

  /**
   * @return the handlingPerson
   */
  public String getHandlingPerson() {
    return handlingPerson;
  }

  /**
   * @param handlingPerson the handlingPerson to set
   */
  public void setHandlingPerson(String handlingPerson) {
    this.handlingPerson = handlingPerson;
  }

  /**
   * @return the headoffice
   */
  public String getHeadoffice() {
    return headoffice;
  }

  /**
   * @param headoffice the headoffice to set
   */
  public void setHeadoffice(String headoffice) {
    this.headoffice = headoffice;
  }

  /**
   * @return the issueState
   */
  public String getIssueState() {
    return issueState;
  }

  /**
   * @param issueState the issueState to set
   */
  public void setIssueState(String issueState) {
    this.issueState = issueState;
  }

  /**
   * @return the requestTime
   */
  public Date getRequestTime() {
    return requestTime;
  }

  /**
   * @param requestTime the requestTime to set
   */
  public void setRequestTime(Date requestTime) {
    this.requestTime = requestTime;
  }

  /**
   * @return the branchTime
   */
  public Date getBranchTime() {
    return branchTime;
  }

  /**
   * @param branchTime the branchTime to set
   */
  public void setBranchTime(Date branchTime) {
    this.branchTime = branchTime;
  }

  /**
   * @return the handlingTime
   */
  public Date getHandlingTime() {
    return handlingTime;
  }

  /**
   * @param handlingTime the handlingTime to set
   */
  public void setHandlingTime(Date handlingTime) {
    this.handlingTime = handlingTime;
  }

  /**
   * @return the headofficeTime
   */
  public Date getHeadofficeTime() {
    return headofficeTime;
  }

  /**
   * @param headofficeTime the headofficeTime to set
   */
  public void setHeadofficeTime(Date headofficeTime) {
    this.headofficeTime = headofficeTime;
  }

  /**
   * @return the dealwithTime
   */
  public Date getDealwithTime() {
    return dealwithTime;
  }

  /**
   * @param dealwithTime the dealwithTime to set
   */
  public void setDealwithTime(Date dealwithTime) {
    this.dealwithTime = dealwithTime;
  }

  /**
   * @return the issueCreator
   */
  public String getIssueCreator() {
    return issueCreator;
  }

  /**
   * @param issueCreator the issueCreator to set
   */
  public void setIssueCreator(String issueCreator) {
    this.issueCreator = issueCreator;
  }
}
