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

/**
 *
 * @author Kang.Cunhua
 */
public class IssueTraceInfo {
  //接单人：现在职责归开发人员处理；
  private String dealwithPerson;
  //审批人：行方的开发接口人
  private String developbacker;
  //处理状态
  private String dealwithState;
  //业务模块
  private String developModule;
  //变更类型
  private String issueType;
}
