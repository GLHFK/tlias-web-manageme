package com.example.tliaswebmanageme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {
    private Integer id;
    private String username;
    private String password;
    private String token;
}
