package rafaelgoncalves.application.query;

import rafaelgoncalves.domain.UserRepository;
import rafaelgoncalves.domain.User;
import rafaelgoncalves.application.query.base.QueryService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FindUserService implements QueryService<UserDto, FindUser> {

	private final UserRepository userRepository;

	@Inject
	public FindUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto execute(FindUser findUser) {
		User user = userRepository.get(findUser.userId());
		return UserDtoMap.map(user);
	}
}
