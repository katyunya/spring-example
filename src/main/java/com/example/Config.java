package com.example;

import com.example.services.EventLogger;
import com.example.services.impl.AnotherConsoleEventLogger;
import com.example.services.impl.ConsoleEventLogger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Bean
    public List<EventLogger> eventLoggers(EventLogger consoleEventLogger, EventLogger anotherConsoleEventLogger) {
        List<EventLogger> eventLoggers = new ArrayList<EventLogger>();
        eventLoggers.add(consoleEventLogger);
        eventLoggers.add(anotherConsoleEventLogger);
        return eventLoggers;
    }
}
