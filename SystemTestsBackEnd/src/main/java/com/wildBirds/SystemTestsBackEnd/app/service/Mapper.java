package com.wildBirds.SystemTestsBackEnd.app.service;

import com.wildBirds.SystemTestsBackEnd.app.dto.FailuresResponse;
import com.wildBirds.SystemTestsBackEnd.app.dto.ReportResponse;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {

    public ReportResponse toRaportResponse(Result result) {
        ReportResponse reportResponse = new ReportResponse();
        reportResponse.setResult(("Finished. Result: Failures: " +
                result.getFailureCount() + ". Ignored: " +
                result.getIgnoreCount() + ". Tests run: " +
                result.getRunCount() + ". Time: " +
                result.getRunTime() + "ms."));

        List<FailuresResponse> failuresResponseList = new ArrayList<>();

        for (int i = 0; i < result.getFailures().size(); i++) {
            Failure failure1 = result.getFailures().get(i);

            FailuresResponse failuresResponse = new FailuresResponse();
            failuresResponse.setId(i);
            failuresResponse.setMessages(failure1.getMessage());
            failuresResponse.setClassName(failure1.getDescription().getClassName());
            failuresResponse.setMethodName(failure1.getDescription().getMethodName());
            failuresResponseList.add(failuresResponse);
        }
        reportResponse.setFailuresResponseList(failuresResponseList);
        return reportResponse;
    }


}