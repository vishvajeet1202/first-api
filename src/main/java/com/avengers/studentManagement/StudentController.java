package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
   StudentService studentService;
    //get information
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("admnNo") int admnNo){

        return studentService.getStudent(admnNo);
    }
    //adding the information
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }
    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id, @RequestParam("age") int age){

        return studentService.updateStudent(id,age);
    }
    @DeleteMapping("/delete_Student{id}")
    public String deleteStudent(@PathVariable("id") int admnNo){

            return studentService.deleteStudent(admnNo);
    }
}
