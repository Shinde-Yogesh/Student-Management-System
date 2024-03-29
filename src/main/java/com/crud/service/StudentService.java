package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.dao.StudentRepository;
import com.crud.entities.Student;
import com.crud.exceptions.ResourceNotFoundException;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public ResponseEntity<Student> createStudentDetails(Student student) {
		Student StudentCreate = this.studentRepository.save(student);
		return new ResponseEntity<>(StudentCreate, HttpStatus.CREATED);
	}

	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> all_Student = this.studentRepository.findAll();
		return new ResponseEntity<>(all_Student, HttpStatus.FOUND);
	}

	public Student updateDetails(Student student, int id) {
		student.setId(id);
		Student updatedStudentDetails = this.studentRepository.save(student);
		return updatedStudentDetails;
	}

	public void closeAdmission(int id) {
		try {
			studentRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id doesn't exist: " + id);
		}
	}
	public ResponseEntity<Student> getStudentById(int studentId) throws ResourceNotFoundException {
		Optional<Student> student = studentRepository.findById(studentId);
		if (student.isPresent()) {
			return ResponseEntity.ok(student.get());
		}
		throw new ResourceNotFoundException("User not found with Id : " + studentId);
	}
}
