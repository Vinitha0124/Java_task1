package student.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import student.demo.model.Student;
import student.demo.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public ResponseEntity<Student> updateStudent(String id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student currentStudent = optionalStudent.get();
            currentStudent.setBranch(updatedStudent.getBranch());
            currentStudent.setGpa(updatedStudent.getGpa());
            Student updatedStudentEntity = studentRepository.save(currentStudent);
            return ResponseEntity.ok(updatedStudentEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


