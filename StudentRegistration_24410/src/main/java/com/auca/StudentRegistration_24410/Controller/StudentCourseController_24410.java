package com.auca.StudentRegistration_24410.Controller;

import com.auca.StudentRegistration_24410.Model.*;
import com.auca.StudentRegistration_24410.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/StudentCourse_24410" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))
public class StudentCourseController_24410 {
    private static final long serialVersionUID = 1L;
    @Autowired
    private StudCourseService studCrsService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private StudRegistrationService regService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseDefinitionService defService;
    //creating
    @PostMapping(value = "/saveStududentCourse")
    public ResponseEntity<?> createStudCrs(@RequestBody StudentCourse_24410 studCrs){
        if(studCrs != null ){
            String message = studCrsService.saveStudCourse(studCrs);
            if(message != null){
                return new ResponseEntity<>("Student_24410 Course_24410 Saved ", HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("Student_24410 Course_24410 Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else {
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
        }
    }

    //list
    @GetMapping(value = "/listStudentCourse")
    public ResponseEntity<List<StudentCourse_24410>> listStudCrs() {
        List<StudentCourse_24410> studCrs = studCrsService.listStudentsCourse();
        return new ResponseEntity<>(studCrs, HttpStatus.OK);
    }
    //update
    @PutMapping(value = "/updateStudentCourse/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody StudentCourse_24410 studCrs) {
        if (studCrs != null) {
            String message = studCrsService.updateStudCourse(id, studCrs);
            if (message != null) {
                return new ResponseEntity<>("Student_24410 Course_24410 Updated S", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student_24410 Course_24410 Not Updated ", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    /*@PutMapping(value = "/updateStudCourse/{studentId}/{course}")
    public ResponseEntity<String> updateStudent(@PathVariable String studentId, @PathVariable Course_24410 course, @RequestBody StudentCourse_24410 studCrs) {
        if (studCrs != null) {
            String message = studCrsService.updateStudCourse(studentId,course, studCrs);
            if (message != null) {
                return new ResponseEntity<>("Student_24410 Course_24410 Updated Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student_24410 Course_24410 Not Updated Successfully", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }*/
    //delete
    @DeleteMapping(value = "/deleteStudentCourse/{id}")
    public ResponseEntity<String> deleteStudCrs(@PathVariable Integer id) {
        if (id != null) {
            String message = studCrsService.deleteStudCourse(id);
            if (message != null) {
                return new ResponseEntity<>("Student_24410 Course_24410 Deleted ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student_24410 Course_24410 Not Deleted ", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/listByCourse/{studentId}")
    public ResponseEntity<List<StudentCourse_24410>> listByCourse(@PathVariable String studentId){
        StudentRegistration_24410 stud = regService.getRegistrationByStudentId(studentId);

        if (stud != null) {
            List<StudentCourse_24410> crs = studCrsService.getCoursesByStudentId(studentId);
            return new ResponseEntity<>(crs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/listByCourseAndSemester/{courseCode}/{semesterId}")
    public ResponseEntity<List<StudentCourse_24410>> listByCourseAndSemester(@PathVariable Integer courseCode, @PathVariable String semesterId) {
        Course_24410 course24410 = courseService.getCourseById(courseCode);

        if (course24410 != null) {
            List<StudentCourse_24410> crs = studCrsService.getStudentByCourseAndSemester(course24410, semesterId);
            return new ResponseEntity<>(crs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
