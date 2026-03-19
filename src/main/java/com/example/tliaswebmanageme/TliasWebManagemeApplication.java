package com.example.tliaswebmanageme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TliasWebManagemeApplication {


    public static void main(String[] args) {
        SpringApplication.run(TliasWebManagemeApplication.class, args);
    }

}
