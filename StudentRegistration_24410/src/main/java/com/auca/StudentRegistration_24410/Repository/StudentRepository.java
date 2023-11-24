package com.auca.StudentRegistration_24410.Repository;

import com.auca.StudentRegistration_24410.Model.Student_24410;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student_24410, String> {
}
