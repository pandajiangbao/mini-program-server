package com.panda.animeStore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AnimeStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeStoreApplication.class, args);
    }
}

