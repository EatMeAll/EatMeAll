package com.wildBirds.SystemTestsBackEnd.domain;


import com.wildBirds.SystemTestsBackEnd.domain.model.full_.DayDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.security.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


public class QueryTesting {

    private RestTemplate restTemplate;

    public QueryTesting(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String host = "http://eatmeall.pl:100/app/schedule";

    public Long generateSchedule() {

        Instant timeBefore = Instant.now();
        ResponseEntity<DayDTO[]> restTemplateForEntity = restTemplate.getForEntity(host, DayDTO[].class);

        Instant timeAfter = Instant.now();

        long between = ChronoUnit.MILLIS.between(timeBefore, timeAfter);

        return between;
    }
}

