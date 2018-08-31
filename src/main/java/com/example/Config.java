package com.example;

import com.example.services.EventLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = {"com.example"})
@PropertySource("classpath:client.properties")
public class Config {

    @Value("${id}")
    private String id;

    @Value("${fullName}")
    private String fullName;

    @Bean
    public Client client() {
        return new Client(Integer.parseInt(id), fullName);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Event event() {
        int id = new Random().nextInt(1000);
        return new Event(id, "Hello, I'm number ".concat(String.valueOf(id)), new Date());
    }

    @Bean
    public List<EventLogger> eventLoggers(EventLogger consoleEventLogger, EventLogger anotherConsoleEventLogger) {
        List<EventLogger> eventLoggers = new ArrayList<EventLogger>();
        eventLoggers.add(consoleEventLogger);
        eventLoggers.add(anotherConsoleEventLogger);
        return eventLoggers;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
