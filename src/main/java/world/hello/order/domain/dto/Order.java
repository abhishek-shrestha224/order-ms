package world.hello.order.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
  private String orderNumber;
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;
}