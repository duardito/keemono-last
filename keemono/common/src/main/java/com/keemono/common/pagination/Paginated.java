package com.keemono.common.pagination;

/**
 * Created by edu on 12/10/2015.
 */
public class Paginated {

    private int totalSize;
    private int page;
    private int totalPages;

    public Paginated(int totalSize, int page, int totalPages) {
        this.totalSize = totalSize;
        this.page = page;
        this.totalPages = totalPages;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
