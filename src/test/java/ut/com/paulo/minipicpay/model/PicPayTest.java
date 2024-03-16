package ut.com.paulo.minipicpay.model;

import com.paulo.minipicpay.model.*;
import org.junit.Test;

import java.math.BigDecimal;

import static com.paulo.minipicpay.UserFixture.aPersonUser;
import static com.paulo.minipicpay.UserFixture.aStoreUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class PicPayTest {

    @Test
    public void shouldMakeATransfer() {
        User sender = aPersonUser();
        User receiver = aStoreUser();
        BigDecimal amount = BigDecimal.valueOf(100.37);

        picPay.transfer(sender, receiver, amount);

        assertThat(sender.balance(), is(BigDecimal.valueOf(899.63)));
        assertThat(receiver.balance(), is(BigDecimal.valueOf(200.47)));
        verify(validateTransferHandler, times(1)).validate(sender, amount);
        verify(userRepository, times(1)).updateBalance(sender, amount);
        verify(userRepository, times(1)).updateBalance(receiver, amount);
        verify(transactionRepository, times(1)).insert(any());
    }

    private final TransactionRepository transactionRepository = mock(TransactionRepository.class);
    private final UserRepository userRepository = mock(UserRepository.class);
    private final ValidateTransferHandler validateTransferHandler = mock(ValidateTransferHandler.class);
    private final PicPay picPay = new PicPay(userRepository, transactionRepository, validateTransferHandler);
}
