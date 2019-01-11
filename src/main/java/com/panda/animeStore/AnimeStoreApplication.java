package com.panda.animeStore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages="com.panda.animeStore.mapper")
@EnableTransactionManagement
public class AnimeStoreApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(AnimeStoreApplication.class, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();

        System.out.println("所以beanNames个数："+beanNames.length);

        for(String bn:beanNames) {

            System.out.println(bn);
        }
    }
}
