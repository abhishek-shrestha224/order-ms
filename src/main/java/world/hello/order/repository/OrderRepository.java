package world.hello.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.hello.order.domain.model.OrderTable;

public interface OrderRepository extends JpaRepository<OrderTable, Long> {}