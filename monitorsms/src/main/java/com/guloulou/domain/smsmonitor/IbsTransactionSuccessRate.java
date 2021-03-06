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
package com.guloulou.domain.smsmonitor;

/**
 * 会计实时交易成功率对应domain对象
 *
 * @author Kang.Cunhua
 */
public class IbsTransactionSuccessRate {

  private float transactionSuccessRate;

  public IbsTransactionSuccessRate() {
  }

  public IbsTransactionSuccessRate(float transactionSuccessRate) {
    this.transactionSuccessRate = transactionSuccessRate;
  }

  /**
   * @return the transactionSuccessRate
   */
  public float getTransactionSuccessRate() {
    return transactionSuccessRate;
  }

  /**
   * @param transactionSuccessRate the transactionSuccessRate to set
   */
  public void setTransactionSuccessRate(float transactionSuccessRate) {
    this.transactionSuccessRate = transactionSuccessRate;
  }
}
