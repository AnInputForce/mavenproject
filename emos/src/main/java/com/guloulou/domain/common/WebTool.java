package com.guloulou.domain.common;

/**
 *
 * @author kang.cunhua
 */
public class WebTool {

  /**
   *
   * @param pagebarsize
   * @param currenPage
   * @param totalpage
   * @return
   */
  public static PageIndex getPageIndex(long pagebarsize, int currenPage, long totalpage) {
        long startpage = currenPage - (pagebarsize % 2 == 0 ? pagebarsize / 2 - 1 : pagebarsize / 2);
        long endpage = currenPage + pagebarsize / 2;
        if (startpage < 1) {
            startpage = 1;
            if (totalpage >= pagebarsize) {
                endpage = pagebarsize;
            } else {
                endpage = totalpage;
            }

        }
        if (endpage > totalpage) {
            endpage = totalpage;
            if ((endpage - pagebarsize) > 0) {
                startpage = endpage - pagebarsize + 1;
            } else {
                startpage = 1;
            }

        }
        return new PageIndex(startpage, endpage);

    }
}
