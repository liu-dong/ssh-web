package com.dong.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果
 *
 * @author LD
 */
public class PageVO<T> {

    /**
     * 当前页码
     */
    private int currentPage = 0;

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

    public PageVO(int currentPage, int total, List<T> dataList) {
        this.currentPage = currentPage;
        this.total = total;
        this.pageTotal = (int) Math.ceil((double) total / 10);
        this.dataList = dataList;
    }

    public PageVO(int currentPage, int total, int pageTotal, List<T> dataList) {
        this.currentPage = currentPage;
        this.total = total;
        this.pageTotal = pageTotal;
        this.dataList = dataList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage <= 0) {
            this.currentPage = 1;
        } else {
            this.currentPage = currentPage;
        }
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.pageTotal = (int) Math.ceil((double) total / 10);
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
