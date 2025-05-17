package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"api", "domain"})
@EntityScan(basePackages = {"domain"})
@EnableJpaRepositories(basePackages = {"domain"})

public class CarrosApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarrosApplication.class, args);
    }
}


