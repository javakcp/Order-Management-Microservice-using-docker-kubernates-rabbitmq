package com.kcp.oms.order.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kcp.oms.order.model.Order;

/**
 * 
 * @author kapanda
 *
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
