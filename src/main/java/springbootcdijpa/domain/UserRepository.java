package springbootcdijpa.domain;

import java.util.List;

public interface UserRepository {
	List<User> getAll();
    User get(Long userId);
    void add(User user);
    void remove(User user);
}
