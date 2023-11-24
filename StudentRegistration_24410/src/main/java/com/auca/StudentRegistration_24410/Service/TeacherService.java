package com.auca.StudentRegistration_24410.Service;

import com.auca.StudentRegistration_24410.Model.Teacher_24410;
import com.auca.StudentRegistration_24410.Repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    private TeacherRepository teacherRepository;
    public String saveTeacher(Teacher_24410 teacher24410){
        if (teacher24410 != null) {
            if (isTeacherExists(teacher24410.getTr_code())) {
                return "Teacher_24410 already exists";
            } else {
                teacherRepository.save(teacher24410);
                return "Teacher_24410 created successfully";
            }
        } else {
            return null;
        }
    }
    public boolean isTeacherExists(String tr_code) {
        return teacherRepository.existsById(tr_code);
    }

    public List<Teacher_24410> listTeacher() {
        return teacherRepository.findAll();
    }

    public String updateTeacher(String tr_code, Teacher_24410 teacher24410) {
        logger.info("Updating teacher24410 with code: {}", tr_code);
        try {
            if (teacher24410 != null) {
                if (isTeacherExists(tr_code)) {
                    teacherRepository.save(teacher24410);
                    logger.info("Teacher_24410 updated successfully");
                    return "Teacher_24410 updated successfully";
                } else {
                    return "Teacher_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to update Teacher_24410", ex);
            return "Teacher_24410 not updated successfully";
        }
    }

    public String deleteTeacher(String tr_code) {
        logger.info("Deleting Teacher_24410 with code: {}", tr_code);
        try {
            if (tr_code != null) {
                if (isTeacherExists(tr_code)) {
                    teacherRepository.deleteById(tr_code);
                    logger.info("Teacher_24410 deleted successfully");
                    return "Teacher_24410 deleted successfully";
                } else {
                    return "Teacher_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        } catch (Exception e) {
            logger.error("Failed to delete Teacher_24410", e);
            return "Teacher_24410 not deleted";
        }
    }
}
