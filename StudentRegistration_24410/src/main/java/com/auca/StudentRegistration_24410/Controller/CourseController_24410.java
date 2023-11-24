package com.auca.StudentRegistration_24410.Controller;

import com.auca.StudentRegistration_24410.Model.*;
import com.auca.StudentRegistration_24410.Service.CourseService;
import com.auca.StudentRegistration_24410.Service.SemesterService;
import com.auca.StudentRegistration_24410.Service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/course" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))
public class CourseController_24410 {
    private static final long serialVersionUID = 1L;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private SemesterService semesterService;
    //creating
    @PostMapping(value = "/saveCourse")
    public ResponseEntity<?> createCourse(@RequestBody Course_24410 course24410){
        if(course24410 != null ){
            String message = courseService.saveCourse(course24410);
            if(message != null){
                return new ResponseEntity<>("Course_24410 Saved ", HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("Course_24410 Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else {
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
        }
    }

    //list
    @GetMapping(value = "/listCourse")
    public ResponseEntity<List<Course_24410>> listCourses() {
        List<Course_24410> cours = courseService.listCourses();
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }


    @PutMapping(value = "/updateCourse/{code}")
    public ResponseEntity<String> updateStudent(@PathVariable CourseDefinition_24410 code, @RequestBody Course_24410 course24410) {
        if (course24410 != null) {
            String message = courseService.updateCourse(code, course24410);
            if (message != null) {
                return new ResponseEntity<>("Course_24410 Updated ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Course_24410 Not Updated", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    //delete
    @DeleteMapping(value = "/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
        if (id != null) {
            String message = courseService.deleteCourse(id);
            if (message != null) {
                return new ResponseEntity<>("Course_24410 Deleted ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Course_24410 Not Deleted ", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/listByDepartmentAndSemester/{departmentCode}/{semesterId}")
    public ResponseEntity<List<Course_24410>> listStudentsByDepartmentAndSemester(
            @PathVariable String departmentCode,
            @PathVariable String semesterId) {

        AcademicUnit_24410 department = unitService.getAcademicUnitByCode(departmentCode);
        Semester_24410 semester24410 = semesterService.getSemesterById(semesterId);

        if (department != null && semester24410 != null) {
            List<Course_24410> crs = courseService.getCoursesByDepartmentAndSemester(department, semester24410);
            return new ResponseEntity<>(crs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
