package ut.com.paulo.minipicpay.model;

import com.paulo.minipicpay.model.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class UserFactoryTest {

    @Test
    public void createsPersonUser() {
        UserType userType = UserType.PERSON;
        UserName name = UserName.of("Paulo Vitor");
        Cpf cpf = Cpf.of("123.123.123.12");
        UserEmail email = UserEmail.of("paulo@gmail.com");
        Password password = Password.of("111111111");

        User user = factory.newUserWith(userType, name, cpf, email, password);

        assertThat(user.userType(), is(UserType.PERSON));
        assertThat(user.name().value(), is("Paulo Vitor"));
        assertThat(user.cpf().value(), is("123.123.123.12"));
        assertThat(user.email().value(), is("paulo@gmail.com"));
        assertThat(user.password().value(), is("111111111"));
        assertThat(user.balance(), is(0D));
        verify(userRepository, times(1)).insert(user);
    }

    @Test
    public void shouldCreateAValidCpf() {
        Cpf.of("123.123.123-12");
        Cpf.of("12312312312");
    }

    @Test(expected = InvalidCpfValueException.class)
    public void shouldThrowInvalidCpfValueException() {
        Cpf.of("123.123ola");
    }

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserFactory factory = new UserFactory(userRepository);
}
