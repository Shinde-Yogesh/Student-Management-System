package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.crud.dao.StudentRepository;
import com.crud.entities.Student;
import com.crud.exceptions.ResourceNotFoundException;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student createStudentDetails(Student student) {
		Student StudentCreate = this.studentRepository.save(student);
		return StudentCreate;
	}

	public List<Student> getAllStudent() {
		List<Student> all_Student = this.studentRepository.findAll();
		return all_Student;
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
}
