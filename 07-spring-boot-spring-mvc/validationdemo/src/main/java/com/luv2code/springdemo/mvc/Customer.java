package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotBlank(message = "Can't be blank")
    @NotNull(message = "is required")

    @Size(min = 1,message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be grater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to ten")
    private Integer freePasses;

    @Pattern(regexp = "^[0-9a-zA-Z]{5}",message = "Only 5 chars/digits")
    private String postalCode;


    @CourseCode
    private String courseCode;
    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
