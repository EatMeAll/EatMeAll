package com.wildBirds.SystemTestsBackEnd.domain;

import com.wildBirds.SystemTestsBackEnd.tests.TestProduct;
import com.wildBirds.SystemTestsBackEnd.tests.TestRest;
import com.wildBirds.SystemTestsBackEnd.tests.TestSchedule;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.stereotype.Service;

@Service()
public class TestRunner {



    public Result run() {

        JUnitCore junit = new JUnitCore();
        junit.addListener(new FileSave());

        Result result = junit.run(
                TestRest.class,
                TestProduct.class,
                TestSchedule.class);
        resultReport(result);

        return result;
    }

    public static void resultReport(Result result) {
        System.out.println("Finished. Result: Failures: " +
                result.getFailureCount() + ". Ignored: " +
                result.getIgnoreCount() + ". Tests run: " +
                result.getRunCount() + ". Time: " +
                result.getRunTime() + "ms.");
    }
}
