package com.paulo.minipicpay.context;


import com.paulo.minipicpay.infrastructure.config.JdbcContext;
import com.paulo.minipicpay.infrastructure.config.SpringContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IntegrationTestsContext {

    private IntegrationTestsContext() {
        // private constructor
    }

    public static ApplicationContext applicationContext() {
        return new AnnotationConfigApplicationContext(
                HsqlDbContext.class,
                SpringContext.class,
                IntegrationTestsContext.class
        );
    }
}
