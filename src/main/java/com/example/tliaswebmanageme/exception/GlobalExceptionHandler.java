package com.example.tliaswebmanageme.exception;

import com.example.tliaswebmanageme.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handlerException(Exception e) {
        String err = e.toString();
        log.info("------------------------------------------");
        log.info(err);
        return Result.error(err);
    }
}
