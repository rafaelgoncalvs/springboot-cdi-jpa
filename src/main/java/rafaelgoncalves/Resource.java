package rafaelgoncalves;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("resources")
public class Resource {

	@Inject
	private Service service;
	
	@GET
	public String get() {
		List<EntityDTO> entityDTOs = service.doSameThing();
		return entityDTOs.toString();
	}
}
