package ut.com.paulo.minipicpay.infrastructure.validate;

import com.paulo.minipicpay.infrastructure.validate.BalanceValidationHandler;
import com.paulo.minipicpay.model.User;
import com.paulo.minipicpay.model.ValidateTransferHandler;
import com.paulo.minipicpay.model.exception.InsufficientBalanceException;
import org.junit.Test;

import java.math.BigDecimal;

import static com.paulo.minipicpay.UserFixture.aPersonUser;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BalanceValidationHandlerTest {

    @Test
    public void shouldContinue() {
        User sender = aPersonUser();
        BigDecimal amount = BigDecimal.valueOf(1000);

        handler.validate(sender, amount);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void throwsInsufficientBalanceException() {
        User sender = aPersonUser();
        BigDecimal amount = BigDecimal.valueOf(1000.01);

        handler.validate(sender, amount);
    }

    private final ValidateTransferHandler next = mock(ValidateTransferHandler.class);
    private final BalanceValidationHandler handler = new BalanceValidationHandler(next);
}
