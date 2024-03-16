package com.paulo.minipicpay.infrastructure.rest;

import com.google.gson.Gson;
import com.paulo.minipicpay.application.CreateUserRequest;
import com.paulo.minipicpay.application.UserService;
import com.paulo.minipicpay.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserApi extends BaseApi {

    private final UserService userService;

    protected UserApi(Gson serializer, UserService userService) {
        super(serializer);
        this.userService = userService;
    }

    @PostMapping
    private ResponseEntity<UserView> create(@RequestBody CreateUserRequest request) {
        User user = userService.create(request);
        return new ResponseEntity<>(new UserView(user), HttpStatus.CREATED);
    }
}
