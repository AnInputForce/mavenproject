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
package com.itcast.service.product;

import com.itcast.model.product.Brand;
import com.itcast.model.product.Infomation;
import com.itcast.model.product.Sex;
import com.itcast.model.product.Style;
import com.itcast.model.product.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Kang.Cunhua
 */
@ContextConfiguration(locations = {"classpath:beans.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class InfomationServiceTest {

  private static final Logger logger = Logger.getLogger(BrandServiceTest.class.getName());
  @Resource(name = "infomationServiceImpl")
  private InfomationService infomationService;
  @Resource(name = "brandServiceImpl")
  private BrandService brandService;
  @Resource(name = "typeServiceImpl")
  private TypeService typeService;

  @Test
  public void testSave() {

    System.out.println("测试infomation - save()方法！");
    //for (int i = 0; i < 20; i++) {
    Infomation infomation = new Infomation();
    infomation.setCode("UI002");
    infomation.setName("篮球infomation斯伯丁");
    infomation.setBrand(brandService.find(Brand.class, "6d2563ef-07c0-4573-a703-8e9f17eac336"));
    infomation.setModel("T60");
    infomation.setBaseprice(100f);
    infomation.setMarkprice(600f);
    infomation.setSellprice(200f);
    infomation.setWeight(60);
    infomation.setDescription("创始人A.G.Spalding先生 斯伯丁（SPALDING）先生于1850年诞生于美国伊利诺州："
            + "17岁时加盟华盛顿、纽约等职业棒球队，1871年加入波士顿红袜队并成为主力投手，在1872~1875年间"
            + "带领波士顿红袜队完成三连胜的霸业。此后，SPALDING先生一直致力于纠正棒球界中的暴力、贪污等腐败现象，"
            + "此举让他成为美国人民心目中的英雄，而棒球也渐成为美国人的梦想。");

    infomation.setBuyexplain("好产品不用多说！");
    infomation.setSexrequest(Sex.NONE);
    infomation.addProductStyle(new Style("红色", "***.gif"));
    infomation.setType(typeService.find(Type.class, 1));

    infomationService.save(infomation);
    System.out.println("infomation is : " + infomation.getName());
    //}

  }
//  @Test
//  public void testfind() {
//    System.out.println("003" + "测试Find()方法！");
//    System.err.println("004" + infomationService);
//    Infomation infomation = (Infomation) infomationService.find(Infomation.class, "55fba033-b4a7-4d61-89c0-2564b020731c");
//    if (infomation != null) {
//      System.err.println("005" + infomation.getCode());
//    }
//    logger.log(Level.INFO, "获取id为\"55fba033-b4a7-4d61-89c0-2564b020731c\"的记录！ {0}", infomation);
//
//
//  }
}
