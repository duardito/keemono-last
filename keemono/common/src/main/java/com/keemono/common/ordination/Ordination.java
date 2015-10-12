package com.keemono.common.ordination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edu on 12/10/2015.
 */
public class Ordination {

    public static final String ASC = "asc";
    public static final String DESC = "desc";

    private List<OrdinationElement> orderElements;

    public List<OrdinationElement> getOrderElements() {
        return orderElements;
    }

    public void setOrderElements(List<OrdinationElement> orderElements) {
        this.orderElements = orderElements;
    }

    private void addOrderElement(String fieldName, String ascending) {
        if (null == this.orderElements) {
            this.orderElements = new ArrayList<OrdinationElement>();
        }
        orderElements.add(new OrdinationElement(fieldName, ascending));
    }

    public void addAscendingOrderElement(String fieldName) {
        addOrderElement(fieldName, ASC);
    }

    public void addDescendingOrderElement(String fieldName) {
        addOrderElement(fieldName, DESC);
    }

    public boolean hasOrderElements() {
        return null != getOrderElements();
    }

    public boolean hasOrderElement(String fieldName) {
        if (orderElements != null) {
            for (OrdinationElement orderElement : orderElements) {
                if (fieldName.equals(orderElement.getFieldName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
