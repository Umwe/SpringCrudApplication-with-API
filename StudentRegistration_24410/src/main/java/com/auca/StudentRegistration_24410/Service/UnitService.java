package com.auca.StudentRegistration_24410.Service;

import com.auca.StudentRegistration_24410.Model.AcademicUnit_24410;
import com.auca.StudentRegistration_24410.Repository.UnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    private static final Logger logger = LoggerFactory.getLogger(UnitService.class);

    @Autowired
    private UnitRepository unitRepository;
    public String saveUnit(AcademicUnit_24410 acadUnit){
        if (acadUnit != null) {
            if (isAcadExists(acadUnit.getCode())) {
                return "Unit already exists";
            } else {
                unitRepository.save(acadUnit);
                return "Unit created successfully";
            }
        } else {
            return null;
        }
    }
    public boolean isAcadExists(String code) {
        return unitRepository.existsById(code);
    }

    public List<AcademicUnit_24410> listUnits() {
        return unitRepository.findAll();
    }

    public String updateUnit(String code, AcademicUnit_24410 acadUnit) {
        logger.info("Updating Unit with code: {}", code);
        try {
            if (acadUnit != null) {
                if (isAcadExists(code)) {
                    unitRepository.save(acadUnit);
                    logger.info("Unit updated successfully");
                    return "Unit updated successfully";
                } else {
                    return "Unit not found";
                }
            } else {
                return "Invalid input";
            }
        }catch (Exception ex){
            logger.error("Failed to update Unit", ex);
            return "Unit not updated";
        }
    }

    public String deleteUnit(String code) {
        logger.info("Deleting unit with code: {}", code);
        try {
            if (code != null) {
                if (isAcadExists(code)) {
                    unitRepository.deleteById(code);
                    logger.info("Unit deleted successfully");
                    return "Unit deleted successfully";
                } else {
                    return "Unit not found";
                }
            } else {
                return "Invalid input";
            }
        } catch (Exception e) {
            logger.error("Failed to delete Unit", e);
            return "Unit not deleted";
        }
    }
    public AcademicUnit_24410 getAcademicUnitByCode(String code) {
        return unitRepository.findById(code).orElse(null);
    }
}
