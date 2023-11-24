package com.auca.StudentRegistration_24410.Repository;

import com.auca.StudentRegistration_24410.Model.CourseDefinition_24410;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDefinitionRepo extends JpaRepository<CourseDefinition_24410,String> {
}
