package rafaelgoncalves.application.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import rafaelgoncalves.application.base.IntegrationTest;
import rafaelgoncalves.application.base.UserPersist;
import rafaelgoncalves.domain.User;
import rafaelgoncalves.domain.UserRepository;

import javax.inject.Inject;

import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
public class RemoveUserServiceTest extends IntegrationTest {

    @Inject
    private RemoveUserService removeUserService;

    @Inject
    private UserPersist userPersist;

    @Inject
    private UserRepository userRepository;

    @Test
    public void shouldRemoveUser() {
        User user = new User("User test");
        userPersist.persist(user);
        RemoveUser removeUser = new RemoveUser(user.id());

        removeUserService.execute(removeUser);

        User userRemoved = userRepository.get(user.id());
        assertNull(userRemoved);
    }
}