package com.itcast.model;

import java.util.List;

/**
 *
 * @param <T>
 * @author kang.cunhua
 */
public class PageView<T> {

  private List<T> records; // 分页数据
  private PageIndex pageindex;//= new PageIndex(1, 6); // 页码开始索引和结束索引，页面码显示总数
  private long totalpage; // 总页数
  private int maxresult; // 每页显示记录数
  private int currentpage; // 当前页
  private long totalrecord; // 总记录数
  private long pagebarsize; // 页码导航显示的最多页码数

  /**
   *
   * @param maxresult
   * @param currentpage
   * @param pagebarsize
   */
  public PageView(int maxresult, int currentpage, long pagebarsize) {

    this.maxresult = maxresult;
    this.currentpage = currentpage;
    this.pagebarsize = pagebarsize;
  }

  /**
   *
   * @param qr
   */
  public void setQueryResult(QueryResult qr) {
    setTotalrecord(qr.getTotalrecord());
    setRecords(qr.getResultlist());
  }

  /**
   * @return the records
   */
  public List<T> getRecords() {
    return records;
  }

  /**
   * @param records the records to set
   */
  public void setRecords(List<T> records) {
    this.records = records;
  }

  /**
   * @return the pageindex
   */
  public PageIndex getPageindex() {
    return pageindex;
  }

  /**
   * @return the totalpage
   */
  public long getTotalpage() {
    return totalpage;
  }

  /**
   * @param totalpage the totalpage to set
   */
  public void setTotalpage(long totalpage) {
    this.totalpage = totalpage;
    this.pageindex = WebTool.getPageIndex(pagebarsize, currentpage, totalpage);
  }

  /**
   * @return the maxresult
   */
  public int getMaxresult() {
    return maxresult;
  }

  /**
   * @return the currentpage
   */
  public int getCurrentpage() {
    return currentpage;
  }

  /**
   * @return the totalrecord
   */
  public long getTotalrecord() {
    return totalrecord;
  }

  /**
   * @param totalrecord the totalrecord to set
   */
  public void setTotalrecord(long totalrecord) {
    this.totalrecord = totalrecord;
    this.setTotalpage(this.totalrecord % this.maxresult == 0 ? this.totalrecord / this.maxresult : this.totalrecord / this.maxresult + 1);
  }

  /**
   * @return the pagebarsize
   */
  public long getPagebarsize() {
    return pagebarsize;
  }
}
