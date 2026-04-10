package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;


    @Override
    public void addAccount(Account theAccount, boolean VIP) {
        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public List<Account> findAccounts(boolean tripWare) {

        if (tripWare) {
            throw new RuntimeException("NO soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account account1 = new Account("Adam","Diamond");
        Account account2 = new Account("Julia","Gold");
        Account account3 = new Account("Milo","Bronze");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass().getSimpleName() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass().getSimpleName() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass().getSimpleName() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass().getSimpleName() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass().getSimpleName() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

}
