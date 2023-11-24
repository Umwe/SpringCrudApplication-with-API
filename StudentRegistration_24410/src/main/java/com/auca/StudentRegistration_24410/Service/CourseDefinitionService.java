package com.auca.StudentRegistration_24410.Service;

import com.auca.StudentRegistration_24410.Model.CourseDefinition_24410;
import com.auca.StudentRegistration_24410.Repository.CourseDefinitionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseDefinitionService {
    private static final Logger logger = LoggerFactory.getLogger(CourseDefinitionService.class);

    @Autowired
    private CourseDefinitionRepo defRepo;
    public String saveDef(CourseDefinition_24410 courseDefinition24410){
        if (courseDefinition24410 != null) {
            if (isDefExists(courseDefinition24410.getCode())) {
                return "Course_24410 already exists";
            } else {
                defRepo.save(courseDefinition24410);
                return "Course_24410 created successfully";
            }
        } else {
            return null;
        }
    }
    public boolean isDefExists(String code) {
        return defRepo.existsById(code);
    }

    public List<CourseDefinition_24410> listDefs() {
        return defRepo.findAll();
    }

    public String updateDef(String code, CourseDefinition_24410 courseDefinition24410) {
        logger.info("Updating Course_24410 with code: {}", code);
        try {
            if (courseDefinition24410 != null) {
                if (isDefExists(code)) {
                    defRepo.save(courseDefinition24410);
                    logger.info("Course_24410 updated successfully");
                    return "Course_24410 updated successfully";
                } else {
                    return "Course_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to update Course_24410", ex);
            return "Course_24410 not updated";
        }
    }

    public String deleteDef(String code) {
        logger.info("Deleting course with code: {}", code);
        try {
            if (code != null) {
                if (isDefExists(code)) {
                    defRepo.deleteById(code);
                    logger.info("Course_24410 deleted successfully");
                    return "Course_24410 deleted successfully";
                } else {
                    return "Course_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        } catch (Exception e) {
            logger.error("Failed to delete course", e);
            return "Course_24410 not deleted";
        }
    }
}
