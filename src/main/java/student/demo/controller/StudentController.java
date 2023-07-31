package student.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.demo.model.Student;
import student.demo.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping(path = "/get-student-details")
    public List<Student> getStudentDetails() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/get-student-by-id/{id}")
    public Optional<Student> getStudentDetails(@PathVariable("id") String id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete-student-by-id/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") String id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/create-student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping(path = "/update-student-by-id/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") String id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }



}
