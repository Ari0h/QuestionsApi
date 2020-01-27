package com.testquiz.api.DTOModel;

public class Filter {

    private String filterName;

    private String orderBy;

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Filter(String filterName, String orderBy) {
        this.filterName = filterName;
        this.orderBy = orderBy;
    }
}
