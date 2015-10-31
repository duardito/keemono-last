package com.keemono.base;

/**
 * Created by edu on 31/10/2015.
 */
public class AbstractTableValidatorBean {
    private String tableName;
    private String[] columnsToIgnore;

    public AbstractTableValidatorBean(String tableName, String[] columnsToIgnore) {
        this.tableName = tableName;
        this.columnsToIgnore = columnsToIgnore;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String[] getColumnsToIgnore() {
        return columnsToIgnore;
    }

    public void setColumnsToIgnore(String[] columnsToIgnore) {
        this.columnsToIgnore = columnsToIgnore;
    }
}
