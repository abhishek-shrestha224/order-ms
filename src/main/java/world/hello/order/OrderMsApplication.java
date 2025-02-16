package world.hello.order;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import world.hello.order.repository.OrderRepository;

@SpringBootApplication
public class OrderMsApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderMsApplication.class, args);
  }
}