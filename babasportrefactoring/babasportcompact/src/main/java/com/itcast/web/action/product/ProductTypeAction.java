package com.itcast.web.action.product;

import com.itcast.bean.PageView;
import com.itcast.bean.QueryResult;
import com.itcast.bean.product.ProductType;
import com.itcast.service.product.ProductTypeService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author kang.cunhua
 */
@Scope("prototype")
@Controller("/control/product/type/list")
public class ProductTypeAction {

  @Resource(name = "productTypeServiceBean")
  private ProductTypeService productTypeService;
  private ProductType productType;
  private String message;
  private int page = 1;
  private int firstindex;
  private LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
  private PageView<ProductType> pageview;// 页面显示对象
  private Integer parentid;
  private String query;

  public String readUI() {

    return "readbyname";
  }

  /**
   * 产品类型列表显示
   * @return
   */
  public String list() {

    StringBuilder jpql = new StringBuilder(" o.visible=?1"); //定义一字符串变量存储查询条件
    List<Object> params = new ArrayList<Object>();


    setPage(page < 1 ? 1 : page);
    setPageview(new PageView<ProductType>(18, page, 8));
    setFirstindex((this.getPageview().getCurrentpage() - 1) * getPageview().getMaxresult());

    orderby.put("typeid", "desc");
    params.add(true);

    if ("true".equals(query)) {  // 如果来自查询页面
      jpql.append(" and o.name like ?").append(params.size() + 1);
      params.add("%" + productType.getName() + "%");
      //System.out.println("productType.getName()=" + productType.getName());
    } else {
      if (null != parentid && parentid > 0) {
        jpql.append(" and o.parent.typeid=?").append(params.size() + 1);
        params.add(getParentid());
      } else {
        jpql.append(" and o.parent is null ");
      }
    }
    //System.out.println("jpql=" + jpql);
    QueryResult<ProductType> qr = productTypeService.getScrollData(
            ProductType.class, getFirstindex(), getPageview().getMaxresult(), jpql.toString(), params.toArray(), orderby);
    getPageview().setQueryResult(qr);

    return "list";
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the page
   */
  public int getPage() {
    return page;
  }

  /**
   * @param page the page to set
   */
  public void setPage(int page) {
    this.page = page;
  }

  /**
   * @return the firstindex
   */
  public int getFirstindex() {
    return firstindex;
  }

  /**
   * @param firstindex the firstindex to set
   */
  public void setFirstindex(int firstindex) {
    this.firstindex = firstindex;
  }

  /**
   * @return the orderby
   */
  public LinkedHashMap<String, String> getOrderby() {
    return orderby;
  }

  /**
   * @param orderby the orderby to set
   */
  public void setOrderby(LinkedHashMap<String, String> orderby) {
    this.orderby = orderby;
  }

  /**
   * @return the pageview
   */
  public PageView<ProductType> getPageview() {
    return pageview;
  }

  /**
   * @param pageview the pageview to set
   */
  public void setPageview(PageView<ProductType> pageview) {
    this.pageview = pageview;
  }

  /**
   * @return the productType
   */
  public ProductType getProductType() {
    return productType;
  }

  /**
   * @param productType the productType to set
   */
  public void setProductType(ProductType productType) {
    this.productType = productType;
  }

  /**
   * @return the parentid
   */
  public Integer getParentid() {
    return parentid;
  }

  /**
   * @param parentid the parentid to set
   */
  public void setParentid(Integer parentid) {
    this.parentid = parentid;
  }

  /**
   * @return the query
   */
  public String getQuery() {
    return query;
  }

  /**
   * @param query the query to set
   */
  public void setQuery(String query) {
    this.query = query;
  }
}