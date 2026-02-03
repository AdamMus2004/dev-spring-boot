package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff: "+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyPreDestroyStuff() {
        System.out.println("In doMyPreDestroyStuff: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practise forehand for 15 minutes and backhand for 10 minutes.";
    }
}
