package com.kcp.oms.inventory.service;

import java.util.List;

import com.kcp.oms.inventory.dao.ProductInventory;
import com.kcp.oms.inventory.service.exception.InventoryServiceException;

/**
 * 
 * @author kapanda
 *
 */
public interface InventoryService {

    public List<ProductInventory> fetchAllProductsInventory() throws InventoryServiceException;

    public ProductInventory fetchProductInventoryByProductId(long productId) throws InventoryServiceException;

    public ProductInventory saveProductInventory(ProductInventory productInventory) throws InventoryServiceException;

    public void deleteProductInventory(long productId) throws InventoryServiceException;

}
