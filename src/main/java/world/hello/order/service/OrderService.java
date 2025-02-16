package world.hello.order.service;

import world.hello.order.domain.dto.Order;
import world.hello.order.domain.dto.OrderData;

public interface OrderService {
    Order placeOrder(OrderData data);
}