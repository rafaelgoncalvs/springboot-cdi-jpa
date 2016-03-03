package rafaelgoncalves;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Service {
	
	@Inject
	private Repository repository;

	public List<EntityDTO> doSameThing() {
		List<EntityTest> entityTests = repository.findAll(); 
		return entityTests.stream().map(entityTest -> createEntityTest(entityTest)).collect(Collectors.toList());
	}

	private EntityDTO createEntityTest(EntityTest entityTest) {
		return new EntityDTO(entityTest.getId(), entityTest.getName());
	}
}
