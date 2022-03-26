package com.tesodev.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages = {"com.tesodev"})
@EnableJpaRepositories(basePackages = {"com.tesodev"})
@EntityScan(basePackages = {"com.tesodev"})
@ComponentScan(basePackages = {"com.tesodev"})
@EnableEurekaClient
public class CustomerMicroserviceApplication {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



    public static void main(String[] args) {
        SpringApplication.run(CustomerMicroserviceApplication.class, args);
    }

}
