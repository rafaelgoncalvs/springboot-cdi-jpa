package springbootcdijpa.application.query;

import springbootcdijpa.application.query.base.QueryService;
import springbootcdijpa.domain.UserRepository;
import springbootcdijpa.domain.User;

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
