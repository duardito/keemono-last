package com.keemono.common.pagination;

/**
 * Created by edu on 12/10/2015.
 */
public class Pagination {

    public static final Integer PAGINATION_DEFAULT = 10;

    private Integer page;
    private Integer size;
    private Long totalRecords;

    public Pagination(final Integer page, final Integer size) {
        this.page = page;
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(final Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(final Integer size) {
        this.size = size;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public Integer getFirstResult() {
        return (getPage() - 1) * getSize();
    }

    public void setTotalRecords(final Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPages() {
        Long numberpages = getTotalRecords() / getSize();
        Long resto = getTotalRecords() % getSize();

        if (resto > 1) {
            numberpages++;
        }
        return Integer.valueOf(numberpages.toString());
    }

}
