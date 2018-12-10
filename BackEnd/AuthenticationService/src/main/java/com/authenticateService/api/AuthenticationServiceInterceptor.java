package com.authenticateService.api;

import com.authenticateService.appliacation.exceptions.InvalidMethodSignatureException;
import com.authenticateService.appliacation.exceptions.CookieTokenNotFoundException;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.lang.reflect.Parameter;
import java.util.Map;

public class AuthenticationServiceInterceptor {

    @EJB
    AuthenticationServiceFacade<Integer> authenticationServiceFacade;

    @AroundInvoke
    private Object aroundInvoke(InvocationContext ic) {

        try {
            validateMethodReturnType(ic);

            Cookie tokenFromCookie = getTokenFromCookie(ic);
            TokenDTO authTokenDTO = new TokenDTO(tokenFromCookie.getValue());
            Integer authorizeUserId = authenticationServiceFacade.authorize(authTokenDTO);
            injectUserIdToMethodParameter(authorizeUserId, ic);

            return ic.proceed();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).header("Error", e.getMessage()).build();
        }
    }

    private void validateMethodReturnType(InvocationContext ic)
            throws InvalidMethodSignatureException {
        if (ic.getMethod().getReturnType() != Response.class) {
            throw new InvalidMethodSignatureException("Method should return Object type javax.ws.rs.core.Response");
        }
    }

    private void injectUserIdToMethodParameter(Integer authorizeUserId, InvocationContext ic)
            throws InvalidMethodSignatureException {

        Integer parametersIndex = 0;
        Object[] parameters = ic.getParameters();
        for (Parameter parameter : ic.getMethod().getParameters()) {

            if (parameter.getName().equals("authUserId")) {
                if (parameter.getType() == Integer.class) {
                    parameters[parametersIndex] = authorizeUserId;
                    ic.setParameters(parameters);
                }
            }
            parametersIndex++;
        }
        throw new InvalidMethodSignatureException("Not found parameter Type java.lang.Integer with name authUserId  in method signature [Integer authUserId] - param is required");
    }

    private Cookie getTokenFromCookie(InvocationContext ic)
            throws CookieTokenNotFoundException, InvalidMethodSignatureException {

        for (Object parameter : ic.getParameters()) {

            if (parameter instanceof HttpHeaders) {
                HttpHeaders request = (HttpHeaders) parameter;
                Map<String, javax.ws.rs.core.Cookie> cookies = request.getCookies();
                if (cookies.containsKey("Token")) {
                    return cookies.get("Token");
                } else {
                    throw new CookieTokenNotFoundException("Cookie: Token - not found");
                }
            }
        }
        throw new InvalidMethodSignatureException("Not found parameter Type javax.ws.rs.core.HttpHeaders in method signature [HttpHeaders headers] - param is required");
    }
}
