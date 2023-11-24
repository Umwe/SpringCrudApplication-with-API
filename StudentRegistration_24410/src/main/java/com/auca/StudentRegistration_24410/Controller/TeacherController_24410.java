package com.auca.StudentRegistration_24410.Controller;

import com.auca.StudentRegistration_24410.Model.Teacher_24410;
import com.auca.StudentRegistration_24410.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/teacher" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))
public class TeacherController_24410 {
    private static final long serialVersionUID = 1L;
    @Autowired
    private TeacherService teacherService;
    //creating
    @PostMapping(value = "/saveTeacher")
    public ResponseEntity<?> createTeacher(@RequestBody Teacher_24410 teacher24410){
        if(teacher24410 != null ){
            String message = teacherService.saveTeacher(teacher24410);
            if(message != null){
                return new ResponseEntity<>("Teacher_24410 Saved Successfully", HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("Teacher_24410 Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else {
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
        }
    }

    //list
    @GetMapping(value = "/listTeachers")
    public ResponseEntity<List<Teacher_24410>> listTeachers() {
        List<Teacher_24410> teacher24410s = teacherService.listTeacher();
        return new ResponseEntity<>(teacher24410s, HttpStatus.OK);
    }
    //update
    @PutMapping(value = "/updateTeacher/{tr_code}")
    public ResponseEntity<String> updateTeacher(@PathVariable String tr_code, @RequestBody Teacher_24410 teacher24410) {
        if (teacher24410 != null) {
            String message = teacherService.updateTeacher(tr_code, teacher24410);
            if (message != null) {
                return new ResponseEntity<>("Teacher_24410 Updated Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Teacher_24410 Not Updated Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    //delete
    @DeleteMapping(value = "/deleteTeacher/{tr_code}")
    public ResponseEntity<String> deleteTeacher(@PathVariable String tr_code) {
        if (tr_code != null) {
            String message = teacherService.deleteTeacher(tr_code);
            if (message != null) {
                return new ResponseEntity<>("Teacher_24410 Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Teacher_24410 Not Deleted Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
}
