package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCOach;
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach,
                          @Qualifier("tennisCoach") Coach theAnotherCoach
                            ){
        System.out.println("In constructor: "+getClass().getSimpleName());
        myCoach=theCoach;
        anotherCOach=theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, "+(myCoach==anotherCOach);
    }

}
