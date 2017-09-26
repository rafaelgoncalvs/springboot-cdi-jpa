package springbootcdijpa.application.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import springbootcdijpa.application.base.IntegrationTest;
import springbootcdijpa.domain.User;
import springbootcdijpa.domain.UserRepository;
import springbootcdijpa.application.command.base.CommandConfirmation;

import javax.inject.Inject;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
public class AddUserServiceTest extends IntegrationTest {

    @Inject
    private AddUserService addUserService;

    @Inject
    private UserRepository userRepository;

    @Test
    public void shouldAddUser() {
        String name = "Name test";
        AddUser addUser = new AddUser(name);

        CommandConfirmation commandConfirmation = addUserService.execute(addUser);

        User user = userRepository.get(Long.valueOf(commandConfirmation.value()));
        assertThat(user.id(), is(Long.valueOf(commandConfirmation.value())));
        assertThat(user.name(), is(name));
    }
}
