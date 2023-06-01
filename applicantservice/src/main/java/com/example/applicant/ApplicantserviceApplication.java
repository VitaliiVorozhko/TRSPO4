package com.example.applicant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.applicantservice.service"})

public class ApplicantserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicantserviceApplication.class, args);
    }

}
