package com.auca.StudentRegistration_24410.Service;

import com.auca.StudentRegistration_24410.Model.Semester_24410;
import com.auca.StudentRegistration_24410.Repository.SemesterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {
    private static final Logger logger = LoggerFactory.getLogger(SemesterService.class);

    @Autowired
    private SemesterRepository semRepo;
    public String saveSemester(Semester_24410 semester24410){
        if (semester24410 != null) {
            if (isSemesterExists(semester24410.getId())) {
                return "Semester_24410 already exists";
            } else {
                semRepo.save(semester24410);
                return "semester24410 created successfully";
            }
        } else {
            return null;
        }
    }
    public boolean isSemesterExists(String id) {
        return semRepo.existsById(id);
    }

    public List<Semester_24410> listSemesters() {
        return semRepo.findAll();
    }

    public String updateSemester(String id, Semester_24410 semester24410) {
        logger.info("Updating semester24410 with id: {}", id);
        try {
            if (semester24410 != null) {
                if (isSemesterExists(id)) {
                    semRepo.save(semester24410);
                    logger.info("Semester_24410 updated successfully");
                    return "Semester_24410 updated successfully";
                } else {
                    return "Semester_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to update Semester_24410", ex);
            return "Semester_24410 not updated";
        }
    }

    public String deleteSemester(String id) {
        logger.info("Deleting Semester_24410 with id: {}", id);
        try {
            if (id != null) {
                if (isSemesterExists(id)) {
                    semRepo.deleteById(id);
                    logger.info("Semester_24410 deleted successfully");
                    return "Semester_24410 deleted successfully";
                } else {
                    return "Semester_24410 not found";
                }
            } else {
                return "Invalid input";
            }
        } catch (Exception e) {
            logger.error("Failed to delete Semester_24410", e);
            return "Semester_24410 not deleted";
        }
    }
    public Semester_24410 getSemesterById(String id) {
        logger.info("Semester_24410 with id: {}", id);
        return semRepo.findById(id).orElse(null);
    }
}
