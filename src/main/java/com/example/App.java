package com.example;

import com.example.services.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class App {
    @Autowired
    private Client client;
    @Autowired
    @Qualifier("anotherConsoleEventLogger")
    private EventLogger eventLogger;
    @Autowired
    private Event event;

    public void logEvent(Event event) {
        eventLogger.logEvent(event);
    }
}
