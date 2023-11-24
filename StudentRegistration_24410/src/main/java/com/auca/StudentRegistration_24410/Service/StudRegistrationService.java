package com.auca.StudentRegistration_24410.Service;

import com.auca.StudentRegistration_24410.Model.AcademicUnit_24410;
import com.auca.StudentRegistration_24410.Model.Semester_24410;
import com.auca.StudentRegistration_24410.Model.StudentRegistration_24410;
import com.auca.StudentRegistration_24410.Repository.StudentRegistrationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudRegistrationService {
    private static final Logger logger = LoggerFactory.getLogger(StudRegistrationService.class);

    @Autowired
    private StudentRegistrationRepo regRepo;
    public String saveRegistration(StudentRegistration_24410 studRegistration) {
        if (studRegistration != null) {
            if (regRepo.existsByStudentId(studRegistration.getStudentId())) {
                return "Student_24410 with ID " + studRegistration.getStudentId() + " is already registered.";
            } else {
                // Save the registration if not already present
                regRepo.save(studRegistration);
                return "Student_24410 Registration created successfully";
            }
        } else {
            return null;
        }
    }
    public boolean isRegistrationExists(AcademicUnit_24410 department, Semester_24410 semester24410) {
        return regRepo.existsByDepartmentAndSemester(department, semester24410);
    }
    public boolean isStudentRegExists(Integer id) {
        return regRepo.existsById(id);
    }
    public List<StudentRegistration_24410> listStudentsReg() {
        return regRepo.findAll();
    }

    public String updateStudentReg(Integer id, StudentRegistration_24410 studReg) {
        logger.info("Updating student registration with id: {}", id);
        try {
            if (studReg != null) {
                if (isStudentRegExists(id)) {
                    regRepo.save(studReg);
                    logger.info("Student_24410 Registration updated successfully");
                    return "Student_24410 Registration updated successfully";
                } else {
                    return "Student_24410 Registration not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to update student Registration", ex);
            return "Student_24410 Registration not updated";
        }
    }

    public String deleteStudentReg(Integer id) {
        logger.info("Deleting student with id: {}", id);
        try {
            if (id != null) {
                if (isStudentRegExists(id)) {
                    regRepo.deleteById(id);
                    logger.info("Student_24410 Registration deleted successfully");
                    return "Student_24410 Registration deleted successfully";
                } else {
                    return "Student_24410 Registration not found";
                }
            } else {
                return "Invalid input";
            }
        } catch (Exception e) {
            logger.error("Failed to delete student Registration", e);
            return "Student_24410 Registration not deleted successfully";
        }
    }
    public List<StudentRegistration_24410> getRegistrationsByDepartmentAndSemester(AcademicUnit_24410 department, Semester_24410 semester24410) {
        return regRepo.findByDepartmentAndSemester(department, semester24410);
    }
    public List<StudentRegistration_24410> getRegistrationsBySemester(Semester_24410 semester24410) {
        return regRepo.findBySemester(semester24410);
    }
    public StudentRegistration_24410 getRegistrationBySemesterId(String semesterId) {
        return regRepo.findByStudentId(semesterId);
    }
    public StudentRegistration_24410 getRegistrationByStudentId(String studentId) {
        return regRepo.findByStudentId(studentId);
    }
    public StudentRegistration_24410 getRegistrationById(Integer id) {
        return regRepo.findById(id).orElse(null);
    }
}
