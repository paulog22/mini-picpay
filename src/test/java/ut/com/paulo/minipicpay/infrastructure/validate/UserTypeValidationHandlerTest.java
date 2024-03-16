package ut.com.paulo.minipicpay.infrastructure.validate;

import com.paulo.minipicpay.infrastructure.validate.UserTypeValidationHandler;
import com.paulo.minipicpay.model.User;
import com.paulo.minipicpay.model.ValidateTransferHandler;
import com.paulo.minipicpay.model.exception.TransferNotAllowedException;
import org.junit.Test;

import java.math.BigDecimal;

import static com.paulo.minipicpay.UserFixture.aPersonUser;
import static com.paulo.minipicpay.UserFixture.aStoreUser;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserTypeValidationHandlerTest {

    @Test
    public void shouldContinue() {
        User sender = aPersonUser();
        BigDecimal amount = BigDecimal.valueOf(200);

        handler.validate(sender, amount);

        verify(next).validate(sender, amount);
    }

    @Test(expected = TransferNotAllowedException.class)
    public void throwsTransferNotAllowedException() {
        User sender = aStoreUser();
        BigDecimal amount = BigDecimal.valueOf(200);

        handler.validate(sender, amount);
    }

    private final ValidateTransferHandler next = mock(ValidateTransferHandler.class);
    private final UserTypeValidationHandler handler = new UserTypeValidationHandler(next);
}
