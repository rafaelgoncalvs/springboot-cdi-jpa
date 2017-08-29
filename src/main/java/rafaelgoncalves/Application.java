package rafaelgoncalves;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rafaelgoncalves.resource.UserResource;

@SpringBootApplication
public class Application {
	
	@Named
	public static class ConfigRestResources extends ResourceConfig {
		public ConfigRestResources() {
			this.register(UserResource.class);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
