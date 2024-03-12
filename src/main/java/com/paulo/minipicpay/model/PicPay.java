package com.paulo.minipicpay.model;

import java.math.BigDecimal;

public class PicPay {

    private final UserRepository userRepository;
    private final ValidateTransferHandler validateHandler;

    public PicPay(UserRepository userRepository, ValidateTransferHandler validateHandler) {
        this.userRepository = userRepository;
        this.validateHandler = validateHandler;
    }

    public void transfer(User sender, User recipient, BigDecimal amount) {
        validateHandler.validate(sender, amount);
        sender.decreaseBalance(amount);
        recipient.increaseBalance(amount);
        updateUsersBalance(sender, recipient, amount);
    }

    private void updateUsersBalance(User sender, User recipient, BigDecimal amount) {
        userRepository.updateBalance(sender, amount);
        userRepository.updateBalance(recipient, amount);
    }
}
