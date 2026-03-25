package com.example.SpringDay6.Service;

import com.example.SpringDay6.Entities.Student;
import com.example.SpringDay6.EntityDTO.StudentRequestDTO;
import com.example.SpringDay6.EntityDTO.StudentResponseDTO;
import com.example.SpringDay6.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }



    public Student mapToEntity(StudentRequestDTO studentRequestDTO){
          Student student=new Student();
          student.setName(studentRequestDTO.getName());
          student.setAge(studentRequestDTO.getAge());
          return student;
    }

    private StudentResponseDTO mapToDTO(Student student){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setAge(student.getAge());
        return studentResponseDTO;
    }


    // CREATE
    @Transactional
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {
        Student student = mapToEntity(dto);
        Student saved = studentRepository.save(student);
        if (true) {
            throw new RuntimeException("Force rollback");
        }
        return mapToDTO(saved);
    }

    // READ ALL
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // READ BY ID
    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapToDTO(student);
    }

    // UPDATE
    @Transactional
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setAge(dto.getAge());

        Student updated = studentRepository.save(student);

        return mapToDTO(updated);
    }

    // DELETE
    @Transactional
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }





}
