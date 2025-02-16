package world.hello.order.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "t_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderTable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String orderNumber;
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;
}