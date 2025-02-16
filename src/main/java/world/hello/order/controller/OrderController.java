package world.hello.order.controller;

import com.sun.net.httpserver.HttpsServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import world.hello.order.domain.dto.Order;
import world.hello.order.domain.dto.OrderData;
import world.hello.order.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
  private final OrderService orderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Order placeOrder(@RequestBody OrderData data) {
    log.info("POST /api/v1/orders");
    return orderService.placeOrder(data);
  }

  @GetMapping("/{orderNumber}")
  @ResponseStatus(HttpStatus.OK)
  public Order findOrderByOrderNumber(@PathVariable("orderNumber") final String orderNumber) {
    log.info("GET /api/vi/orders/{}", orderNumber);
    return orderService.fetchOrderByOrderNumber(orderNumber);
  }
}