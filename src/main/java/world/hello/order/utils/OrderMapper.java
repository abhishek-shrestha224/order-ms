package world.hello.order.utils;

import world.hello.order.domain.dto.Order;
import world.hello.order.domain.dto.OrderData;
import world.hello.order.domain.entity.OrderEntity;

public interface OrderMapper {
  Order toDto(OrderEntity entity);

  Order toDto(OrderData data);

  OrderEntity toEntity(Order dto);
}