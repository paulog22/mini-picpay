package ut.com.paulo.minipicpay.application;

import com.paulo.minipicpay.application.CreateUserRequest;
import com.paulo.minipicpay.application.UserService;
import com.paulo.minipicpay.model.*;
import org.junit.Test;

import java.math.BigDecimal;

import static com.paulo.minipicpay.UserFixture.aPersonUser;
import static com.paulo.minipicpay.UserFixture.aStoreUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void delegatesToPicPayTransfer() {
        Document senderDocument = Document.of("123.123.123-12");
        Document recipientDocument = Document.of("111.111.111-11");
        BigDecimal amount = BigDecimal.valueOf(234.12);
        when(userRepository.findBy(senderDocument)).thenReturn(aPersonUser());
        when(userRepository.findBy(recipientDocument)).thenReturn(aStoreUser());

        service.transfer(senderDocument, recipientDocument, amount);

        verify(userRepository, times(1)).findBy(senderDocument);
        verify(userRepository, times(1)).findBy(recipientDocument);
        verify(picPay, times(1)).transfer(any(User.class), any(User.class), any());
    }

    @Test
    public void delegatesToFactory() {
        User user = aPersonUser();
        CreateUserRequest createUserRequest = new CreateUserRequest(user.userType().name(), user.name().value(),
                user.document().value(), user.email().value(), user.password().value());
        when(factory.newUserWith(user.userType(), user.name(), user.document(), user.email(), user.password()))
                .thenReturn(aPersonUser());

        User userCreated = service.create(createUserRequest);

        verify(factory, times(1))
                .newUserWith(user.userType(), user.name(), user.document(), user.email(), user.password());
        assertThat(user.balance(), is(userCreated.balance()));
        assertThat(user.userType(), is(userCreated.userType()));
        assertThat(user.name(), is(userCreated.name()));
        assertThat(user.email(), is(userCreated.email()));
        assertThat(user.password(), is(userCreated.password()));
        assertThat(user.document(), is(userCreated.document()));
    }

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserFactory factory = mock(UserFactory.class);
    private final PicPay picPay = mock(PicPay.class);
    private final UserService service = new UserService(factory, userRepository, picPay);
}
