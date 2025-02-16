package world.hello.order.utils;

import world.hello.order.domain.dto.Order;
import world.hello.order.domain.dto.OrderData;
import world.hello.order.domain.model.OrderTable;

public interface OrderMapper {
  Order toDto(OrderTable entity);

  Order toDto(OrderData data);

  OrderTable toEntity(Order dto);
}