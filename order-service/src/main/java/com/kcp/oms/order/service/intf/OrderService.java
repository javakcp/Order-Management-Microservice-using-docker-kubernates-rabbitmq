package com.kcp.oms.order.service.intf;

import java.util.List;
import java.util.Optional;

import com.kcp.oms.order.dto.OrderRequestResource;
import com.kcp.oms.order.dto.ProductInventoryResource;
import com.kcp.oms.order.model.Order;
import com.kcp.oms.order.service.exception.OrderServiceException;

/**
 * 
 * @author kapanda
 *
 */
public interface OrderService {

    public List<Order> fetchAllOrders() throws OrderServiceException;

    public Order fetchOrderById(long orderId) throws OrderServiceException;

    public void deleteOrder(long orderId) throws OrderServiceException;

    public Order processOrder(OrderRequestResource newOrderRequest, Optional<ProductInventoryResource> productInventory)
            throws OrderServiceException;

}
