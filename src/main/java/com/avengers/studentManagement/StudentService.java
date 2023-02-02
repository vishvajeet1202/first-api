package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }
    public String deleteStudent(int admnNo){
        return studentRepository.deleteStudent(admnNo);
    }
    public Student getStudent(int admnNo){
        return studentRepository.getStudent(admnNo);
    }
    public String updateStudent(int admnNo, int age){
        return studentRepository.updateStudent(admnNo,age);
    }
}
