package com.itcast.bean.product;

import com.itcast.bean.QueryResult;
import com.itcast.service.product.ProductTypeService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kang.cunhua
 */
public class ProductTest {

    private static ApplicationContext cxt;
    private static ProductTypeService productTypeService;

    public ProductTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        cxt = new ClassPathXmlApplicationContext("beans.xml");
        productTypeService = (ProductTypeService) cxt.getBean("productTypeServiceBean");

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test save.
     */
    @Test
    public void testSave() {
        System.out.println("测试save()方法！");
        for (int i = 0; i < 20; i++) {
            ProductType type = new ProductType();
            type.setName(i + "篮球产品");
            type.setNote("好产品，不用多说！");
            productTypeService.save(type);
        }
    }

    @Test
    public void testFind() {
        System.out.println("测试Find()方法！");
        ProductType type = productTypeService.find(ProductType.class, 3);
        Assert.assertNotNull("获取不到id为3的记录！", type);
    }

    @Test
    public void testUpdate() {
        System.out.println("测试Update()方法！");
        ProductType type = productTypeService.find(ProductType.class, 3);
        type.setName("足球");
        type.setNote("好足球！");
        productTypeService.update(type);
    }

    @Test
    public void testDelete() {
        System.out.println("测试Delete()方法！");
        //productTypeService.delete(ProductType.class, 1);
        productTypeService.delete(ProductType.class, 3);

    }

    @Test
    public void testGetScrollData() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
        orderby.put("typeid", "asc");
        QueryResult<ProductType> qr = productTypeService.getScrollData(
                ProductType.class, 0, 5, "o.visible=?1", new Object[]{true}, orderby);
//        QueryResult<ProductType> qr = productTypeService.getScrollData(
//                ProductType.class);
//
//        QueryResult<ProductType> qr = productTypeService.getScrollData(
//                ProductType.class, 0, 5);
//
//        QueryResult<ProductType> qr = productTypeService.getScrollData(
//                ProductType.class, 0, 5, orderby);
//        QueryResult<ProductType> qr = productTypeService.getScrollData(
//                ProductType.class, 0, 5, "o.visible=?1", new Object[]{true});

        for (ProductType t : qr.getResultlist()) {
            System.out.println("当前产品类别名称为：" + t.getName() + "；其id为 " + t.getTypeid());
        }
    }
}
