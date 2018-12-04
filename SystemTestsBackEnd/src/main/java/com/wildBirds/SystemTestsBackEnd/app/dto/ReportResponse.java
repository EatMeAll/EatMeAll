package com.wildBirds.SystemTestsBackEnd.app.dto;

import com.wildBirds.SystemTestsBackEnd.app.dto.FailuresResponse;

import java.util.List;

public class ReportResponse {
    private String result;
    private List<FailuresResponse> failuresResponseList;

    public ReportResponse() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<FailuresResponse> getFailuresResponseList() {
        return failuresResponseList;
    }

    public void setFailuresResponseList(List<FailuresResponse> failuresResponseList) {
        this.failuresResponseList = failuresResponseList;
    }
}
