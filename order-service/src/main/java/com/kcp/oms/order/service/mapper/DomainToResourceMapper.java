package com.kcp.oms.order.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.kcp.oms.order.dto.OrderResource;
import com.kcp.oms.order.model.Order;

/**
 * 
 * @author kapanda
 *
 */
public class DomainToResourceMapper {

    public static OrderResource map(Order order) {
        OrderResource orderResource = OrderResource.newInstance(order.getUserId(), order.getOrderId(),
                order.getProductId(), order.getQuantity(), order.getTotalPrice(), order.getDateCreated());
        return orderResource;
    }

    public static List<OrderResource> map(List<Order> orders) {
        List<OrderResource> orderResources = orders.stream()
                .map(order -> OrderResource.newInstance(order.getUserId(), order.getOrderId(), order.getProductId(),
                        order.getQuantity(), order.getTotalPrice(), order.getDateCreated()))
                .collect(Collectors.toList());
        return orderResources;
    }

}
