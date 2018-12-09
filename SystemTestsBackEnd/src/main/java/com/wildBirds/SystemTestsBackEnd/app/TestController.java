package com.wildBirds.SystemTestsBackEnd.app;

import com.wildBirds.SystemTestsBackEnd.app.dto.ReportResponse;
import com.wildBirds.SystemTestsBackEnd.app.service.Mapper;
import com.wildBirds.SystemTestsBackEnd.domain.QueryTesting;
import com.wildBirds.SystemTestsBackEnd.domain.TestRunner;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestRunner testRunner;
    @Autowired
    private Mapper mapper;
    @Autowired
    private QueryTesting queryTesting;


    @GetMapping("/runTest")
    public ResponseEntity runner() {
        Result result = testRunner.run();

        ReportResponse reportResponse = mapper.toRaportResponse(result);


        return new ResponseEntity(reportResponse, HttpStatus.OK);

    }

    @GetMapping("/moveTest/{thread}")
    public ResponseEntity moveTester(@PathVariable Integer thread){

        for (int i = 0; i < thread; i++) {

            Thread thread2 = new Thread(() -> {
                Long time = queryTesting.generateSchedule();
                System.out.println(time);

            });
            thread2.start();
        }

        return new ResponseEntity(HttpStatus.OK);

    }
}
