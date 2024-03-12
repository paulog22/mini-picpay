package ut.com.paulo.minipicpay.application;

import com.paulo.minipicpay.application.UserService;
import com.paulo.minipicpay.model.*;
import org.junit.Test;

import static com.paulo.minipicpay.UserFixture.aPersonUser;
import static com.paulo.minipicpay.UserFixture.aStoreUser;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void delegatesToPicPayTransfer() {
        Document senderDocument = Document.of("123.123.123-12");
        Document recipientDocument = Document.of("111.111.111-11");
        Double amount = 234.12;
        when(userRepository.findBy(senderDocument)).thenReturn(aPersonUser());
        when(userRepository.findBy(recipientDocument)).thenReturn(aStoreUser());

        service.transfer(senderDocument, recipientDocument, amount);

        verify(userRepository, times(1)).findBy(senderDocument);
        verify(userRepository, times(1)).findBy(recipientDocument);
        verify(picPay, times(1)).transfer(any(User.class), any(User.class), anyDouble());
    }

    @Test
    public void y() {

    }

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserFactory factory = mock(UserFactory.class);
    private final PicPay picPay = mock(PicPay.class);
    private final UserService service = new UserService(factory, userRepository, picPay);
}
