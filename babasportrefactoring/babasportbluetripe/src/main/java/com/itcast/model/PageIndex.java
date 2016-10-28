package com.itcast.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author kang.cunhua
 */
public class PageIndex {


  private long startpage;

  private long endpage;

  public PageIndex() {
  }

  /**
   *
   * @param startpage
   * @param endpage
   */
  public PageIndex(long startpage, long endpage) {
    this.startpage = startpage;
    this.endpage = endpage;
  }

  /**
   * @return the startpage
   */
  public long getStartpage() {
    return startpage;
  }

  /**
   * @param startpage the startpage to set
   */
  public void setStartpage(long startpage) {
    this.startpage = startpage;
  }

  /**
   * @return the endpage
   */
  public long getEndpage() {
    return endpage;
  }

  /**
   * @param endpage the endpage to set
   */
  public void setEndpage(long endpage) {
    this.endpage = endpage;
  }
}
