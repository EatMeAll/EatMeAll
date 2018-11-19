package com.WildBirds.EatMeAll.application.controlers.service;

public class StrategyCase {

    private String[] params;
    private ResponseStrategy responseStrategy;
    private StrategyMethod method;

    public StrategyCase(String[] params, ResponseStrategy responseStrategy) {
        this.params = params;
        this.responseStrategy = responseStrategy;
    }

    public NextResponseStrategy execute(StrategyMethod method){
        this.method = method;
        return responseStrategy;
    }

    public String[] getParams() {
        return params;
    }

    public StrategyMethod getMethod() {
        return method;
    }
}
