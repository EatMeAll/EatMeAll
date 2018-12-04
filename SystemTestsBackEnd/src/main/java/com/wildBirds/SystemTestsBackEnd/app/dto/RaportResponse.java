package com.wildBirds.SystemTestsBackEnd.app.dto;

import com.wildBirds.SystemTestsBackEnd.app.dto.FailuresResponse;

import java.util.List;

public class RaportResponse {
    private String result;
    private List<FailuresResponse> failuresResponseList;

    public RaportResponse() {
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
