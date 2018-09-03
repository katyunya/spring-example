package com.example;

import com.example.services.EventLogger;
import com.logger.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class App {
    @Autowired
    private Client client;
    @Autowired
    private List<EventLogger> eventLoggers;
    @Autowired
    private Event event;

    @Logged
    public void logEvent(Event event) {
        for (EventLogger eventLogger : eventLoggers) {
            eventLogger.logEvent(event);
        }
        System.out.println("This is client: ".concat(client.toString()));
    }

    @Logged
    public String method(String s) {
        return s.concat("abc");
    }
}
