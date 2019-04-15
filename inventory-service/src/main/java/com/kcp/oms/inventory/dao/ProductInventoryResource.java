package com.kcp.oms.inventory.dao;

/**
 * 
 * @author kapanda
 *
 */
public class ProductInventoryResource {

    private Long productId;
    private String productName;
    private String productPrice;
    private Integer quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static ProductInventoryResource newInstance(Long productId, String productName, String productPrice,
            Integer quantity) {
        ProductInventoryResource pi = new ProductInventoryResource();
        pi.setProductId(productId);
        pi.setProductName(productName);
        pi.setProductPrice(productPrice);
        pi.setQuantity(quantity);
        return pi;
    }

    @Override
    public String toString() {
        return "ProductInventoryResource [productId=" + productId + ", productName=" + productName + ", productPrice="
                + productPrice + ", quantity=" + quantity + "]";
    }

}
