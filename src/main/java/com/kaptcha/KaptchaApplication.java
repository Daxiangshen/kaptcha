package com.kaptcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class KaptchaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaptchaApplication.class, args);
    }

}
