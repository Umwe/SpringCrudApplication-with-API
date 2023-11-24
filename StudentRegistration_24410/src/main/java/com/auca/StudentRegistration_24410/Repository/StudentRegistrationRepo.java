package com.auca.StudentRegistration_24410.Repository;

import com.auca.StudentRegistration_24410.Model.AcademicUnit_24410;
import com.auca.StudentRegistration_24410.Model.Semester_24410;
import com.auca.StudentRegistration_24410.Model.StudentRegistration_24410;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRegistrationRepo extends JpaRepository<StudentRegistration_24410,Integer> {
    boolean existsByDepartmentAndSemester(AcademicUnit_24410 department, Semester_24410 semester24410);
    boolean existsByStudentId(String studentId);
    StudentRegistration_24410 findByStudentId(String studentId);

    List<StudentRegistration_24410> findBySemester(Semester_24410 semester24410);
    List<StudentRegistration_24410> findByDepartmentAndSemester(AcademicUnit_24410 department, Semester_24410 semester24410);
    List<StudentRegistration_24410> findBySemesterId(String semesterId);

}
