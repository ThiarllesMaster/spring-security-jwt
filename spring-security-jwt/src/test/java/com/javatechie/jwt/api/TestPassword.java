package com.javatechie.jwt.api;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {

    @Test
    public void generatePassword() {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        System.out.println(enc.encode("Rafinha"));
    }
}
