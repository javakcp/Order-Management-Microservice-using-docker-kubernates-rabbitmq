package com.kcp.oms.inventory.controller.common;

import java.util.List;
import java.util.stream.Collectors;

import com.kcp.oms.inventory.dao.ProductInventory;
import com.kcp.oms.inventory.dao.ProductInventoryResource;

/**
 * 
 * @author kapanda
 *
 */
public class DomainToResourceMapper {

    public static ProductInventoryResource map(ProductInventory productInventory) {
        ProductInventoryResource productInventoryResource = ProductInventoryResource.newInstance(
                productInventory.getProductId(), productInventory.getProductName(), productInventory.getProductPrice(),
                productInventory.getQuantity());
        return productInventoryResource;
    }

    public static List<ProductInventoryResource> map(List<ProductInventory> productInventories) {
        List<ProductInventoryResource> productInventoryResources = productInventories.stream()
                .map(productInventory -> ProductInventoryResource.newInstance(productInventory.getProductId(),
                        productInventory.getProductName(), productInventory.getProductPrice(),
                        productInventory.getQuantity()))
                .collect(Collectors.toList());
        return productInventoryResources;
    }

}
