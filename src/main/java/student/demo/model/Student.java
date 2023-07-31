package student.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "student_table")
public class Student {
    @Id
    private  String id;
    private  String name;
    private LocalDate dob;
    private String branch;
    private Float gpa;

    public Student(String id, String name, LocalDate dob, String branch, Float gpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.branch = branch;
        if(gpa>=0 || gpa<=10) {
            this.gpa = gpa;
        }
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDOB() {
        return dob;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String b) {
        branch = b;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(Float marks) {
        if(marks>=0 || marks<=10) {
            gpa = marks;
        }
    }
}

