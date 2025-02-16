package world.hello.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.hello.order.domain.dto.Order;
import world.hello.order.domain.dto.OrderData;
import world.hello.order.repository.OrderRepository;
import world.hello.order.service.OrderService;
import world.hello.order.utils.OrderMapper;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;

  @Override
  public Order placeOrder(OrderData data) {
    final Order newOrder = Order.builder().build();
    return null;
  }
}