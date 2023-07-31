package student.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import student.demo.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
