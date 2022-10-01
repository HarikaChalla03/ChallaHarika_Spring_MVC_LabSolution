<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

      <head>
           <!-- Required meta tags -->
           <meta charset="UTF-8">
           <title>Required Meta Tags</title>
           <meta charset="utf-8">
           <meta name="viewport"
	       content="width=device-width, initial-scale=1, shrink-to-fit=no">
	

           <!-- Bootstrap CSS -->
	
	       <link rel="stylesheet" 
	       href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css" 
	       integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" 
	       crossorigin="anonymous">
	 
           <title>Save Student</title>
        
        </head>


        <body>

           <div class="container">
	             <h3>Student Directory</h3>
		         <hr>
		         <p class="h4 mb-4">Student Details</p>
		
		
		         <form action="/StudentManagementProject/students/save" method="POST">
		
		         <!-- Add hidden form field to handle update -->
		         <input type="hidden" name="Student_Id" value="${Student.student_Id}"/>
		
		         <div class="form-inline">
		         <input type="text" name="FirstName" value="${Student.firstName}"
		         class="form-control mb-4 col-4" placeholder="FirstName">
		         </div>
		
		         <div class="form-inline">
                 <input type="text" name="LastName" value="${Student.lastName}"
		         class="form-control mb-4 col-4" placeholder="LastName">
                 </div>
        
                 <div class="form-inline">
                 <input type="text" name="Department" value="${Student.department}"
		         class="form-control mb-4 col-4" placeholder="Department">
                 </div>
        
                 <div class="form-inline">
                 <input type="text" name="Country" value="${Student.country}"
		         class="form-control mb-4 col-4" placeholder="Country">
                 </div>

                 <button type="submit" class="btn btn-info col-2">Save</button>
        
                 </form>

         <hr>
	     <a href="/StudentManagementProject/students/list">Back to Students List</a>
	
         </div>

      </body>
</html>