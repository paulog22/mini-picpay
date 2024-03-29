package com.paulo.minipicpay.application;

import com.paulo.minipicpay.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public class UserService {

    private final UserFactory factory;
    private final UserRepository userRepository;
    private final PicPay picPay;

    public UserService(UserFactory factory, UserRepository userRepository, PicPay picPay) {
        this.factory = factory;
        this.userRepository = userRepository;
        this.picPay = picPay;
    }

    @Transactional
    public User create(CreateUserRequest request) {
        return factory.newUserWith(UserType.from(request.userType()), UserName.of(request.name()),
                Document.of(request.document()), UserEmail.of(request.email()), Password.of(request.password()));
    }

    @Transactional
    public void transfer(Document senderDocument, Document receiverDocument, BigDecimal amount) {
        User sender = userRepository.findBy(senderDocument);
        User recipient = userRepository.findBy(receiverDocument);
        picPay.transfer(sender, recipient, amount);
    }
}
