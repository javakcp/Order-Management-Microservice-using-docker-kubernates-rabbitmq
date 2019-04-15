package com.kcp.oms.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.kcp.oms.inventory.dao.InventoryRepository;
import com.kcp.oms.inventory.dao.ProductInventory;
import com.kcp.oms.inventory.service.InventoryService;
import com.kcp.oms.inventory.service.exception.InventoryServiceException;

/**
 * 
 * @author kapanda
 *
 */
@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class InventoryServiceImpl implements InventoryService {
    private final static Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<ProductInventory> fetchAllProductsInventory() throws InventoryServiceException {

        List<ProductInventory> fetchedProductsInventory = new ArrayList<>();
        inventoryRepository.findAll().forEach(fetchedProductsInventory::add);
        if (CollectionUtils.isEmpty(fetchedProductsInventory))
            throw InventoryServiceException.create("No products inventory found");

        return fetchedProductsInventory;
    }

    @Override
    public ProductInventory fetchProductInventoryByProductId(long productId) throws InventoryServiceException {

        Optional<ProductInventory> fetchProductInventory = inventoryRepository.findById(productId);

        ProductInventory productInventory = fetchProductInventory
                .orElseThrow(() -> InventoryServiceException.create("Product inventory not found"));

        return productInventory;
    }

    @Override
    public ProductInventory saveProductInventory(ProductInventory productInventory) throws InventoryServiceException {
        logger.info("save() getting called. {}", productInventory);
        return inventoryRepository.save(productInventory);
    }

    @Override
    public void deleteProductInventory(long productId) throws InventoryServiceException {
        inventoryRepository.deleteById(productId);
    }

}
