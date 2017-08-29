package rafaelgoncalves.applicationservice.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import rafaelgoncalves.applicationservice.base.IntegrationTest;
import rafaelgoncalves.domain.User;
import rafaelgoncalves.domain.UserRepository;
import rafaelgoncalves.applicationservice.command.base.CommandConfirmation;

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
