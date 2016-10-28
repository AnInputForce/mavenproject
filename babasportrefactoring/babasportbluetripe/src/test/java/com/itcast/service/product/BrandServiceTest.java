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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Kang.Cunhua
 */
@ContextConfiguration(locations = {"classpath:beans.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BrandServiceTest {

  private static final Logger logger = Logger.getLogger(BrandServiceTest.class.getName());
  @Resource(name = "brandServiceImpl")
//  @Autowired
//  @Qualifier("brandServiceImpl")
  private BrandService brandService;//= new BrandServiceImpl();

  @Test
  public void testSave() {
    Brand brand = new Brand("远阳瑜伽", "/image/brand/2011/10/04/yuanyangyujia.png");
    System.err.println("001" + brandService);

    brandService.save(brand);

    System.err.println("002" + brand.getCode());
  }

  @Test
  public void testfind() {
    System.out.println("003" + "测试Find()方法！");
    System.err.println("004" + brandService);
    Brand brand = (Brand) brandService.find(Brand.class, "55fba033-b4a7-4d61-89c0-2564b020731c");
    if (brand != null) {
      System.err.println("005" + brand.getCode());
    }
    logger.log(Level.INFO, "获取id为\"55fba033-b4a7-4d61-89c0-2564b020731c\"的记录！ {0}", brand);


  }
}