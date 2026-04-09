package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageWithoutGetterAndSetters()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n======>>>> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: "+methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object o : args) {
            System.out.println("Argument: "+o);
        }
    }



}
