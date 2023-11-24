package com.auca.StudentRegistration_24410.Repository;

import com.auca.StudentRegistration_24410.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepo extends JpaRepository<StudentCourse_24410, Integer> {
    boolean existsByCourse(Course_24410 course24410);
    List<StudentCourse_24410> findByStudentRegistration(StudentRegistration_24410 studentRegistration24410);
    List<StudentCourse_24410> findByCourseAndStudentRegistration(Course_24410 course24410, StudentRegistration_24410 studentRegistration24410);
}
