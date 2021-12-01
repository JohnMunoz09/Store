package reto.mintic.ciclo4.Reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @Author John Muñoz
 * @Version 1.0
 */
@EntityScan(basePackages = {"reto.mintic.ciclo4.Reto"})
@SpringBootApplication
public class RetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoApplication.class, args);
	}

}
