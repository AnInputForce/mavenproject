package com.itcast.web.action.product;

import com.itcast.bean.PageView;
import com.itcast.bean.QueryResult;
import com.itcast.bean.product.ProductType;
import com.itcast.service.product.ProductTypeService;
import java.util.LinkedHashMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 *
 * @author kang.cunhua
 */
@Controller("/control/product/type/list")
public class ProductTypeAction {

    @Resource(name = "productTypeServiceBean")
    private ProductTypeService productTypeService;
    private String message;
    private int page = 1;
    private int firstindex;
    private LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
    private PageView<ProductType> pageview ;// 页面显示对象

    /**
     * 产品类型列表显示
     * @return
     */
    public String list() {

        setPage(page < 1 ? 1 : page);
        setPageview(new PageView<ProductType>(12, page, 8));
        setFirstindex((this.getPageview().getCurrentpage() - 1) * getPageview().getMaxresult());
        orderby.put("typeid", "desc");
        QueryResult<ProductType> qr = productTypeService.getScrollData(
                ProductType.class, getFirstindex(), getPageview().getMaxresult(), "o.visible=?1", new Object[]{true}, orderby);
        //System.out.println("pageindex.startindex=" + getPageview().getPageindex().getStartpage());
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
}
