package com.example.crudSpringBootDemo.controller;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
        Student studentRes = studentService.getStudent(id);
        if (studentRes == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentRes);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();
        if (studentList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,
                                                 @RequestBody Student student) {
        Student studentResp = studentService.updateStudent(id, student);
        if (studentResp == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (!isDeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Record Deleted");
    }
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id) {
        Boolean isDeleted = studentService.deleteStudentSoftly(id);
        if (!isDeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Record Deleted");
    }
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudent(@RequestParam String name) {
        List<Student> students = studentService.searchStudent(name);
        if (students.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/filterByAge")
    public ResponseEntity<List<Student>> filterByAge(@RequestParam int age) {
        List<Student> students = studentService.filterByAge(age);
        if (students.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(students);
    }
}
