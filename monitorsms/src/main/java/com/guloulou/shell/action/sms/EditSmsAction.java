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
package com.guloulou.shell.action.sms;

import com.guloulou.service.sms.*;
import java.io.IOException;

/**
 *
 * @author Kang.Cunhua
 */
public class EditSmsAction {

  private static CreatSmsAlarmFlag csaf = new CreatSmsAlarmFlag();

  /**
   * 调用创建短信的service层服务
   *
   * @param cs 参数声明为接口，实际传递的为实现类
   */
  public void editSms(CreatSmsService cs, Boolean delflagfile) {
    System.out.println("开始调用短信内容持久化模块");
    System.out.println("检测报警文件是否存在");
    if (csaf.getwarnflag(delflagfile)) {
      //如果不存在,且也不是 报恢复正常的短信
      System.out.println("开始生成短信");

      cs.processSmsFile();

      System.out.println("结束生成短信");

    } else {
      // 如果存在
      System.out.println("3个小时内已经有过报警");
    }
    System.out.println("结束调用短信内容持久化模块");
  }

  public static void main(String[] args) throws IOException {
    /*
     * 处理管理系统报警发短信
     */
    if (args != null && args.length != 0 && "OK".equals(args[0])) {
      // 处理恢复正常的短信通知
      new EditSmsAction().editSms(new CreatSmsServiceImplForAll(), true);
    } else {
      new EditSmsAction().editSms(new CreatSmsServiceImplForPartA(), false);
      new EditSmsAction().editSms(new CreatSmsServiceImplForPartB(), false);

      System.out.println("生成报警文件开始：");
      csaf.setAlarmflag();
      System.out.println("生成报警文件结束！");
    }
    System.out.println("主入口调用移动短信文件到接口开始");
    csaf.mvSmsFileToSendDir();
    System.out.println("主入口调用移动短信文件到接口结束");
  }
}
