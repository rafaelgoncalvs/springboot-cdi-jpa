package rafaelgoncalves.applicationservice.command;

import org.springframework.transaction.annotation.Transactional;
import rafaelgoncalves.domain.UserRepository;
import rafaelgoncalves.domain.User;
import rafaelgoncalves.applicationservice.command.base.CommandConfirmation;
import rafaelgoncalves.applicationservice.command.base.CommandService;

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
