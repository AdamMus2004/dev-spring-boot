package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune())")
    public Object aroundGetFortune(
            ProceedingJoinPoint theproceedingJoinPoint
    ) throws Throwable {
        String method = theproceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: "+method);

        long begin = System.currentTimeMillis();

        Object result = theproceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n=====> Duration: " + duration/1000.0+" seconds");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: "+method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: "+method);

        System.out.println("\n=====>>> The exception is: "+theExc);

    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n=====>>> Executing @AfterReturning on method: "+method);

        System.out.println("\n=====>>> result is: "+result);


        convertAccountNamesToUpperCase(result);


        System.out.println("\n=====>>> result is: "+result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account temp : result) {
            temp.setName(temp.getName().toUpperCase());
        }
    }


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
