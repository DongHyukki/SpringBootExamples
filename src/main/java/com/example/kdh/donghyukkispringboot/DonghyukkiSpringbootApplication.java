package com.example.kdh.donghyukkispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DonghyukkiSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonghyukkiSpringbootApplication.class, args);
    }

}
