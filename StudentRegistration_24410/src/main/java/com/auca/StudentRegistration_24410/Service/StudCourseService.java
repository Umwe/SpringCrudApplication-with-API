package com.auca.StudentRegistration_24410.Service;

import com.auca.StudentRegistration_24410.Model.*;
import com.auca.StudentRegistration_24410.Repository.StudentCourseRepo;
import com.auca.StudentRegistration_24410.Repository.StudentRegistrationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudCourseService {
    private static final Logger logger = LoggerFactory.getLogger(StudCourseService.class);

    @Autowired
    private StudentCourseRepo studCrsRepo;
    @Autowired
    private StudentRegistrationRepo regRepo;
    public String saveStudCourse(StudentCourse_24410 studentCourse24410) {
        if (studentCourse24410 != null) {
            if (isCourseRegistered(studentCourse24410.getCourse())) {
                return "Course_24410 is already registered by a student.";
            } else {
                studCrsRepo.save(studentCourse24410);
                return "Course_24410 registered successfully.";
            }
        } else {
            return null;
        }
    }
    public boolean isCourseRegistered(Course_24410 course24410) {
        return studCrsRepo.existsByCourse(course24410);
    }
    public boolean isStudentExists(String studentId) {
        return regRepo.existsByStudentId(studentId);
    }
    public boolean isStudentCrsExists(Integer id) {
        return studCrsRepo.existsById(id);
    }

    public List<StudentCourse_24410> listStudentsCourse() {
        return studCrsRepo.findAll();
    }

    /*public String updateStudCourse(String studentId, Course_24410 course,StudentCourse_24410 studentCourse24410) {
        logger.info("Updating student with student ID: {} and Course_24410: {}", studentId,course);
        try {
            if (studentCourse24410 != null) {
                if (isStudentExists(studentId) && isCourseRegistered(course)) {
                    studCrsRepo.save(studentCourse24410);
                    logger.info("Student_24410 Course_24410 updated successfully");
                    return "Student_24410 Course_24410 updated successfully";
                } else {
                    return "Student_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to update student Course_24410", ex);
            return "Student_24410 Course_24410 not updated";
        }
    }*/
    public String updateStudCourse(Integer id, StudentCourse_24410 studentCourse24410) {
        logger.info("Updating student with student ID: {}", id);
        try {
            if (studentCourse24410 != null) {
                if (isStudentCrsExists(id)) {
                    studCrsRepo.save(studentCourse24410);
                    logger.info("Student_24410 Course_24410 updated successfully");
                    return "Student_24410 Course_24410 updated successfully";
                } else {
                    return "Student_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to update student Course_24410", ex);
            return "Student_24410 Course_24410 not updated";
        }
    }

    public String deleteStudCourse(Integer id) {
        logger.info("Deleting student course with id: {}", id);
        try {
            if (id != null) {
                if (isStudentCrsExists(id)) {
                    studCrsRepo.deleteById(id);
                    logger.info("Student_24410 Course_24410 deleted successfully");
                    return "Student_24410 Course_24410 deleted successfully";
                } else {
                    return "Student_24410 Course_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        } catch (Exception e) {
            logger.error("Failed to delete student Course_24410", e);
            return "Student_24410 Course_24410 not deleted";
        }
    }
    public List<StudentCourse_24410> getCoursesByStudent(String studentId) {
        StudentRegistration_24410 student = studentRegistrationRepo.findByStudentId(studentId);
        return studCrsRepo.findByStudentRegistration(student);
    }
    @Autowired
    private StudentRegistrationRepo studentRegistrationRepo;

    public List<StudentCourse_24410> getCoursesByStudentId(String studentId) {
        StudentRegistration_24410 student = regRepo.findByStudentId(studentId);
        return studCrsRepo.findByStudentRegistration(student);
    }
    public List<StudentCourse_24410> getStudentByCourseAndSemester(Course_24410 course24410, String semester) {
        List<StudentRegistration_24410> students = regRepo.findBySemesterId(semester);
        List<StudentCourse_24410> result = new ArrayList<>();
        for (StudentRegistration_24410 student : students) {
            List<StudentCourse_24410> coursesForStudent = studCrsRepo.findByCourseAndStudentRegistration(course24410, student);
            result.addAll(coursesForStudent);
        }
        return result;
    }


}
