package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {

            //demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);

            //demoTheAfterReturningAdvice(theAccountDAO);

            demoTheAfterThrowingAdvice(theAccountDAO);


		};
	}

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try {
            boolean tripWare = false;
            theAccounts=theAccountDAO.findAccounts(tripWare);
        } catch (Exception exc) {

            System.err.println("\n\n Main Program: .. caught exception: " +exc);
        }
        System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
        System.out.println("----");
        System.out.println(theAccounts);


    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println();
        System.out.println();

    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {
		Account account = new Account("Adam","21");
		theAccountDAO.addAccount(account,true);
		theAccountDAO.doWork();

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		theAccountDAO.setName("Adam");
		theAccountDAO.setServiceCode("2004");

		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();

	}

}
