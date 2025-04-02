package com.CLC_Portal.service;

import com.CLC_Portal.model.Student;
import com.CLC_Portal.repository.StudentRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Fetch all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Fetch a student by Email
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    // Register a new student
    public Student saveStudent(Student student) {
        if (studentRepository.existsById(student.getRollNumber())) {
            throw new RuntimeException("Student with this roll number already exists!");
        }
        return studentRepository.save(student);
    }

    // Update student details
    public Student updateStudent(Student studentDetails) {
        return studentRepository.findByEmail(studentDetails.getEmail()).map(student -> {
            student.setName(studentDetails.getName());
            student.setFatherName(studentDetails.getFatherName());
            student.setDob(studentDetails.getDob());
            student.setRank(studentDetails.getRank());
            student.setEmail(studentDetails.getEmail());
            student.setPhone(studentDetails.getPhone());
            student.setAddress(studentDetails.getAddress());
            student.setBranch(studentDetails.getBranch());
            student.setStatus(studentDetails.getStatus());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found!"));
    }
    
//    update status
    @Transactional
    public Student changeStatus(String email, String  status) {
        return studentRepository.findByEmail(email).map(student -> {
            student.setStatus(status);
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found!"));
    }


}
