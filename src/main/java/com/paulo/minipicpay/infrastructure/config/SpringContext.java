package com.paulo.minipicpay.infrastructure.config;

import com.google.gson.Gson;
import com.paulo.minipicpay.application.UserService;
import com.paulo.minipicpay.infrastructure.repository.JdbcUserRepository;
import com.paulo.minipicpay.infrastructure.repository.UserRowMapper;
import com.paulo.minipicpay.infrastructure.validate.BalanceValidationHandler;
import com.paulo.minipicpay.infrastructure.validate.UserTypeValidationHandler;
import com.paulo.minipicpay.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringContext {

    private final JdbcTemplate jdbcTemplate;

    public SpringContext(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public UserRepository userRepository() {
        return new JdbcUserRepository(jdbcTemplate, userRowMapper());
    }

    @Bean
    public UserRowMapper userRowMapper() {
        return new UserRowMapper();
    }

    @Bean
    public PicPay picPay() {
        return new PicPay(userRepository(), transactionRepository(), userTypeValidationHandler());
    }

    @Bean
    public TransactionRepository transactionRepository() {
        return new TransactionRepository() {
            @Override
            public void insert(Transaction transaction) {

            }
        };
    }

    @Bean
    public ValidateTransferHandler userTypeValidationHandler() {
        return new UserTypeValidationHandler(balanceValidationHandler());
    }

    @Bean
    public ValidateTransferHandler balanceValidationHandler() {
        return new BalanceValidationHandler(null);
    }

    @Bean
    public UserFactory userFactory() {
        return new UserFactory(userRepository());
    }

    @Bean
    public Gson serializer() {
        return new Gson();
    }

    @Bean
    public UserService userService() {
        return new UserService(userFactory(), userRepository(), picPay());
    }
}
