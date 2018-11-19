package com.WildBirds.EatMeAll.application.controlers.service;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ResponseStrategy implements NextResponseStrategy {


    private MultivaluedMap<String, String> queryParameters;
    private List<StrategyCase> strategyCaseList = new ArrayList<>();

    public ResponseStrategy form(UriInfo info){
        queryParameters = info.getQueryParameters();
        return this;
    }

    public StrategyCase when(String... params){
        StrategyCase strategyCase = new StrategyCase(params, this);
        strategyCaseList.add(strategyCase);
        return strategyCase;
    }

    public Response ultimately(StrategyMethod strategyMethod){


        Set<String> parametersNames = this.queryParameters.keySet();
        System.out.println(parametersNames+ " << Parms from web");

        for (StrategyCase strategyCase : strategyCaseList) {

            String[] params = strategyCase.getParams();
            System.out.println(params+ " << Case params");
            Boolean match = true;
            for (String param : params) {
                if (!parametersNames.contains(param)) {
                    match = false;
                    break;
                }
            }

            if (match) {
               return strategyCase.getMethod().execute(this.queryParameters);
            }


        }


        return strategyMethod.execute(this.queryParameters);
    }
}
