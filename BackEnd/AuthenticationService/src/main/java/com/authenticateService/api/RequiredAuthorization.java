package com.authenticateService.api;

import javax.interceptor.Interceptors;
import java.lang.annotation.*;

@Inherited
@Interceptors(AuthenticationServiceInterceptor.class)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredAuthorization{
}


