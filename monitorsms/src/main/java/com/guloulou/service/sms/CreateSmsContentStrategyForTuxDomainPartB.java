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
import com.guloulou.helper.KvCodeHelper;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 *
 * @author Kang.Cunhua
 */
public class CreateSmsContentStrategyForTuxDomainPartB extends CreateSmsContentStrategyAbst {

  public String editSmsContent() {
    System.out.println("调用策略类：" + "CreateSmsContentStrategyForTuxDomainPartB!");
    String returntmp = "false";
    StringBuilder appendtmp = new StringBuilder();
    String sql = "select h.hostDesc, t.ldomain,t.rdomain,t.dmstate,t.updatetime, t.alertflag,t.alertcontent "
            + "from tux_dma_data t  , Hosts h "
            + "where h.hostID=t.hostID and t.rdomain not like 'chie%' and t.rdomain not like 'cloan%'  "
            + "and t.rdomain not like 'cpbank%' and t.rdomain not like 'split%' "
            + "and t.rdomain not like 'dayend%' "
            + "and t.alertflag=? ";

    List<TuxDomainStatus> resultlist = simpleMysql.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TuxDomainStatus.class), Integer.parseInt(properties.getProperty("tuxdomainerror")));

    System.out.println("list.size:" + resultlist.size());
    // 判断是否有记录
    Map map = KvCodeHelper.getMap("tuxcity");

    if (resultlist.size() > 0) {
      for (int i = 0; i < resultlist.size(); i++) {
        String tmprdomin = (String) map.get(resultlist.get(i).getRdomain());
        appendtmp.append(resultlist.get(i).getHostDesc() + "与统版" + tmprdomin).append("、");

      }

      String tempstr = appendtmp.toString();
      tempstr = tempstr.substring(0, tempstr.lastIndexOf("、"));
      returntmp = updateTemplate(new TuxDomainStatus(tempstr), properties.getProperty("tuxDomainForPartB"));

    }
    return returntmp;
  }
}
