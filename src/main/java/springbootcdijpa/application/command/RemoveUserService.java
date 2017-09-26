package springbootcdijpa.application.command;

import org.springframework.transaction.annotation.Transactional;
import springbootcdijpa.application.command.base.CommandService;
import springbootcdijpa.domain.UserRepository;
import springbootcdijpa.domain.User;
import springbootcdijpa.application.command.base.CommandConfirmation;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RemoveUserService implements CommandService<RemoveUser> {

    private final UserRepository userRepository;

    @Inject
    public RemoveUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public CommandConfirmation execute(RemoveUser removeUser) {
        User user = userRepository.get(removeUser.id());
        userRepository.remove(user);
        return CommandConfirmation.empty();
    }
}
