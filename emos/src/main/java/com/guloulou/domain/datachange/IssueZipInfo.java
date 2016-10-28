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
public class IssueZipInfo {
  
  // 操作方案确认人：开发接口人；
  private String confirmer;
  // 操作方案提供人：开发人员；
  private String provider;
  // 操作方案执行人：现为运维组 DBA；
  private String executor;
  // 变更实例 [SCA]@[DB]；
  private String userInstance;
  //备份脚本；
  private String backupScript;
  //回退脚本；
  private String rollbackScript;
  //变更脚本；
  private String mainScript;
  // 变更台帐；
  private String changelog;
  // 如果为系统bug或新需求，则需对应redmine中至少一条任务编码；
  private String redmineCode;
  
 
  
  
}
