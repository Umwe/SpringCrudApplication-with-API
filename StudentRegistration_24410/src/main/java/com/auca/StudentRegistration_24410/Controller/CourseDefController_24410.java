package com.auca.StudentRegistration_24410.Controller;

import com.auca.StudentRegistration_24410.Model.CourseDefinition_24410;
import com.auca.StudentRegistration_24410.Service.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/CourseDefinition_24410" , produces = (MediaType.APPLICATION_JSON_VALUE), consumes = (MediaType.APPLICATION_JSON_VALUE))
public class CourseDefController_24410 {
    private static final long serialVersionUID = 1L;
    @Autowired
    private CourseDefinitionService crsDefService;
    //creating
    @PostMapping(value = "/savecourseDef")
    public ResponseEntity<?> createDef(@RequestBody CourseDefinition_24410 crsDef){
        if(crsDef != null ){
            String message = crsDefService.saveDef(crsDef);
            if(message != null){
                return new ResponseEntity<>("Course_24410 Saved ", HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>("Course_24410 Not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else {
            return new ResponseEntity<>("An error occured",HttpStatus.BAD_GATEWAY);
        }
    }

    //list
    @GetMapping(value = "/listcoursedefinition")
    public ResponseEntity<List<CourseDefinition_24410>> listDefs() {
        List<CourseDefinition_24410> defs = crsDefService.listDefs();
        return new ResponseEntity<>(defs, HttpStatus.OK);
    }
    //update
    @PutMapping(value = "/updateDefinition/{code}")
    public ResponseEntity<String> updateDef(@PathVariable String code, @RequestBody CourseDefinition_24410 crsDef) {
        if (crsDef != null) {
            String message = crsDefService.updateDef(code,crsDef);
            if (message != null) {
                return new ResponseEntity<>("Course_24410 Definition Updated ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Course_24410 Not Updated ", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input or An error occured", HttpStatus.BAD_REQUEST);
        }
    }
    //delete
    @DeleteMapping(value = "/deletecoursedefinition/{code}")
    public ResponseEntity<String> deleteDef(@PathVariable String code) {
        if (code != null) {
            String message = crsDefService.deleteDef(code);
            if (message != null) {
                return new ResponseEntity<>("Course_24410 Deleted ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Course_24410 Not Deleted ", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Invalid input or an error occured", HttpStatus.BAD_REQUEST);
        }
    }
}
