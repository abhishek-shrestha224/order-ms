package world.hello.order;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import world.hello.order.repository.OrderRepository;

@SpringBootApplication
@EnableFeignClients
public class OrderMsApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderMsApplication.class, args);
  }
}