package com.houli.pms.sync.utils;

public class JwtTokenNullOrDoNotContainsUserNameException extends RuntimeException {
    public JwtTokenNullOrDoNotContainsUserNameException() {
    }

    public JwtTokenNullOrDoNotContainsUserNameException(String message) {
        super(message);
    }
}
