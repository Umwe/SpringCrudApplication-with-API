package com.auca.StudentRegistration_24410.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class StudentRegistration_24410 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_id")
    private String studentId;
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "academic_unit_id")
    private AcademicUnit_24410 department;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester_24410 semester24410;

    @OneToMany(mappedBy = "studentRegistration")
    @JsonBackReference
    private List<StudentCourse_24410> courses;

    @ManyToOne
    @JoinColumn(name = "registration_number")
    private Student_24410 student24410;

    public StudentRegistration_24410() {
    }

    public StudentRegistration_24410(int id, String studentId, LocalDate registrationDate, AcademicUnit_24410 department, Semester_24410 semester24410, List<StudentCourse_24410> courses, Student_24410 student24410) {
        this.id = id;
        this.studentId = studentId;
        this.registrationDate = registrationDate;
        this.department = department;
        this.semester24410 = semester24410;
        this.courses = courses;
        this.student24410 = student24410;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public AcademicUnit_24410 getDepartment() {
        return department;
    }

    public void setDepartment(AcademicUnit_24410 department) {
        this.department = department;
    }

    public Semester_24410 getSemester() {
        return semester24410;
    }

    public void setSemester(Semester_24410 semester24410) {
        this.semester24410 = semester24410;
    }

    public List<StudentCourse_24410> getCourses() {
        return courses;
    }

    public void setCourses(List<StudentCourse_24410> courses) {
        this.courses = courses;
    }

    public Student_24410 getStudent() {
        return student24410;
    }

    public void setStudent(Student_24410 student24410) {
        this.student24410 = student24410;
    }
}
