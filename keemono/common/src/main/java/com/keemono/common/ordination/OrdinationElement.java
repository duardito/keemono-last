package com.keemono.common.ordination;

/**
 * Created by edu on 12/10/2015.
 */
public class OrdinationElement {

    private String fieldName;
    private String order;

    public OrdinationElement(String fieldName, String order) {
        this.fieldName = fieldName;
        this.order = order;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
