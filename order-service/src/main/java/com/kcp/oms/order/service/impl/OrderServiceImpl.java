package com.kcp.oms.order.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kcp.oms.order.dto.OrderRequestResource;
import com.kcp.oms.order.dto.ProductInventoryResource;
import com.kcp.oms.order.model.Order;
import com.kcp.oms.order.service.exception.OrderServiceException;
import com.kcp.oms.order.service.intf.OrderService;
import com.kcp.oms.order.service.repo.OrderRepository;

/**
 * 
 * @author kapanda
 *
 */
@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> fetchAllOrders() throws OrderServiceException {

        List<Order> fetchedOrders = orderRepository.findAll();

        if (CollectionUtils.isEmpty(fetchedOrders))
            throw OrderServiceException.create("No orders found");

        return fetchedOrders;
    }

    @Override
    public Order fetchOrderById(long orderId) throws OrderServiceException {

        Optional<Order> fetchedOrder = orderRepository.findById(orderId);

        Order order = fetchedOrder.orElseThrow(() -> OrderServiceException.create("Order not found"));

        return order;
    }

    @Override
    public void deleteOrder(long orderId) throws OrderServiceException {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order processOrder(OrderRequestResource newOrderRequest, Optional<ProductInventoryResource> productInventory)
            throws OrderServiceException {

        ProductInventoryResource productInventoryResource = productInventory
                .orElseThrow(() -> OrderServiceException.create("Error processing order - No product inventory"));

        // Validate quantity
        if (newOrderRequest.getQuantity().intValue() > productInventoryResource.getQuantity().intValue())
            throw OrderServiceException.create("Error processing order - Requested product quantity not available");

        // Calculate total price
        BigDecimal unitProductPrice = new BigDecimal(productInventory.get().getProductPrice());
        BigDecimal totalPrice = unitProductPrice.multiply(new BigDecimal(newOrderRequest.getQuantity().intValue()));

        Order order = Order.newInstance(newOrderRequest.getUserId(), productInventory.get().getProductId(),
                newOrderRequest.getQuantity(), totalPrice);

        // Save order
        order = orderRepository.save(order);

        return order;
    }

}
