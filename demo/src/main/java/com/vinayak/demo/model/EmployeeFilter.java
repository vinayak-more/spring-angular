package com.vinayak.demo.model;

public class EmployeeFilter {
    private int pageNumber;
    private int pageSize;
    private String sortBy;
    private String searchString;
    private boolean descending;

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSearchString() {
        return this.searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public boolean isDescending() {
        return this.descending;
    }

    public boolean getDescending() {
        return this.descending;
    }

    public void setDescending(boolean descending) {
        this.descending = descending;
    }

    @Override
    public String toString() {
        return "{" +
            " pageNumber='" + pageNumber + "'" +
            ", pageSize='" + pageSize + "'" +
            ", sortBy='" + sortBy + "'" +
            ", searchString='" + searchString + "'" +
            ", descending='" + descending + "'" +
            "}";
    }


}