package springbootcdijpa.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void shouldCreateAnUser() throws Exception {
        String name = "User name";

        User user = new User(name);

        assertThat(user.name(), is(name));
    }
}
