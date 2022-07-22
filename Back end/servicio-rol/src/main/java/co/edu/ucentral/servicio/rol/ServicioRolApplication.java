package co.edu.ucentral.servicio.rol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"co.edu.ucentral.common.rol.model"})
public class ServicioRolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioRolApplication.class, args);
	}

}
