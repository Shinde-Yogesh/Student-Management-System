package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
