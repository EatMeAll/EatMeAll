package com.wildBirds.SystemTestsBackEnd.domain;

import com.wildBirds.SystemTestsBackEnd.tests.ProductTest;
import com.wildBirds.SystemTestsBackEnd.tests.ScheduleTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.stereotype.Service;

@Service()
public class TestRunner {



    public Result run() {

        JUnitCore junit = new JUnitCore();
        junit.addListener(new FileSave());

        Result result = junit.run(
                ProductTest.class,
                ScheduleTest.class);
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
