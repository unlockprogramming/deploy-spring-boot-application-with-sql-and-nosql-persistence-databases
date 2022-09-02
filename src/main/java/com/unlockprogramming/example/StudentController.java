package com.unlockprogramming.example;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    
    private final StudentRepository repository;

    @PostMapping
    public Student saveStudent(@RequestBody StudentRequest request) {
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName(request.getName());
        return repository.save(student);
    }

    @GetMapping
    public Page<Student> listStudents(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable);
    }

}
