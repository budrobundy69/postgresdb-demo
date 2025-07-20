package com.example.postgresdbdemo;

import org.springframework.boot.SpringApplication;

public class TestPostgresdbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(PostgresdbDemoApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
