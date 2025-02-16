package world.hello.order.utils.impl;

import lombok.extern.slf4j.Slf4j;
import world.hello.order.domain.dto.Order;
import world.hello.order.domain.dto.OrderData;
import world.hello.order.domain.model.OrderTable;
import world.hello.order.utils.OrderMapper;

@Slf4j
public class OrderMapperImpl implements OrderMapper {

  @Override
  public Order toDto(OrderTable entity) {
    log.info("Mapping OrderTable entity to Order DTO: {}", entity);
    Order order =
        Order.builder()
            .orderNumber(entity.getOrderNumber())
            .skuCode(entity.getSkuCode())
            .price(entity.getPrice())
            .quantity(entity.getQuantity())
            .build();
    log.info("OrderTable -> Order: {}", order);
    return order;
  }

  @Override
  public Order toDto(OrderData data) {
    log.info("Mapping OrderData to Order DTO: {}", data);
    Order order =
        Order.builder()
            .orderNumber(null)
            .skuCode(data.skuCode())
            .price(data.price())
            .quantity(data.quantity())
            .build();
    log.info("OrderData -> Order: {}", order);
    return order;
  }

  @Override
  public OrderTable toEntity(Order dto) {
    log.info("Mapping Order DTO to OrderTable entity: {}", dto);
    OrderTable orderTable =
        OrderTable.builder()
            .id(null)
            .orderNumber(dto.orderNumber())
            .skuCode(dto.skuCode())
            .price(dto.price())
            .quantity(dto.quantity())
            .build();
    log.info("Mapped OrderTable entity: {}", orderTable);
    return orderTable;
  }
}