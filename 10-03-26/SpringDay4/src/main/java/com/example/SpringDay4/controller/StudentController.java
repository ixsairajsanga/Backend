package com.example.SpringDay4.controller;


import com.example.SpringDay4.student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    List<student> studentsList=new ArrayList<>(List.of(
        new student(05,"krish",21),
        new student(50,"nikhil",21),
        new student(51,"sairaj",21),
        new student(14,"rishi",21)
    ));



    @GetMapping
    public ResponseEntity<List<student>> getstudents(){
         return ResponseEntity.status(HttpStatus.valueOf(201)).body(studentsList);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<student> getstudentBy(@PathVariable int id){

        for(student s:studentsList){
            if(s.getId()==id){
                return ResponseEntity.status(HttpStatus.OK).body(s);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/search")
    public  ResponseEntity<List<student>> searchStudents(@RequestParam String name){

        List<student> result = new ArrayList<>();

            for(student s : studentsList){
                if(s.getName().equalsIgnoreCase(name)){
                    result.add(s);
                }
            }
            if(result.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.status(HttpStatus.valueOf(201)).body(result);
    }


    @PostMapping
    public  ResponseEntity<student> addStudent(@RequestBody student stu){
        if(stu.getName() == null || stu.getName().isEmpty() || stu.getAge() <= 0){
            return ResponseEntity.badRequest().build();
        }
        studentsList.add(stu);

        return ResponseEntity.status(HttpStatus.valueOf(201)).body(stu);
    }


    @PutMapping("/{id}")
    public ResponseEntity<student> updateStudent(@PathVariable int id,
                                 @RequestBody student updatedStudent){

        for(student s : studentsList){

            if(s.getId() == id){
                s.setName(updatedStudent.getName());
                s.setAge(updatedStudent.getAge());
                return ResponseEntity.status(HttpStatus.OK).body(s);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){

        boolean removed = studentsList.removeIf(s -> s.getId() == id);

        if(removed){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    

}
