package com.example.tdd.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.management.RuntimeErrorException;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATED_MEMBER_REGISTER(HttpStatus.BAD_REQUEST, "Duplicated Member Register Request");

    private HttpStatus status;
    private String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
