package com.auca.StudentRegistration_24410.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "student")
public class Student_24410 {
    @Id
    @Column(name = "registration_number")
    private String registrationNumber;
    private String firstName;
    private String dateOfBirth;

    @OneToMany(mappedBy = "student")
    @JsonBackReference
    private List<StudentRegistration_24410> registrations;

    public Student_24410() {
    }

    public Student_24410(String registrationNumber, String firstName, String dateOfBirth, List<StudentRegistration_24410> registrations) {
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.registrations = registrations;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<StudentRegistration_24410> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<StudentRegistration_24410> registrations) {
        this.registrations = registrations;
    }
}