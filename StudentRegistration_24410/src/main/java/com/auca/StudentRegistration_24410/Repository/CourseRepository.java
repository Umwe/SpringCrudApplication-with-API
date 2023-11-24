package com.auca.StudentRegistration_24410.Repository;

import com.auca.StudentRegistration_24410.Model.AcademicUnit_24410;
import com.auca.StudentRegistration_24410.Model.CourseDefinition_24410;
import com.auca.StudentRegistration_24410.Model.Course_24410;
import com.auca.StudentRegistration_24410.Model.Semester_24410;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course_24410, Integer> {
    boolean existsByDepartmentAndSemester(AcademicUnit_24410 department, Semester_24410 semester24410);
    public boolean existsByCourseDefinition(CourseDefinition_24410 courseDefinition24410);
    List<Course_24410> findByDepartmentAndSemester(AcademicUnit_24410 department, Semester_24410 semester24410);

}
