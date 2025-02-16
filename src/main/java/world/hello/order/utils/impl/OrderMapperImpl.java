package world.hello.order.utils.impl;

import world.hello.order.domain.dto.Order;
import world.hello.order.domain.dto.OrderData;
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
  public Order toDto(OrderData data) {
    return Order.builder()
        .orderNumber(null)
        .skuCode(data.skuCode())
        .price(data.price())
        .quantity(data.quantity())
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