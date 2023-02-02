package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db=new HashMap<>();
    //get information

    public Student getStudent(int admnNo){

        return db.get(admnNo);
    }
    //adding the information

    public String addStudent(Student student){
        int admnNo= student.getAdmnNo();
        db.put(admnNo,student);
        return "Student added successfully";
    }

    public String updateStudent(int id, int age){
        if(!db.containsKey(id)){
            return "invalid id";
        }
        Student student=db.get(id);
        student.setAge(age);

        return "information updated successfully";
    }

    public String deleteStudent(int admnNo){
        if(db.containsKey(admnNo)){
            db.remove(admnNo);
            return "student removed";
        }
        else {
            return "invalid id";
        }
    }
}
