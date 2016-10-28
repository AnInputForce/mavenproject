package com.itcast.web.action.product;

import com.itcast.bean.QueryResult;
import com.itcast.bean.product.ProductType;
import com.itcast.service.product.ProductTypeService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("/control/product/type/JsonTable")
public class JsonTable {

    //Your result List
    private List<ProductType> gridModel;
    //get how many rows we want to have into the grid - rowNum attribute in the grid
    private Integer rows = 10;
    //Get the requested page. By default grid sets this to 1.
    private Integer page = 1;
    // sorting order - asc or desc
    private String sord;
    // get index row - i.e. user click to sort.
    private String sidx;
    // Search Field
    private String searchField;
    // The Search String
    private String searchString;
    // he Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
    private String searchOper;
    // Your Total Pages
    private Integer total = 0;
    // All Record
    private Integer records = 0;
    @Resource(name = "productTypeServiceBean")
    private ProductTypeService productTypeService;

    public String execute() {

        int to = (getRows() * getPage());
        int from = to - getRows();

        QueryResult<ProductType> qr = productTypeService.getScrollData(
                ProductType.class, from, to, "o.visible=?1", new Object[]{true});
        setRecords((Integer) qr.getTotalrecord().intValue());
        setGridModel(qr.getResultlist());


        //calculate the total pages for the query
        setTotal((Integer) (int) Math.ceil((double) getRecords() / (double) getRows()));

        return "success";
    }

    public String getJSON() {
        return execute();
    }

    /**
     * @return the gridModel
     */
    public List<ProductType> getGridModel() {
        return gridModel;
    }

    /**
     * @param gridModel the gridModel to set
     */
    public void setGridModel(List<ProductType> gridModel) {
        this.gridModel = gridModel;
    }

    /**
     * @return the rows
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return the sord
     */
    public String getSord() {
        return sord;
    }

    /**
     * @param sord the sord to set
     */
    public void setSord(String sord) {
        this.sord = sord;
    }

    /**
     * @return the sidx
     */
    public String getSidx() {
        return sidx;
    }

    /**
     * @param sidx the sidx to set
     */
    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    /**
     * @return the searchField
     */
    public String getSearchField() {
        return searchField;
    }

    /**
     * @param searchField the searchField to set
     */
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * @return the searchString
     */
    public String getSearchString() {
        return searchString;
    }

    /**
     * @param searchString the searchString to set
     */
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    /**
     * @return the searchOper
     */
    public String getSearchOper() {
        return searchOper;
    }

    /**
     * @param searchOper the searchOper to set
     */
    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return the records
     */
    public Integer getRecords() {
        return records;
    }

    /**
     * @param records the records to set
     */
    public void setRecords(Integer records) {
        this.records = records;
    }
    //Getters and Setters for Attributes
}
