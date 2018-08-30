package com.example.services.impl;

import com.example.Event;
import com.example.services.EventLogger;
import org.springframework.stereotype.Service;

@Service
public class AnotherConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println("I'm another console event logger and I write this: ".concat(event.toString()));
    }
}
