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

import com.guloulou.domain.smsmonitor.TuxDomainStatus;
import com.guloulou.domain.smsmonitor.TuxServerStatus;
import com.guloulou.helper.KvCodeHelper;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 *
 * @author Kang.Cunhua
 */
public class CreateSmsContentStrategyForTuxServicePartA extends CreateSmsContentStrategyAbst {

  public String editSmsContent() {
    System.out.println("调用策略类：" + "CreateSmsContentStrategyForTuxServicePartA!");
    String returntmp = "false";
    StringBuilder appendtmp = new StringBuilder();
    String sql = "select  h.hostID,h.hostDesc, r.srvname,d.srvnum,d.totalreq,d.maxreq,"
            + "d.minreq,d.idlenum,d.busynum,d.suspendnum,d.othernum, d.updatetime,"
            + "d.alertflag ,d.alertcontent  "
            + "from  (tux_server_reg r , Hosts h) left join  tux_server_data  d  on r.srvname=d.srvname "
            + "where h.hostID=r.hostID "
            + "and d.alertflag <> ? ";

    List<TuxServerStatus> resultlist = simpleMysql.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TuxServerStatus.class), Integer.parseInt(properties.getProperty("tuxserviceerror")));

    System.out.println("list.size:" + resultlist.size());
    // 判断是否有记录

    if (resultlist.isEmpty()) {
      returntmp = updateTemplate(new TuxServerStatus(), properties.getProperty("tuxServiceForPartA"));
    }
    return returntmp;
  }
}
