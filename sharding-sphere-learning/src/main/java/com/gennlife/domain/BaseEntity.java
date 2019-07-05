package com.gennlife.domain;

/**
 * @author liuzhen278
 * @title: BaseEntity
 * @projectName mytest-project
 * @description: 实体类基类
 * @date 2019/7/415:17
 */
public class BaseEntity {
    /**页码信息*/
    protected transient Integer pageNum = null;
    /***pageSize 为 0 时表示不分页*/
    protected transient Integer pageSize = null;
    /**排序字段，a desc,b asc, ...**/
    protected transient String orderBy;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
