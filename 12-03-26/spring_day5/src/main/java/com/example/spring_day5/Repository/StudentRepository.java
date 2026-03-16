package com.example.spring_day5.Repository;

import com.example.spring_day5.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     public List<Student> findStudentByName(String name);

     @Query("SELECT s FROM Student s WHERE s.age > :age")
     List<Student> findStudentsOlderThan(int age);
}
