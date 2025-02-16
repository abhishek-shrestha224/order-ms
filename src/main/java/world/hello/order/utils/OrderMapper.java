package world.hello.order.utils;

import world.hello.order.domain.dto.Order;
import world.hello.order.domain.model.OrderTable;

public interface OrderMapper {
  Order toDto(OrderTable entity);

  OrderTable toEntity(Order dto);
}