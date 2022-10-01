package com.greatlearning.StudentFest.Controller ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller ;
import org.springframework.ui.Model ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;

import com.greatlearning.StudentFest.Entity.Student ;
import com.greatlearning.StudentFest.Service.StudentService ;

@Controller
@RequestMapping("/students")
public class StudentController {
	   
	   @Autowired
	   private StudentService studentService;
	   
	   // add mapping for "/list"
       @RequestMapping("/list")
	   public String listStudents(Model theModel) {
       
	   // get Students from database
       List<Student> theStudents = studentService.findAll();
       
       // add to the spring model
       theModel.addAttribute("ListofStudents", theStudents);
       return "list-students";
       }
	   
	   
      
       @RequestMapping("/showFormForAdd")
   	   public String showFormForAdd(Model theModel) {

   	   // create model attribute to bind form data
       Student theStudent = new Student();
       
       theModel.addAttribute("Student", theStudent);
    	   
       return "student-form";
       
       }
       
       
       @RequestMapping("/showFormForUpdate")
   	   public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

   	   // get the Student from the service
   	   Student theStudent = studentService.findById(theId);

   	   // set Student as a model attribute to pre-populate the form
   	   theModel.addAttribute("Student", theStudent);

   	   // send over to our form
   	   return "student-form";
   	     
       }
       
	   @PostMapping("/save")
	   public String saveStudent(@RequestParam("Student_Id") int Student_Id, 
			   @RequestParam("FirstName") String FirstName,
			   @RequestParam("LastName") String LastName,
	           @RequestParam("Department") String Department, 
	           @RequestParam("Country") String Country) 
	    {
        System.out.println(Student_Id);
		Student theStudents;
		if (Student_Id != 0) {
			theStudents = studentService.findById(Student_Id);
			theStudents.setFirstName(FirstName);
			theStudents.setLastName(LastName);
			theStudents.setDepartment(Department);
			theStudents.setCountry(Country);
		    } else
			theStudents = new Student(Student_Id, FirstName, LastName, Department, Country);
		    // save the Students
	        studentService.save(theStudents);

		    // use a redirect to prevent duplicate submissions
		    return "redirect:/students/list";
	     }
		
	   
	   
		@RequestMapping("/delete")
		public String delete(@RequestParam("studId") int theId) {

			// delete the Student
			studentService.deleteById(theId);

			// redirect to /Students/list
			return "redirect:/students/list";

		}
		
		

		@RequestMapping("/search")
		public String search(@RequestParam("Id") int Student_Id,
				             @RequestParam("FirstName") String FirstName,
				             @RequestParam("LastName") String LastName,
	                         @RequestParam("Department") String Department, 
	                         @RequestParam("Country") String Country, 
	                         Model theModel) {
            // check names, if both are empty then just give list of all Students

			if (FirstName.trim().isEmpty() && Department.trim().isEmpty()) {
				return "redirect:/students/list";
			} else {
				// else, search by first name and Department
				List<Student> thestudents = studentService.searchBy(FirstName, Department);

				// add to the spring model
				theModel.addAttribute("Students", thestudents);

				// send to list-students
				return "list-students";
			}

		}	

	}
 
