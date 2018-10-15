package com.goodbuild.majiang.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 16:49
 * @Description:
 * @Version: 1.0.0
 */
public class PageResult<T extends Serializable> implements Serializable {


    private long total;

    private int currentPage;

    private int pageSize;

    private int pageNum;

    private List<T> datas;


    public PageResult(long total, List<T> datas) {
        this.total = total;
        this.datas = datas;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public PageResult(long total, int currentPage, int pageSize, int pageNum, List<T> datas) {
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.datas = datas;
    }
}
