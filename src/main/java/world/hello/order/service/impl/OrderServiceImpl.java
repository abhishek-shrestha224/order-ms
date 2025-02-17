package world.hello.order.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import world.hello.order.client.InventoryClient;
import world.hello.order.domain.dto.Order;
import world.hello.order.domain.dto.OrderData;
import world.hello.order.domain.entity.OrderEntity;
import world.hello.order.repository.OrderRepository;
import world.hello.order.service.OrderService;
import world.hello.order.utils.OrderMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;
  private final InventoryClient inventoryClient;

  @Override
  public Order placeOrder(OrderData data) {
    try {
      log.info("Placing order for: {}", data);

      if (!inventoryClient.isInStock(data.skuCode(), data.quantity())) {
        log.warn("Not enough stock to order");
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product is not in stock.");
      }

      final Order newOrder = orderMapper.toDto(data);
      newOrder.setOrderNumber(UUID.randomUUID().toString());
      log.info("New Order: {}", newOrder);

      final OrderEntity placedOrder = orderRepository.save(orderMapper.toEntity(newOrder));
      log.info("Placed Order: {}", placedOrder);
      return orderMapper.toDto(placedOrder);

    } catch (ResponseStatusException ex) {
      log.error(ex.getMessage());
      throw ex;
    } catch (Exception ex) {
      log.error(ex.getMessage());
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "Something Went Wrong while placing an order.");
    }
  }

  @Override
  public Order fetchOrderByOrderNumber(String orderNumber) {
    try {
      log.info("Finding order by orderNumber: {}", orderNumber);
      OrderEntity order =
          orderRepository
              .findByOrderNumber(orderNumber)
              .orElseThrow(
                  () ->
                      new ResponseStatusException(
                          HttpStatus.NOT_FOUND,
                          "Order with orderNumber " + orderNumber + "not found"));
      log.info("Order found: {}", order);
      return orderMapper.toDto(order);
    } catch (ResponseStatusException ex) {
      log.error(ex.getMessage());
      throw ex;
    } catch (Exception ex) {
      log.error(ex.getMessage());
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong while fetching error");
    }
  }
}