/*
package com.example.springfluxcassandra.controller;

import com.example.springfluxcassandra.model.Student;
import com.example.springfluxcassandra.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/load")
    public void loadStudents(){
        List<Student> studentList=new ArrayList<>();
        Set<String> hobbies=new HashSet<>();
        hobbies.add("playing chess");
        Map<String,String> map=new HashMap<>();
        map.put("home","US");
        studentList.add(new Student(12345,"Mahesh", Arrays.asList("maheshp@gmail.com"),hobbies,map));
        studentList.add(new Student(12346,"Suresh", Arrays.asList("sureshk@gmail.com"),hobbies,map));
        studentList.add(new Student(12347,"Tanmay", Arrays.asList("tanmayp@gmail.com"),hobbies,map));
        studentList.add(new Student(12348,"Tejomay", Arrays.asList("tejomayp@gmail.com"),hobbies,map));
        studentRepository.saveAll(studentList);
    }

    @RequestMapping(value="/all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/id/{sid}")
    public Mono<Student> getStudent(@PathVariable int sid){
        return studentRepository.findById(sid);
    }

    @GetMapping("/after/{sid}")
    public Flux<Student> getStudents(@PathVariable int sid){
        return studentRepository.findStudentBySidAfter(sid);
    }

}
*/
