package com.auca.StudentRegistration_24410.Repository;

import com.auca.StudentRegistration_24410.Model.Teacher_24410;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher_24410, String> {
}
