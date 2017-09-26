package rafaelgoncalves.application.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import rafaelgoncalves.application.base.IntegrationTest;
import rafaelgoncalves.application.base.UserPersist;
import rafaelgoncalves.domain.User;

import javax.inject.Inject;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
public class FindUserServiceTest extends IntegrationTest {

	@Inject
	private FindUserService findUserService;

	@Inject
	private UserPersist userPersist;

	@Test
	public void shouldGetAllUsers() {
		String name = "Name test";
		User user = new User(name);
		userPersist.persist(user);
		FindUser findUser = new FindUser(user.id());

		UserDto userDto = findUserService.execute(findUser);

		assertThat(userDto.getId(), is(user.id()));
		assertThat(userDto.getName(), is(user.name()));
	}

}
