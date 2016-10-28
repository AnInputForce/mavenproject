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
package com.itcast.model.product;

/**
 * 枚举：产品的性别要求
 * @author Kang.Cunhua
 */
public enum Sex {

  NONE {

    @Override
    public String getName() {
      return "男女不限";
    }
  },
  MAN {

    @Override
    public String getName() {
      return "男";
    }
  },
  WOMEN {

    @Override
    public String getName() {
      return "女";
    }
  };

  public abstract String getName();
}
