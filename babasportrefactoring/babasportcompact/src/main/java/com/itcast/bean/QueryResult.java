package com.itcast.bean;

import java.util.List;

/**
 *
 * @author kang.cunhua
 */
public class QueryResult<T> {

    private List<T> resultlist;
    private Long totalrecord;

    /**
     * @return the resultlist
     */
    public List<T> getResultlist() {
        return resultlist;
    }

    /**
     * @param resultlist the resultlist to set
     */
    public void setResultlist(List<T> resultlist) {
        this.resultlist = resultlist;
    }

    /**
     * @return the totalrecord
     */
    public Long getTotalrecord() {
        return totalrecord;
    }

    /**
     * @param totalrecord the totalrecord to set
     */
    public void setTotalrecord(Long totalrecord) {
        this.totalrecord = totalrecord;
    }
}
