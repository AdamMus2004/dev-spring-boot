package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addAccount() {
        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN MEMBERSHIP");
        return true;
    }
}
