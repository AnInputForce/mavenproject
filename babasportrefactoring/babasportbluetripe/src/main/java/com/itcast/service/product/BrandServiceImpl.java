/*
 * Copyright 2011 待到道成日，纵横天地间.
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
package com.itcast.service.product;

import com.itcast.model.product.Brand;
import java.util.UUID;

import com.itcast.service.dao.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kang.Cunhua
 */
@Service  //标注为Spring的Servicebean，供自动扫描机制加载该bean，就不用再beans.xml中声明了
@Transactional
public class BrandServiceImpl extends DaoSupport implements BrandService {

  public BrandServiceImpl() {
  }

  @Override
  public void save(Object entity) {
    ((Brand) entity).setCode(UUID.randomUUID().toString());
    super.save(entity);
  }
}