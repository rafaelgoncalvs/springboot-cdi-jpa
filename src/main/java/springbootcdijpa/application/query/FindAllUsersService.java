package springbootcdijpa.application.query;

import springbootcdijpa.application.query.base.EmptyQuery;
import springbootcdijpa.application.query.base.QueryService;
import springbootcdijpa.domain.UserRepository;
import springbootcdijpa.domain.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Named
public class FindAllUsersService implements QueryService<List<UserDto>, EmptyQuery> {

    private final UserRepository userRepository;

    @Inject
    public FindAllUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> execute(EmptyQuery emptyQuery) {
        List<User> users = userRepository.getAll();
        return users.stream().map(UserDtoMap::map).collect(toList());
    }
}
