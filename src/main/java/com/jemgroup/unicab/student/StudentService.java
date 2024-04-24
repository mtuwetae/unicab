package com.jemgroup.unicab.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(StudentDTO studentDTO){
        Student studentDetails = new Student();
        studentDetails.setName(studentDTO.getName());
        studentDetails.setUniversity(studentDTO.getUniversity());
        studentDetails.setSchoolId(studentDTO.getSchoolId());
        studentDetails.setTelephoneNumber(studentDTO.getTelephoneNumber());
        studentDetails.setEmail(studentDTO.getEmail());
        studentDetails.setImageUrl(studentDTO.getImageUrl());
        try {
            studentRepository.save(studentDetails);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return studentDetails;
    }
}
