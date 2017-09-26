package springbootcdijpa.application.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import springbootcdijpa.application.base.IntegrationTest;
import springbootcdijpa.application.base.UserPersist;
import springbootcdijpa.domain.User;
import springbootcdijpa.domain.UserRepository;

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
