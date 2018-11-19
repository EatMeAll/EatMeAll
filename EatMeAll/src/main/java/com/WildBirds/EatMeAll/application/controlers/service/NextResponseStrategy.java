package com.WildBirds.EatMeAll.application.controlers.service;

import javax.ws.rs.core.Response;

public interface NextResponseStrategy {
    public StrategyCase when(String... params);
    public Response ultimately(StrategyMethod strategyMethod);
}
