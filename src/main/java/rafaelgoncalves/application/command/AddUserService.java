package rafaelgoncalves.application.command;

import org.springframework.transaction.annotation.Transactional;
import rafaelgoncalves.domain.UserRepository;
import rafaelgoncalves.domain.User;
import rafaelgoncalves.application.command.base.CommandConfirmation;
import rafaelgoncalves.application.command.base.CommandService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AddUserService implements CommandService<AddUser> {

    private final UserRepository userRepository;

    @Inject
    public AddUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public CommandConfirmation execute(AddUser addUser) {
        User user = new User(addUser.name());
        userRepository.add(user);
        return CommandConfirmation.of(user.id());
    }
}
