package co.edu.ucentral.servicio.tipocoleccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioTipoColeccionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioTipoColeccionApplication.class, args);
	}

}
