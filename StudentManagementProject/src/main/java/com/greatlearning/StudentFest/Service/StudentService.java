package com.greatlearning.StudentFest.Service ;

import java.util.List ;

import com.greatlearning.StudentFest.Entity.Student;

public interface StudentService {
		
	  public List<Student> findAll() ;
		
		public Student findById(int theId) ;
		
		public void save(Student theStudent) ;
		
		public void deleteById(int theId) ;

		public List<Student> searchBy(String FirstName, String Department);
}