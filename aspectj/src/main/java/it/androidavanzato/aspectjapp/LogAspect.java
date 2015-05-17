package it.androidavanzato.aspectjapp;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

    @Around("execution(String it.androidavanzato.aspectjapp.MainActivity.sayHello())")
    public String around(ProceedingJoinPoint pj) throws Throwable {
        Object proceed = pj.proceed();
        return proceed + "Hello, @Aspect";
    }

    @Before("within(android.app.Activity+) && execution(* onStart(..))")
    public void logMethod(JoinPoint joinPoint) {
        Log.d("callbacks", joinPoint.getSignature().getName());
    }
}