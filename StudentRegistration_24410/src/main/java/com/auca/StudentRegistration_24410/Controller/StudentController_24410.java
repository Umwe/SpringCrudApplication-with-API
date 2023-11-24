package com.auca.StudentRegistration_24410.Controller;

import com.auca.StudentRegistration_24410.Model.AcademicUnit_24410;
import com.auca.StudentRegistration_24410.Model.Semester_24410;
import com.auca.StudentRegistration_24410.Model.Student_24410;
import com.auca.StudentRegistration_24410.Model.StudentRegistration_24410;
import com.auca.StudentRegistration_24410.Service.SemesterService;
import com.auca.StudentRegistration_24410.Service.StudentService;
import com.auca.StudentRegistration_24410.Service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/student" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))
public class StudentController_24410 {
    private static final long serialVersionUID = 1L;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private UnitService academicUnitService;
    //creating
    @PostMapping(value = "/saveStudent")
    public ResponseEntity<?> createStudent(@RequestBody Student_24410 student24410){
        if(student24410 != null ){
            String message = studentService.saveStudent(student24410);
            if(message != null){
                return new ResponseEntity<>("Student_24410 Saved ",HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("Student_24410 Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else {
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_GATEWAY);
        }
    }

    //list
    @GetMapping(value = "/listStudents")
    public ResponseEntity<List<Student_24410>> listStudents() {
        List<Student_24410> student24410s = studentService.listStudents();
        return new ResponseEntity<>(student24410s, HttpStatus.OK);
    }
    //update
    @PutMapping(value = "/updateStudent/{registrationNumber}")
    public ResponseEntity<String> updateStudent(@PathVariable String registrationNumber, @RequestBody Student_24410 student24410) {
        if (student24410 != null) {
            String message = studentService.updateStudent(registrationNumber, student24410);
            if (message != null) {
                return new ResponseEntity<>("Student_24410 Updated ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student_24410 Not Updated ", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    //delete
    @DeleteMapping(value = "/deleteStudent/{registrationNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable String registrationNumber) {
        if (registrationNumber != null) {
            String message = studentService.deleteStudent(registrationNumber);
            if (message != null) {
                return new ResponseEntity<>("Student_24410 Deleted ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student_24410 Not Deleted ", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }

    // List students by semester
    @GetMapping(value = "/listBySemester/{semesterId}")
    public ResponseEntity<List<StudentRegistration_24410>> listStudentsBySemester(@PathVariable String semesterId) {
        Semester_24410 semester24410 = semesterService.getSemesterById(semesterId);

        if (semester24410 != null) {
            List<StudentRegistration_24410> students = studentService.getStudentsBySemester(semester24410);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/listByDepartmentAndSemester/{departmentCode}/{semesterId}")
    public ResponseEntity<List<StudentRegistration_24410>> listStudentsByDepartmentAndSemester(
            @PathVariable String departmentCode,
            @PathVariable String semesterId) {

        AcademicUnit_24410 department = academicUnitService.getAcademicUnitByCode(departmentCode);
        Semester_24410 semester24410 = semesterService.getSemesterById(semesterId);

        if (department != null && semester24410 != null) {
            List<StudentRegistration_24410> students = studentService.getStudentsByDepartmentAndSemester(department, semester24410);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
