package com.example;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = {"com.example"})
public class Config {

    @Bean
    public Client client() {
        return new Client(1, "Ivan");
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Event event() {
        int id = new Random().nextInt(1000);
        return new Event(id, "Hello, I'm number ".concat(String.valueOf(id)), new Date());
    }
}
