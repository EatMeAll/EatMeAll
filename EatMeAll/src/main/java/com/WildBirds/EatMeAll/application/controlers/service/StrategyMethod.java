package com.WildBirds.EatMeAll.application.controlers.service;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@FunctionalInterface
public interface StrategyMethod {

    public Response execute(MultivaluedMap<String, String> params);

}
