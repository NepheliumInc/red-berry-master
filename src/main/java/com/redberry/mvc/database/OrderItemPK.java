package com.redberry.mvc.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Amila on 7/12/15.
 */
public class OrderItemPK implements Serializable {
    private int itemId;
    private int orderId;

    @Column(name = "item_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Column(name = "order_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemPK that = (OrderItemPK) o;

        if (itemId != that.itemId) return false;
        if (orderId != that.orderId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + orderId;
        return result;
    }
}
