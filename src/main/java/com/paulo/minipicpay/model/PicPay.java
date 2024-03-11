package com.paulo.minipicpay.model;

public class PicPay {

    private final UserRepository userRepository;
    private final ValidateTransferHandler validateHandler;

    public PicPay(UserRepository userRepository, ValidateTransferHandler validateHandler) {
        this.userRepository = userRepository;
        this.validateHandler = validateHandler;
    }

    public void transfer(Cpf senderCpf, Cpf recipientCpf, Double amount) {
        User sender = userRepository.findBy(senderCpf);
        User recipient = userRepository.findBy(recipientCpf);
        validateHandler.validate(sender, amount);
        sender.decreaseBalance(amount);
        recipient.increaseBalance(amount);
        updateUsersBalance(sender, recipient, amount);
    }

    private void updateUsersBalance(User sender, User recipient, Double amount) {
        userRepository.updateBalance(sender, amount);
        userRepository.updateBalance(recipient, amount);
    }
}
