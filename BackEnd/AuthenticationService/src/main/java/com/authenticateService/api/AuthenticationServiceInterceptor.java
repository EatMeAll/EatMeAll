package com.authenticateService.api;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import java.lang.reflect.Parameter;
import java.util.Enumeration;

public class AuthenticationServiceInterceptor {


    @AroundInvoke
    private Object aroundInvoke(InvocationContext ctx) throws Exception {

        System.out.println("--Param names");
        for (Parameter parameter : ctx.getMethod().getParameters()) {
            System.out.println("---");
            System.out.println(parameter.getName());
            System.out.println(parameter.getType().getSimpleName());
            System.out.println("---|");
        }

        System.out.println("Before interceptor");
        System.out.println("--Param:");
        for (Object parameter : ctx.getParameters()) {
            System.out.println(parameter);
        }
        System.out.println("--Context Data");
        ctx.getContextData().forEach((s, o) -> {
            System.out.println(s + " " + o);
        });
        for (Object parameter : ctx.getParameters()) {

            if (parameter instanceof HttpServletRequest) {

                HttpServletRequest request = (HttpServletRequest) parameter;

                System.out.println("Cookie: ");
                for (Cookie cookie : request.getCookies()) {
                    System.out.println(cookie);
                }

                Enumeration<String> headerNames = request.getHeaderNames();

                while (headerNames.hasMoreElements()) {
                    System.out.println(headerNames.nextElement().toString());
                }

            }
        }

        //Object result = ctx.proceed();
        System.out.println("After interceptor");
        return Response.status(Response.Status.OK).build();

    }
}
