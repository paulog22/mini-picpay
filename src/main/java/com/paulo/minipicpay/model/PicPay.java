package com.paulo.minipicpay.model;

import java.math.BigDecimal;

public class PicPay {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final ValidateTransferHandler validateHandler;

    public PicPay(UserRepository userRepository, TransactionRepository transactionRepository,
                  ValidateTransferHandler validateHandler) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.validateHandler = validateHandler;
    }

    public void transfer(User sender, User receiver, BigDecimal amount) {
        validateHandler.validate(sender, amount);
        sender.decreaseBalance(amount);
        receiver.increaseBalance(amount);
        updateUsersBalance(sender, receiver, amount);
        transactionRepository.insert(new Transaction(sender, receiver, amount));
    }

    private void updateUsersBalance(User sender, User recipient, BigDecimal amount) {
        userRepository.updateBalance(sender, amount);
        userRepository.updateBalance(recipient, amount);
    }
}
