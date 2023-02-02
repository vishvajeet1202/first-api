package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
   StudentService studentService;
    //get information
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("admnNo") int admnNo){
        Student response=studentService.getStudent(admnNo);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
    //adding the information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response=studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id, @RequestParam("age") int age){
        String response=studentService.updateStudent(id,age);
        if(response.equals("invalid id")){
            return new ResponseEntity<>(response,HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete_Student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int admnNo){
            String response=studentService.deleteStudent(admnNo);
            if(response.equals("invalid id")){
                return new ResponseEntity<>(response,HttpStatus.NOT_MODIFIED);
            }
            return  new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
