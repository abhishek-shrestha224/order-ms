package world.hello.order.utils.impl;

import world.hello.order.domain.dto.Order;
import world.hello.order.domain.model.OrderTable;
import world.hello.order.utils.OrderMapper;

public class OrderMapperImpl implements OrderMapper {
  @Override
  public Order toDto(OrderTable entity) {
    return Order.builder()
        .orderNumber(entity.getOrderNumber())
        .skuCode(entity.getSkuCode())
        .price(entity.getPrice())
        .quantity(entity.getQuantity())
        .build();
  }

  @Override
  public OrderTable toEntity(Order dto) {
    return OrderTable.builder()
        .id(null)
        .orderNumber(dto.orderNumber())
        .skuCode(dto.skuCode())
        .price(dto.price())
        .quantity(dto.quantity())
        .build();
  }
}