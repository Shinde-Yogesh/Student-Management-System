package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.Student;
import com.crud.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	// get the student list
	@GetMapping("/allStudents")
	public List<Student> getAllStudent() {
		return this.studentService.getAllStudent();
	}

	// Create the student Details
	@PostMapping("/createStudent")
	public Student createStudentDetails(@RequestBody Student student) {
		return this.studentService.createStudentDetails(student);
	}

	// for the update student details
	@PutMapping("/updateDetails/{id}")
	public Student updateDetails(@RequestBody Student student, @PathVariable("id") int id) {
		this.studentService.updateDetails(student, id);
		return student;
	}

	// Close the Admission

	@DeleteMapping("/close/{id}")
	public void closeAdmission(@PathVariable("id") int id) {
		this.studentService.closeAdmission(id);
	}

}
