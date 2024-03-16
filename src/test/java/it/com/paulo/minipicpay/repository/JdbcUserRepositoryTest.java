package it.com.paulo.minipicpay.repository;

import com.paulo.minipicpay.context.IntegrationTestsContext;
import com.paulo.minipicpay.infrastructure.repository.JdbcUserRepository;
import com.paulo.minipicpay.model.Document;
import com.paulo.minipicpay.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

import static com.paulo.minipicpay.UserFixture.aPersonUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class JdbcUserRepositoryTest {

    @Test
    public void shouldCreateUser() {
        User user = aPersonUser();

        userRepository.insert(user);

        assertThatUserWasInserted(user.document());
    }

    @Test
    public void shouldUpdateBalance() {
        User user = aPersonUser();
        BigDecimal amount = BigDecimal.valueOf(100);
        user.increaseBalance(amount);

        userRepository.updateBalance(user, amount);

        assertThat(user.balance(), is(BigDecimal.valueOf(1100)));
    }

    private void assertThatUserWasInserted(Document document) {
        User user = userRepository.findBy(document);

        assertNotNull(user);
        assertThat(user.document(), is(document));
    }

    @Before
    public void setup() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (type VARCHAR(255), name VARCHAR(255), " +
                "email VARCHAR(255) UNIQUE, document VARCHAR(255) UNIQUE, password VARCHAR(255), " +
                "balance DECIMAL(10, 2))");
        jdbcTemplate.execute("CREATE INDEX IF NOT EXISTS idx_document ON users(document)");
    }

    @After
    public void cleanup() {
        jdbcTemplate.execute("DELETE FROM users");
    }

    private final ApplicationContext context = IntegrationTestsContext.applicationContext();
    private final JdbcUserRepository userRepository = context.getBean(JdbcUserRepository.class);
    private final JdbcTemplate jdbcTemplate =  context.getBean(JdbcTemplate.class);
}
