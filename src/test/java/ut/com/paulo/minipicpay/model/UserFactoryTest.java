package ut.com.paulo.minipicpay.model;

import com.paulo.minipicpay.model.*;
import com.paulo.minipicpay.model.exception.InvalidCpfValueException;
import com.paulo.minipicpay.model.exception.InvalidUserTypeException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.mockito.Mockito.*;

public class UserFactoryTest {

    @Test
    public void createsPersonUser() {
        UserType userType = UserType.PERSON;
        UserName name = UserName.of("Paulo Vitor");
        Document document = Document.of("123.123.123.12");
        UserEmail email = UserEmail.of("paulo@gmail.com");
        Password password = Password.of("111111111");

        User user = factory.newUserWith(userType, name, document, email, password);

        assertThat(user.userType(), is(UserType.PERSON));
        assertThat(user.name().value(), is("Paulo Vitor"));
        assertThat(user.document().value(), is("123.123.123.12"));
        assertThat(user.email().value(), is("paulo@gmail.com"));
        assertThat(user.password().value(), is("111111111"));
        assertThat(user.balance(), comparesEqualTo(BigDecimal.ZERO));
        verify(userRepository, times(1)).insert(user);
    }

    @Test
    public void shouldCreateAValidCpf() {
        Document.of("123.123.123-12");
        Document.of("12312312312");
    }

    @Test(expected = InvalidCpfValueException.class)
    public void shouldThrowInvalidCpfValueException() {
        Document.of("123.123ola");
    }

    @Test(expected = InvalidUserTypeException.class)
    public void shouldThrowInvalidUserTypeException() {
        UserType.from("UNKNOWN");
    }

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserFactory factory = new UserFactory(userRepository);
}
