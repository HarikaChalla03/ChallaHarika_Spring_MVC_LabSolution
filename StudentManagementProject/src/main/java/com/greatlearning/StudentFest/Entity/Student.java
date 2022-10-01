package com.greatlearning.StudentFest.Entity ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;

@Entity
@Table(name = "student")
   public class Student {
     //defining fields
	    @Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY )
	    @Column( name = "Student_Id" ) 
	     private int Student_Id ;
	    
	    @Column( name = "FirstName" )
	     private String FirstName;
	    
	    @Column( name = "LastName" )
		 private String LastName;
	    
	    @Column( name = "Department" )
		 private String Department;
	    
	    @Column( name = "Country" )
		 private String  Country;
	    
	    //define constructors
	    
        public Student() {
		super();
			
		}
        
        
        public Student(int student_Id, String firstName, String lastName, String department, String country) {
			super();
			Student_Id = student_Id;
			FirstName = firstName;
			LastName = lastName;
			Department = department;
			Country = country;
		}



		public int getStudent_Id() {
			return Student_Id;
		}

		public void setStudent_Id(int student_Id) {
			Student_Id = student_Id;
		}

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public String getDepartment() {
			return Department;
		}

		public void setDepartment(String department) {
			Department = department;
		}

		public String getCountry() {
			return Country;
		}

		public void setCountry(String country) {
			Country = country;
		}
        
		
		//define toString
		@Override
		public String toString() {
			return "Student [Student_Id=" + Student_Id + ", FirstName=" + FirstName + ", LastName=" + LastName
					+ ", Department=" + Department + ", Country=" + Country + "]";
		}
        
}

