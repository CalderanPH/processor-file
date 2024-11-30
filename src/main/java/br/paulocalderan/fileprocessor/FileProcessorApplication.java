package br.paulocalderan.fileprocessor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class FileProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileProcessorApplication.class, args);
    }

}
