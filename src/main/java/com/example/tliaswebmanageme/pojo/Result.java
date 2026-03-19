package com.example.tliaswebmanageme.pojo;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.message = "success";
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.code = 1;
        result.message = "success";
        result.data = data;
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.code = 2;
        result.message = message;
        return result;
    }
}
