package com.auca.StudentRegistration_24410.Controller;

import com.auca.StudentRegistration_24410.Model.AcademicUnit_24410;
import com.auca.StudentRegistration_24410.Model.Semester_24410;
import com.auca.StudentRegistration_24410.Model.StudentRegistration_24410;
import com.auca.StudentRegistration_24410.Service.StudRegistrationService;
import com.auca.StudentRegistration_24410.Service.SemesterService;
import com.auca.StudentRegistration_24410.Service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/studentRegistration" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))

public class StudRegController_24410 {
    private static final long serialVersionUID = 1L;
    @Autowired
    private StudRegistrationService regService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private SemesterService semesterService;
    //creating
    @PostMapping(value = "/saveRegistration")
    public ResponseEntity<?> createReg(@RequestBody StudentRegistration_24410 studentReg) {
        if (studentReg != null) {
            String message = regService.saveRegistration(studentReg);
            if (message != null && message.startsWith("Student_24410 Registered Successfully")) {
                return new ResponseEntity<>(message, HttpStatus.CREATED);
            } else if (message != null && message.startsWith("Student_24410 with ID")) {
                return new ResponseEntity<>(message, HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>("Student_24410 Not Registered", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_GATEWAY);
        }
    }

    //list
    @GetMapping(value = "/listRegistrations")
    public ResponseEntity<List<StudentRegistration_24410>> listRegs() {
        List<StudentRegistration_24410> studentReg = regService.listStudentsReg();
        return new ResponseEntity<>(studentReg, HttpStatus.OK);
    }
    //update
    @PutMapping(value = "/updateRegistration/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody StudentRegistration_24410 regStudent) {
        if (regStudent != null) {
            String message = regService.updateStudentReg(id, regStudent);
            if (message != null) {
                return new ResponseEntity<>("Student_24410 Registration Updated Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student_24410 Registration Not Updated Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    //delete
    @DeleteMapping(value = "/deleteRegistration/{id}")
    public ResponseEntity<String> deleteStudReg(@PathVariable Integer id) {
        if (id != null) {
            String message = regService.deleteStudentReg(id);
            if (message != null) {
                return new ResponseEntity<>("Student_24410 Registration Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student_24410 Registration Not Deleted Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/listByDepartmentAndSemester/{departmentCode}/{semesterId}")
    public ResponseEntity<List<StudentRegistration_24410>> listRegistrationsByDepartmentAndSemester(
            @PathVariable String departmentCode,
            @PathVariable String semesterId) {

        AcademicUnit_24410 department = unitService.getAcademicUnitByCode(departmentCode);
        Semester_24410 semester24410 = semesterService.getSemesterById(semesterId);

        if (department != null && semester24410 != null) {
            List<StudentRegistration_24410> registrations = regService.getRegistrationsByDepartmentAndSemester(department, semester24410);
            return new ResponseEntity<>(registrations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/listBySemester/{semesterId}")
    public ResponseEntity<List<StudentRegistration_24410>> listRegistrationsBySemester(

            @PathVariable String semesterId) {
        Semester_24410 semester24410 = semesterService.getSemesterById(semesterId);

        if (semester24410 != null) {
            List<StudentRegistration_24410> registrations = regService.getRegistrationsBySemester(semester24410);
            return new ResponseEntity<>(registrations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
