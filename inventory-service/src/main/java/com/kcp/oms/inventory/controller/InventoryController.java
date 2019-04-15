package com.kcp.oms.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kcp.oms.inventory.controller.common.DomainToResourceMapper;
import com.kcp.oms.inventory.controller.common.ResourceToDomainMapper;
import com.kcp.oms.inventory.dao.ProductInventory;
import com.kcp.oms.inventory.dao.ProductInventoryResource;
import com.kcp.oms.inventory.service.InventoryService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author kapanda
 *
 */
@RestController
public class InventoryController {

    public InventoryController() {
        logger.info("Bean Created");
    }

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/inventory", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    @ApiOperation(value = "Find all inventory", notes = "Returns all inventory data")
    public ResponseEntity<List<ProductInventoryResource>> fetchAllProductsInventory() {
        logger.info("Get all inventory");
        List<ProductInventory> fetchedProductsInventory = inventoryService.fetchAllProductsInventory();
        List<ProductInventoryResource> productInventoryResources = DomainToResourceMapper.map(fetchedProductsInventory);
        return new ResponseEntity<>(productInventoryResources, HttpStatus.OK);
    }

    @ApiOperation(value = "Find product by id", notes = "Returns the product by ID from inventory.")
    @RequestMapping(value = "/inventory/{productId}", produces = {
            MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity<ProductInventoryResource> fetchProductInventoryByProductId(
            @PathVariable("productId") long productId) {

        ProductInventory fetchedProductInventory = inventoryService.fetchProductInventoryByProductId(productId);

        ProductInventoryResource productInventoryResource = DomainToResourceMapper.map(fetchedProductInventory);

        return new ResponseEntity<>(productInventoryResource, HttpStatus.OK);
    }

    @ApiOperation(value = "Save products", notes = "Saves product in inventory.")
    @RequestMapping(value = "/inventory", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    public ResponseEntity<ProductInventoryResource> saveProductInventory(
            @RequestBody ProductInventoryResource productInventoryResource) {

        logger.info("productInventoryResource details passed from UI to save is : {}", productInventoryResource);
        ProductInventory productInventory = ResourceToDomainMapper.map(productInventoryResource);
        logger.info("got the object to save : {}", productInventory);
        productInventory = inventoryService.saveProductInventory(productInventory);

        ProductInventoryResource savedProductInventoryResource = DomainToResourceMapper.map(productInventory);

        return new ResponseEntity<>(savedProductInventoryResource, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete product by Id", notes = "delete data from inventory")
    @RequestMapping(value = "/inventory/{productId}", produces = {
            MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.DELETE)
    public ResponseEntity<ProductInventoryResource> deleteProductInventory(@PathVariable("productId") long productId) {

        inventoryService.deleteProductInventory(productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
