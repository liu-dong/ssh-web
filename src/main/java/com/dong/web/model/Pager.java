package com.dong.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 *
 * @author LD
 */
public class Pager<T> {

    /**
     * 当前页码
     */
    private int page = 0;
    /**
     * 每页数量
     */
    private int limit = 10;
    /**
     * 记录总数
     */
    private int total = 0;
    /**
     * 页码总数
     */
    private int pageTotal = 0;
    /**
     * 分页数据
     */
    private List<T> dataList = new ArrayList<>();

    public Pager(int page, int limit, int total, int pageTotal, List<T> dataList) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.pageTotal = pageTotal;
        this.dataList = dataList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }

    }

    public int getOffset() {
        return this.page * this.limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.pageTotal = (int) Math.ceil((double) total / limit);
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
