package co.edu.ucentral.servicio.colecciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioColeccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioColeccionesApplication.class, args);
	}

}
