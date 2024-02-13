package com.example.tdd.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResData extends RuntimeException{

    private final ErrorCode errorCode;
}
