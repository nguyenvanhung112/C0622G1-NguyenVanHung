package com.example.orderbook.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterThrowing(value = "execution(* com.example.orderbook.controller.BookController.*(..))")
    public void checkEx() {
        System.out.println("--------------------------------");
        System.out.println("Error");
    }

    @After(value = "execution(* com.example.orderbook.controller.BookController.*(..))")
    public void checkOk() {
        System.out.println("--------------------------------");
        System.out.println("Success");
    }
}
