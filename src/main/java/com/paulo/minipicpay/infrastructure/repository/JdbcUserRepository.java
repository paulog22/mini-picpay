package com.paulo.minipicpay.infrastructure.repository;

import com.paulo.minipicpay.model.Document;
import com.paulo.minipicpay.model.User;
import com.paulo.minipicpay.model.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class JdbcUserRepository implements UserRepository {

    private static final String INSERT_USER = "INSERT INTO users (type, name, email, document, password, " +
            "balance) values (?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_DOCUMENT = "SELECT * FROM users WHERE document = ? FOR UPDATE";
    private static final String UPDATE_BALANCE = "UPDATE users SET balance = ? WHERE document = ?";
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    @Override
    public void insert(User user) {
        jdbcTemplate.update(INSERT_USER, user.userType().name(), user.name().value(), user.email().value(),
                user.document().value(), user.password().value(), user.balance());
    }

    @Override
    public void updateBalance(User user, BigDecimal amount) {
        jdbcTemplate.update(UPDATE_BALANCE, amount, user.document().value());
    }

    @Override
    public User findBy(Document document) {
        return jdbcTemplate.queryForObject(FIND_BY_DOCUMENT, userRowMapper, document.value());
    }
}
