package com.example.app;

public class App {

    public static void main(String[] args) {

        GreetingService greetingService = new GreetingService();

        System.out.println(
                greetingService.getGreeting()
        );

        System.out.println(
                "Application: " +
                greetingService.getApplicationName()
        );
    }
}
