package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
