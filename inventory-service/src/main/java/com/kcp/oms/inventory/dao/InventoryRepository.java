package com.kcp.oms.inventory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author kapanda
 *
 */
@Repository
public interface InventoryRepository extends CrudRepository<ProductInventory, Long> {

}
