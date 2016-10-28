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
package com.guloulou.service.sms;

import com.guloulou.domain.smsmonitor.EverythingIsOk;
import com.guloulou.domain.smsmonitor.IbsTransactionSuccessRate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 *
 * @author Kang.Cunhua
 */
public class CreateSmsContentStrategyForAll extends CreateSmsContentStrategyAbst {

  public String editSmsContent() {
    System.out.println("调用策略类：" + "CreateSmsContentStrategyForAll!");
    String returntmp = "false";
    StringBuilder appendtmp = new StringBuilder();

    returntmp = updateTemplate(new EverythingIsOk(), properties.getProperty("okForAll"));

    return returntmp;
  }
}
