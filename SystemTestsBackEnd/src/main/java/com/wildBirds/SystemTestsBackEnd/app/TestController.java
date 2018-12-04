package com.wildBirds.SystemTestsBackEnd.app;

import com.wildBirds.SystemTestsBackEnd.app.dto.RaportResponse;
import com.wildBirds.SystemTestsBackEnd.app.service.Mapper;
import com.wildBirds.SystemTestsBackEnd.domain.TestRunner;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
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

//        System.out.println("ENDPOINT !!!!");
//
//        for (Failure failure : result.getFailures()) {
//            System.out.println(" 1 --" + failure.getDescription());
//            System.out.println(" 2 --" + failure.getException());
//            System.out.println(" 3 --" + failure.getMessage());
//            System.out.println(" 4 --" + failure.getTestHeader());
//            System.out.println(" 5 --" + failure.getTrace());
//        }

        RaportResponse raportResponse = mapper.toRaportResponse(result);


        return new ResponseEntity(raportResponse, HttpStatus.OK);

    }
}
