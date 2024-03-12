package com.paulo.minipicpay.model;

public class UserFactory {

    private final UserRepository userRepository;

    public UserFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User newUserWith(UserType userType, UserName name, Document document, UserEmail email, Password password) {
        User user = buildWith(userType, name, document, email, password);
        userRepository.insert(user);
        return user;
    }

    private User buildWith(UserType userType, UserName name, Document document, UserEmail email, Password password) {
        return User.Builder.aUser()
                .with(userType)
                .with(name)
                .with(document)
                .with(email)
                .with(password)
                .build();
    }
}
