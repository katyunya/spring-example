package com.example;

import com.example.services.EventLogger;
import com.example.services.impl.AnotherConsoleEventLogger;
import com.example.services.impl.ConsoleEventLogger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Configuration
@ImportResource({"classpath*:component-context.xml"})
@ComponentScan(basePackages = {"com.example"})
public class Config {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Event event() {
        int id = new Random().nextInt(1000);
        return new Event(id, "Hello, I'm number ".concat(String.valueOf(id)), new Date());
    }

    @Bean
    public List<EventLogger> eventLoggers(EventLogger consoleEventLogger, EventLogger anotherConsoleEventLogger) {
        List<EventLogger> eventLoggers = new ArrayList<>();
        eventLoggers.add(consoleEventLogger);
        eventLoggers.add(anotherConsoleEventLogger);
        return eventLoggers;
    }
}
