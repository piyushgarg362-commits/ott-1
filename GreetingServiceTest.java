package com.example.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingServiceTest {

    @Test
    void shouldReturnCorrectGreeting() {

        GreetingService service = new GreetingService();

        assertEquals(
                "Hello from Java Maven CI/CD!",
                service.getGreeting()
        );
    }

    @Test
    void shouldReturnCorrectApplicationName() {

        GreetingService service = new GreetingService();

        assertEquals(
                "Java Maven Demo Application",
                service.getApplicationName()
        );
    }
}
