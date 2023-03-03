package com.example.demo.Controllers;

import com.example.demo.DTOs.StudentMobUpdateDto;
import com.example.demo.Models.Student;
import com.example.demo.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServices studentServices;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return studentServices.addStudent(student);
    }

    @GetMapping("/getStudent")
    public String getStudent(@RequestParam("email") String email){
        return studentServices.getStudent(email);
    }

    @PutMapping("/updateMobile")
    public String updateMobile(@RequestBody StudentMobUpdateDto studentMobUpdateDto){
        return studentServices.updateMobile(studentMobUpdateDto);
    }
}
