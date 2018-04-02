package com.lm.util;
import java.util.List;

/**
 * 分页类
 * @param <T>
 */
public class Pager<T> {
    private Integer total;//分页数据总数
    private List<T> rows;//分页数据

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}