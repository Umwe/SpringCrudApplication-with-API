package com.auca.StudentRegistration_24410.Controller;

import com.auca.StudentRegistration_24410.Model.Semester_24410;
import com.auca.StudentRegistration_24410.Service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/semester" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))
public class SemesterController_24410 {
    private static final long serialVersionUID = 1L;
    @Autowired
    private SemesterService semService;
    //creating
    @PostMapping(value = "/saveSemester")
    public ResponseEntity<?> createSemester(@RequestBody Semester_24410 semester24410){
        if(semester24410 != null ){
            String message = semService.saveSemester(semester24410);
            if(message != null){
                return new ResponseEntity<>("Semester_24410 Saved ", HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("Semester_24410 Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else {
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
        }
    }

    //list
    @GetMapping(value = "/listSemesters")
    public ResponseEntity<List<Semester_24410>> listSemester() {
        List<Semester_24410> sems = semService.listSemesters();
        return new ResponseEntity<>(sems, HttpStatus.OK);
    }
    //update
    @PutMapping(value = "/updateSemester/{code}")
    public ResponseEntity<String> updateSemester(@PathVariable String code, @RequestBody Semester_24410 semester24410) {
        if (semester24410 != null) {
            String message = semService.updateSemester(code, semester24410);
            if (message != null) {
                return new ResponseEntity<>("Semester_24410 Updated Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Semester_24410 Not Updated Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    //delete
    @DeleteMapping(value = "/deleteSemester/{code}")
    public ResponseEntity<String> deleteSemester(@PathVariable String code) {
        if (code != null) {
            String message = semService.deleteSemester(code);
            if (message != null) {
                return new ResponseEntity<>("Semester_24410 Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Semester_24410 Not Deleted Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
}
