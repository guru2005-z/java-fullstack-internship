package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);

        // Force port 9090 directly in code
        Properties props = new Properties();
        props.put("server.port", "9090");
        app.setDefaultProperties(props);

        System.out.println("\n==========================================");
        System.out.println("   Contact Form App - Starting Up ...");
        System.out.println("==========================================\n");

        app.run(args);

        System.out.println("\n==========================================");
        System.out.println("   Server started at http://localhost:9090");
        System.out.println("   Health check: http://localhost:9090/api/health");
        System.out.println("==========================================\n");
    }
}