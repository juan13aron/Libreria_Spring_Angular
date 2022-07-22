package co.edu.ucentral.servicio.genero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioGeneroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioGeneroApplication.class, args);
	}

}
