package com.example.fileServerExperiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FileServerExperimentApplication {

    public static void main( String[] args ) {
        SpringApplication.run(FileServerExperimentApplication.class, args);
    }

}
