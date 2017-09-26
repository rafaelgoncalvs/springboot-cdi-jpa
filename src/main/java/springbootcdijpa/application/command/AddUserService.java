package springbootcdijpa.application.command;

import org.springframework.transaction.annotation.Transactional;
import springbootcdijpa.application.command.base.CommandConfirmation;
import springbootcdijpa.application.command.base.CommandService;
import springbootcdijpa.domain.UserRepository;
import springbootcdijpa.domain.User;

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
