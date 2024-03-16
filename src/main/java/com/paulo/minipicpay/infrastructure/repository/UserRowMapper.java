package com.paulo.minipicpay.infrastructure.repository;

import com.paulo.minipicpay.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.Builder.aUser()
                .with(UserName.of(rs.getString("name")))
                .with(UserEmail.of(rs.getString("email")))
                .with(UserType.from(rs.getString("type")))
                .with(Password.of(rs.getString("password")))
                .with(Document.of(rs.getString("document")))
                .with(rs.getBigDecimal("balance"))
                .build();
    }
}
