package rafaelgoncalves;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	@Named
	public static class ConfigRestResources extends ResourceConfig {
		public ConfigRestResources() {
			this.register(Resource.class);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
