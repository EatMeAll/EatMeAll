package com.wildBirds.SystemTestsBackEnd.config;


import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRestTemplateConfig {

    @Bean
    TestRestTemplate testRestTemplate() {
        return new TestRestTemplate();
    }



}

