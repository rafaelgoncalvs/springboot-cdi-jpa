package springbootcdijpa.application.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import springbootcdijpa.application.base.IntegrationTest;
import springbootcdijpa.application.base.UserPersist;
import springbootcdijpa.application.query.base.EmptyQuery;
import springbootcdijpa.domain.User;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class FindAllUsersServiceTest extends IntegrationTest {

    @Inject
    private FindAllUsersService findAllUsersService;

    @Inject
    private UserPersist userPersist;

    @Test
    public void shouldFindAllUsers() {
        User userRafael = new User("Rafael");
        userPersist.persist(userRafael);
        User userGabriel = new User("Gabriel");
        userPersist.persist(userGabriel);

        List<UserDto> usersDtos = findAllUsersService.execute(EmptyQuery.create());

        assertThat(usersDtos, hasSize(2));
        assertTrue(usersDtos.stream().anyMatch(userDto -> areAttributesEquals(userRafael, userDto)));
        assertTrue(usersDtos.stream().anyMatch(userDto -> areAttributesEquals(userGabriel, userDto)));
    }

    private boolean areAttributesEquals(User user, UserDto userDto) {
        return user.id().equals(userDto.getId()) && user.name().equals(userDto.getName());
    }
}
