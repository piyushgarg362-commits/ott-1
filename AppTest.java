package com.example.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {

    @Test
    void applicationShouldBeCreated() {

        App app = new App();

        assertNotNull(app);
    }
}
