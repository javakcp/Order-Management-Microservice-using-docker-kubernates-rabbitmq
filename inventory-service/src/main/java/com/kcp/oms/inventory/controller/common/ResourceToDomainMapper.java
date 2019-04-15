package com.kcp.oms.inventory.controller.common;

import com.kcp.oms.inventory.dao.ProductInventory;
import com.kcp.oms.inventory.dao.ProductInventoryResource;

/**
 * 
 * @author kapanda
 *
 */
public class ResourceToDomainMapper {

    public static ProductInventory map(ProductInventoryResource productInventoryResource) {
        ProductInventory productInventory = ProductInventory.newInstance(productInventoryResource.getProductId(),
                productInventoryResource.getProductName(), productInventoryResource.getProductPrice(),
                productInventoryResource.getQuantity());
        return productInventory;
    }

}
