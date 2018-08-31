package com.example;

import com.example.services.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class App {
    @Autowired
    private Client client;
    @Autowired
    //@Qualifier("anotherConsoleEventLogger")
    private List<EventLogger> eventLoggers;
    @Autowired
    private Event event;

    public void logEvent(Event event) {
        for (EventLogger eventLogger : eventLoggers) {
            eventLogger.logEvent(event);
        }
    }
}
