package sv.edu.udb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "sv.edu.udb")
public class RazasServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RazasServiceApplication.class, args);
    }
} 