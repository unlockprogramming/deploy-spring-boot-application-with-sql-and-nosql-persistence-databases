package com.unlockprogramming.example;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, String> {
    
}
