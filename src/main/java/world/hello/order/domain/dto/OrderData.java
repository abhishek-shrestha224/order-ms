package world.hello.order.domain.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderData(String skuCode, BigDecimal price, Integer quantity) {}