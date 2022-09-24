package com.unlockprogramming.example;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

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
        student.setEmail(request.getEmail());
        student.setAddress(request.getAddress());
        student.setDateOfBirth(request.getDateOfBirth());
        return repository.save(student);
    }

    @GetMapping
    public Page<Student> listStudents(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping
    @RequestMapping("/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable String studentId) {
        Optional<Student> student = repository.findById(studentId);
        if (!student.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(student.get());
    }


    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody StudentRequest request, @PathVariable String studentId) {
        if (studentId == null && studentId.isEmpty())   {
            return ResponseEntity.notFound().build();
        }
        Student student = repository.findById(studentId).orElseThrow(EntityNotFoundException::new);

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAddress(request.getAddress());
        student.setDateOfBirth(request.getDateOfBirth());

        return ResponseEntity.ok().body(repository.save(student));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable String studentId) {
        if (studentId == null || studentId.isEmpty() || ( !repository.findById(studentId).isPresent()))   {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(studentId);
        return ResponseEntity.notFound().build();
    }

}
