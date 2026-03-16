package com.example.spring_day5.Controller;

import com.example.spring_day5.Entity.Student;
import com.example.spring_day5.Repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){

        Student saved = studentRepository.save(student);

        return ResponseEntity.status(201).body(saved);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id){

        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        studentRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Student> findByName(@RequestParam String name){
        return studentRepository.findStudentByName(name);
    }


    @GetMapping("/age")
    public List<Student> findByAge(@RequestParam int age){
        return studentRepository.findStudentsOlderThan(age);
    }
}
