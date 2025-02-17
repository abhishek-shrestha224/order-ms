package world.hello.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-MS")
public interface InventoryClient {
  @GetMapping("/api/v1/inventory")
  boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}