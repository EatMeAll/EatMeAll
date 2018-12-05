package com.authenticateService.api;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AuthenticationServiceInterceptor {

    @AroundInvoke
    private Object aroundInvoke(InvocationContext ctx) throws Exception {

        System.out.println("Before interceptor");
        System.out.println("Param:");
        for (Object parameter : ctx.getParameters()) {
            System.out.println(parameter);
        }
        System.out.println("Context Data");
        ctx.getContextData().forEach((s, o) -> {
            System.out.println(s+" "+o);
        });
        Object result = ctx.proceed();
        System.out.println("After interceptor");
        return result;
    }
}
