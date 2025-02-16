package world.hello.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.hello.order.domain.entity.OrderEntity;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByOrderNumber(String orderNumber);
}