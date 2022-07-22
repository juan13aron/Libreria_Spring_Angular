package co.edu.ucentral.servicio.prestamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioPrestamoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioPrestamoApplication.class, args);
	}

}
