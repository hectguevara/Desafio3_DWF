package sv.edu.udb.colonias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "sv.edu.udb.colonias")
public class ColoniasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColoniasServiceApplication.class, args);
	}
}
