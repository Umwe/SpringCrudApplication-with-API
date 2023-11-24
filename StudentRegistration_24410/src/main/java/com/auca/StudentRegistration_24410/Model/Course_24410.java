package com.auca.StudentRegistration_24410.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course_24410 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "academic_unit_code")
    private AcademicUnit_24410 department;

    @OneToMany(mappedBy = "course")
    @JsonBackReference
    private List<StudentCourse_24410> studentCours24410s;

    @ManyToOne
    @JoinColumn(name = "course_definition_id")
    private CourseDefinition_24410 courseDefinition24410;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester_24410 semester24410;

    public Course_24410() {
    }

    public Course_24410(int id, AcademicUnit_24410 department, List<StudentCourse_24410> studentCours24410s, CourseDefinition_24410 courseDefinition24410, Semester_24410 semester24410) {
        this.id = id;
        this.department = department;
        this.studentCours24410s = studentCours24410s;
        this.courseDefinition24410 = courseDefinition24410;
        this.semester24410 = semester24410;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AcademicUnit_24410 getDepartment() {
        return department;
    }

    public void setDepartment(AcademicUnit_24410 department) {
        this.department = department;
    }

    public List<StudentCourse_24410> getStudentCourses() {
        return studentCours24410s;
    }

    public void setStudentCourses(List<StudentCourse_24410> studentCours24410s) {
        this.studentCours24410s = studentCours24410s;
    }

    public CourseDefinition_24410 getCourseDefinition() {
        return courseDefinition24410;
    }

    public void setCourseDefinition(CourseDefinition_24410 courseDefinition24410) {
        this.courseDefinition24410 = courseDefinition24410;
    }

    public Semester_24410 getSemester() {
        return semester24410;
    }

    public void setSemester(Semester_24410 semester24410) {
        this.semester24410 = semester24410;
    }
}
