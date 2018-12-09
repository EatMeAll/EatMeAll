package com.wildBirds.SystemTestsBackEnd.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TesterConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public QueryTesting queryTesting(){
        return new QueryTesting(restTemplate());
    }
}
