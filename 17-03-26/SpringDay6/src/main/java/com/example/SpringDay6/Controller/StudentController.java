package com.example.SpringDay6.Controller;

import com.example.SpringDay6.EntityDTO.StudentRequestDTO;
import com.example.SpringDay6.EntityDTO.StudentResponseDTO;
import com.example.SpringDay6.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

   private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    // CREATE
    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentRequestDTO dto) {
        return studentService.createStudent(dto);
    }

    // READ ALL
    @GetMapping
    public List<StudentResponseDTO> getAll() {
        return studentService.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public StudentResponseDTO getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public StudentResponseDTO update(
            @PathVariable Long id,
            @RequestBody StudentRequestDTO dto) {
        return studentService.updateStudent(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
}
