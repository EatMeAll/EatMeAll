package com.wildBirds.SystemTestsBackEnd.app;

import com.wildBirds.SystemTestsBackEnd.tests.TestProduct;
import com.wildBirds.SystemTestsBackEnd.tests.TestRest;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service()
public class TestRunner {


    @PostConstruct
    public void main() {

        JUnitCore junit = new JUnitCore();
        junit.addListener(new FileSave());

        Result result = junit.run(
                TestRest.class,
                TestProduct.class);
        resultReport(result);
    }


    public static void resultReport(Result result) {
        System.out.println("Finished. Result: Failures: " +
                result.getFailureCount() + ". Ignored: " +
                result.getIgnoreCount() + ". Tests run: " +
                result.getRunCount() + ". Time: " +
                result.getRunTime() + "ms.");
    }
}
