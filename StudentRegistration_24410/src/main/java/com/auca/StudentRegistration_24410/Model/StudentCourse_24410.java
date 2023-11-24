package com.auca.StudentRegistration_24410.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class StudentCourse_24410 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int credits;
    private BigDecimal results;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentRegistration_24410 studentRegistration24410;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course_24410 course24410;

    public StudentCourse_24410() {
    }

    public StudentCourse_24410(int id, int credits, BigDecimal results, StudentRegistration_24410 studentRegistration24410, Course_24410 course24410) {
        this.id = id;
        this.credits = credits;
        this.results = results;
        this.studentRegistration24410 = studentRegistration24410;
        this.course24410 = course24410;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public BigDecimal getResults() {
        return results;
    }

    public void setResults(BigDecimal results) {
        this.results = results;
    }

    public StudentRegistration_24410 getStudentRegistration() {
        return studentRegistration24410;
    }

    public void setStudentRegistration(StudentRegistration_24410 studentRegistration24410) {
        this.studentRegistration24410 = studentRegistration24410;
    }

    public Course_24410 getCourse() {
        return course24410;
    }

    public void setCourse(Course_24410 course24410) {
        this.course24410 = course24410;
    }
}
