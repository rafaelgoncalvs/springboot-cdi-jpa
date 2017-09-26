package springbootcdijpa.application.base;

import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class IntegrationTest {

    @Inject
    private DataBaseUtil dataBaseUtil;

    @Before
    public void before() {
        dataBaseUtil.clear();
    }
}
