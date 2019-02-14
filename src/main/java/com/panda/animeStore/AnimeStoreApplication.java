package com.panda.animeStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author panda
 */
@SpringBootApplication
@EnableTransactionManagement
public class AnimeStoreApplication {
    //todo druid配置监控
    public static void main(String[] args) {
        SpringApplication.run(AnimeStoreApplication.class, args);
    }
}

