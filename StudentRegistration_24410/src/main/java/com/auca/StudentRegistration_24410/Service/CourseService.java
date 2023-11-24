package com.auca.StudentRegistration_24410.Service;

import com.auca.StudentRegistration_24410.Model.AcademicUnit_24410;
import com.auca.StudentRegistration_24410.Model.CourseDefinition_24410;
import com.auca.StudentRegistration_24410.Model.Course_24410;
import com.auca.StudentRegistration_24410.Model.Semester_24410;
import com.auca.StudentRegistration_24410.Repository.CourseDefinitionRepo;
import com.auca.StudentRegistration_24410.Repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    private CourseRepository crsRepo;
    @Autowired
    private CourseDefinitionRepo crsDefRepo;
    public String saveCourse(Course_24410 course24410) {
        if (course24410 != null) {
            if (isCourseExists(course24410.getDepartment(), course24410.getSemester())) {
                return "Course_24410 already exists in the department and semester.";
            } else {
                crsRepo.save(course24410);
                return "Course_24410 created successfully.";
            }
        } else {
            return null;
        }
    }

    public boolean isCourseExists(AcademicUnit_24410 department, Semester_24410 semester24410) {
        return crsRepo.existsByDepartmentAndSemester(department, semester24410);
    }
    public boolean isCourseIdExists(Integer id) {
        return crsRepo.existsById(id);
    }
    public List<Course_24410> listCourses() {
        return crsRepo.findAll();
    }
    public Course_24410 getCourseById(Integer id) {
        logger.info("Course_24410 with id: {}", id);
        return crsRepo.findById(id).orElse(null);
    }

    public String updateCourse(CourseDefinition_24410 crsDef, Course_24410 course24410) {
        logger.info("Updating Course_24410 with Code: {}", crsDef);
        try {
            if (course24410 != null) {
                if (isCourseDefinitionExists(crsDef)) {
                    crsRepo.save(course24410);
                    logger.info("Course_24410 updated successfully");
                    return "Course_24410 updated successfully";
                } else {
                    return "Course_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to Course_24410 student", ex);
            return "Course_24410 not updated";
        }
    }
    /*public String updateCourse(Integer id, Course_24410 course) {
        logger.info("Updating Course_24410 with Id: {}", id);
        try {
            if (course != null) {
                if (isCourseIdExists(id)) {
                    crsRepo.save(course);
                    logger.info("Course_24410 updated successfully");
                    return "Course_24410 updated successfully";
                } else {
                    return "Course_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to Course_24410 student", ex);
            return "Course_24410 not updated";
        }
    }*/

    public boolean isCourseDefinitionExists(CourseDefinition_24410 courseDefinition24410) {
        return crsRepo.existsByCourseDefinition(courseDefinition24410);
    }

    public String deleteCourse(Integer id) {
        logger.info("Deleting Course_24410 with id: {}", id);
        try {
            if (id != null) {
                if (isCourseIdExists(id)) {
                    crsRepo.deleteById(id);
                    logger.info("Course_24410 deleted successfully");
                    return "Course_24410 deleted successfully";
                } else {
                    return "Course_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        } catch (Exception e) {
            logger.error("Failed to delete Course_24410", e);
            return "Course_24410 was not deleted successfully";
        }
    }
    public List<Course_24410> getCoursesByDepartmentAndSemester(AcademicUnit_24410 department, Semester_24410 semester24410) {
        return crsRepo.findByDepartmentAndSemester(department, semester24410);
    }
}
