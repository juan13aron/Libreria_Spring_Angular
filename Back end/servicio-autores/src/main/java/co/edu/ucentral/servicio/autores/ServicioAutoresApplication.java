package co.edu.ucentral.servicio.autores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioAutoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioAutoresApplication.class, args);
	}

}
