package com.kcp.oms.order.service.mapper;

import com.kcp.oms.order.dto.OrderResource;
import com.kcp.oms.order.model.Order;

/**
 * 
 * @author kapanda
 *
 */
public class ResourceToDomainMapper {

    public static Order map(OrderResource orderResource) {
        Order order = Order.newInstance(orderResource.getUserId(), orderResource.getProductId(),
                orderResource.getQuantity(), orderResource.getTotalPrice());
        return order;
    }

}
