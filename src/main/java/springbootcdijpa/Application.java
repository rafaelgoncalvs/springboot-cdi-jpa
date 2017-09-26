package springbootcdijpa;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springbootcdijpa.resource.UserResource;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	@Named
	public static class ConfigRestResources extends ResourceConfig {
		public ConfigRestResources() {
			this.register(UserResource.class);
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
