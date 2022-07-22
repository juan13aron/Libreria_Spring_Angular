package co.edu.ucentral.servicio.editoriales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioEditorialesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioEditorialesApplication.class, args);
	}

}
