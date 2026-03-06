package com.luv2code.springdemo.mvc;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotBlank(message = "Can't be blank")
    @NotNull(message = "is required")

    @Size(min = 1,message = "is required")
    private String lastName;

    @Min(value = 0, message = "must be grater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to ten")
    private int freePasses;

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
