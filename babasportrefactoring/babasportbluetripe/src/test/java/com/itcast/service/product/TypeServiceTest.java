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

import com.itcast.model.QueryResult;
import com.itcast.model.product.Type;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kang.cunhua
 */
@ContextConfiguration(locations = {"classpath:beans.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TypeServiceTest {

  private static final Logger logger = Logger.getLogger(TypeServiceTest.class.getName());
  @Resource(name = "typeServiceImpl")
  private TypeService typeService;

  public TypeServiceTest() {
  }

  @Test
  public void testSave() {
    System.out.println("测试save()方法！");
    for (int i = 0; i < 20; i++) {
      Type type = new Type();
      type.setName(i + "篮球产品");
      type.setNote("好产品，不用多说！");
      typeService.save(type);
    }
  }

  @Test
  public void testFind() {
    System.out.println("测试Find()方法！");
    Type type = typeService.find(Type.class, 3);
    assertNotNull("获取不到id为3的记录！", type);
    logger.log(Level.INFO, "获取id为3的记录 {0}", type);

  }

  @Test
  public void testUpdate() {
    System.out.println("测试Update()方法！");
    Type type = typeService.find(Type.class, 3);
    type.setName("足球");
    type.setNote("好足球！");
    typeService.update(type);
    logger.log(Level.INFO, "更新 id为3的记录 {0}", type);

  }

  @Test
  public void testDelete() {
    System.out.println("测试Delete()方法！");
    typeService.delete(Type.class, 3);
  }

  @Test
  public void testGetScrollData() {
    LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
    orderby.put("typeid", "asc");
    QueryResult<Type> qr = typeService.getScrollData(
            Type.class, 5, 10, "o.visible=?1", new Object[]{true}, orderby);
//        QueryResult<Type> qr = typeService.getScrollData(
//                Type.class);
//
//        QueryResult<Type> qr = typeService.getScrollData(
//                Type.class, 0, 5);
//
//        QueryResult<Type> qr = typeService.getScrollData(
//                Type.class, 0, 5, orderby);
//        QueryResult<Type> qr = typeService.getScrollData(
//                Type.class, 0, 5, "o.visible=?1", new Object[]{true});

    for (Type t : qr.getResultlist()) {
      System.out.println("当前产品类别名称为：" + t.getName() + "；其id为 " + t.getTypeid());
    }
  }
}