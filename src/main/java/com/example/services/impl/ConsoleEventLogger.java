package com.example.services.impl;

import com.example.Event;
import com.example.services.EventLogger;
import org.springframework.stereotype.Service;

@Service
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
