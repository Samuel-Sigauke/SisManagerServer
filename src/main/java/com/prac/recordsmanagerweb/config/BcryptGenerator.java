package com.prac.recordsmanagerweb.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BcryptGenerator {

    Logger logger = LoggerFactory.getLogger(BcryptGenerator.class);

    public String generate(String password) {

        String hashedPassword = "";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        int i = 0;
        while (i < 5) {
            hashedPassword = passwordEncoder.encode(password);
            i++;
        }
        return "{bcrypt}"+hashedPassword;
    }
}
