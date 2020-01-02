package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages= {"model"})
@ComponentScan(basePackages = {"service","controlador"}) 
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@LoadBalanced // Permite usar servicios que estan en el servidor Eureka
	@Bean
	public RestTemplate crearTemplate() {
		// creacion de interceptores de seguridad
		BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor("admin","admin");
		RestTemplate template = new RestTemplate();
		template.getInterceptors().add(interceptor);
		return template;
	}
}
