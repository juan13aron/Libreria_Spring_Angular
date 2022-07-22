package co.edu.ucentral.servicio.materias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioMateriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioMateriasApplication.class, args);
	}

}
