package com.lm.condition;

public class Condition {
    private Integer page;//当前页
    private Integer rows;//每页显示行数
    private String sort;//排序字段
    private String order;//排序方式{升序 asc / 降序 desc}

    public Condition() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
