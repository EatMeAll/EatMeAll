package com.wildBirds.SystemTestsBackEnd.app;

import com.wildBirds.SystemTestsBackEnd.app.dto.ReportResponse;
import com.wildBirds.SystemTestsBackEnd.app.service.Mapper;
import com.wildBirds.SystemTestsBackEnd.domain.TestRunner;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestRunner testRunner;

    @Autowired
    Mapper mapper;


    @GetMapping("runTest")
    public ResponseEntity runner() {
        Result result = testRunner.run();

        ReportResponse reportResponse = mapper.toRaportResponse(result);


        return new ResponseEntity(reportResponse, HttpStatus.OK);

    }
}
