package com.example.demo.Services;

import com.example.demo.DTOs.StudentMobUpdateDto;
import com.example.demo.Enums.CardStatus;
import com.example.demo.Models.Card;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);

        student.setCard(card);

        studentRepository.save(student);

        return "New student and card added.";
    }


    public String getStudent (String email){
        return studentRepository.findByEmail(email).getName();
    }

    public String updateMobile(StudentMobUpdateDto studentMobUpdateDto){
        Student student = studentRepository.findById(studentMobUpdateDto.getId()).get();
        student.setMobile(studentMobUpdateDto.getMobile());
        studentRepository.save(student);

        return student.getName()+"'s mobile number updated successfully!!";
    }
}
