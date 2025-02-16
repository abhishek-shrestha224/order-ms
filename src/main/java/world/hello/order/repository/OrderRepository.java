package world.hello.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.hello.order.domain.model.OrderTable;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderTable, Long> {
    Optional<OrderTable> findByOrderNumber(String orderNumber);
}