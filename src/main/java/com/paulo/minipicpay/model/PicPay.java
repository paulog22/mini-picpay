package com.paulo.minipicpay.model;

public class PicPay {

    private final UserRepository userRepository;

    public PicPay(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void transfer(Cpf senderCpf, Cpf recipientCpf, Double amount) {
        User sender = userRepository.findBy(senderCpf);
        User recipient = userRepository.findBy(recipientCpf);
        sender.decreaseBalance(amount);
        recipient.increaseBalance(amount);
        updateUsersBalance(sender, recipient, amount);
    }

    private void updateUsersBalance(User sender, User recipient, Double amount) {
        userRepository.updateBalance(sender, amount, TransferType.SEND);
        userRepository.updateBalance(recipient, amount, TransferType.RECEIVE);
    }
}
