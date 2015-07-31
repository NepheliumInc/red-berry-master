package com.redberry.mvc.database;

import javax.persistence.*;

/**
 * Created by Amila on 7/12/15.
 */
@Entity
@Table(name = "ORDER_ITEM", schema = "", catalog = "redberry")
@IdClass(OrderItemPK.class)
public class OrderItem {
    private int itemId;
    private int orderId;

    @Id
    @Column(name = "item_id", nullable = false, insertable = true, updatable = true)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Id
    @Column(name = "order_id", nullable = false, insertable = true, updatable = true)
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

        OrderItem orderItem = (OrderItem) o;

        if (itemId != orderItem.itemId) return false;
        if (orderId != orderItem.orderId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + orderId;
        return result;
    }
}
