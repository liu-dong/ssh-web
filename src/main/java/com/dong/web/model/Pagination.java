package com.dong.web.model;

/**
 * 分页
 *
 * @author LD
 */
public class Pagination {

    /**
     * 当前页码
     */
    private int page = 1;
    /**
     * 每页数量
     */
    private int limit = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
