package co.edu.ucentral.servicio.estado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan({"co.edu.ucentral.common.estado.model"})
@EnableEurekaClient
public class ServicioEstadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioEstadoApplication.class, args);
	}

}
