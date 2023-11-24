package com.auca.StudentRegistration_24410.Service;

import com.auca.StudentRegistration_24410.Model.AcademicUnit_24410;
import com.auca.StudentRegistration_24410.Model.Semester_24410;
import com.auca.StudentRegistration_24410.Model.Student_24410;
import com.auca.StudentRegistration_24410.Model.StudentRegistration_24410;
import com.auca.StudentRegistration_24410.Repository.StudentRegistrationRepo;
import com.auca.StudentRegistration_24410.Repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studRepo;
    @Autowired
    private StudentRegistrationRepo regRepo;

    public String saveStudent(Student_24410 student24410){
        if (student24410 != null) {
            // Check if a student24410 with the same registration number already exists
            if (isStudentExists(student24410.getRegistrationNumber())) {
                return "Student_24410 with the same registration number already exists";
            } else {
                studRepo.save(student24410);
                return "Student_24410 created successfully";
            }
        } else {
            return null;
        }
    }
    public boolean isStudentExists(String registrationNumber) {
        return studRepo.existsById(registrationNumber);
    }

    public List<Student_24410> listStudents() {
        return studRepo.findAll();
    }

    public String updateStudent(String registrationNumber, Student_24410 student24410) {
        logger.info("Updating student24410 with registration number: {}", registrationNumber);
        try {
            if (student24410 != null) {
                if (isStudentExists(registrationNumber)) {
                    // Update the student24410 information here
                    studRepo.save(student24410);
                    logger.info("Student_24410 updated successfully");
                    return "Student_24410 updated successfully";
                } else {
                    return "Student_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to update student24410", ex);
            return "Student_24410 not updated successfully";
        }
    }

    public String deleteStudent(String registrationNumber) {
        logger.info("Deleting student with registration number: {}", registrationNumber);
        try {
            if (registrationNumber != null) {
                if (isStudentExists(registrationNumber)) {
                    studRepo.deleteById(registrationNumber);
                    logger.info("Student_24410 deleted successfully");
                    return "Student_24410 deleted successfully";
                } else {
                    return "Student_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        } catch (Exception e) {
            logger.error("Failed to delete student", e);
            return "Student_24410 not deleted successfully";
        }
    }
    public List<StudentRegistration_24410> getStudentsBySemester(Semester_24410 semester24410) {
        logger.info("Student_24410 in Semester_24410: {}", semester24410);
        return regRepo.findBySemester(semester24410);
    }
    public List<StudentRegistration_24410> getStudentsByDepartmentAndSemester(AcademicUnit_24410 department, Semester_24410 semester24410) {
        return regRepo.findByDepartmentAndSemester(department, semester24410);
    }
}
