package com.kcp.oms.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 
 * @author kapanda
 *
 */
public class OrderResource {

    private Long userId;

    private Long orderId;

    private Long productId;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime dateCreated;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public static OrderResource newInstance(long userId, long orderId, long productId, int quantity,
            BigDecimal totalPrice, LocalDateTime dateCreated) {
        OrderResource orderResource = new OrderResource();
        orderResource.setUserId(userId);
        orderResource.setOrderId(orderId);
        orderResource.setProductId(productId);
        orderResource.setQuantity(quantity);
        orderResource.setTotalPrice(totalPrice);
        orderResource.setDateCreated(dateCreated);
        return orderResource;
    }

}
