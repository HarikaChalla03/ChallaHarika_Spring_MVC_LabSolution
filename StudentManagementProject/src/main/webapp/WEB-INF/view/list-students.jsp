<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    <!-- Required meta tags -->
       <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
       <!-- Bootstrap CSS -->
       <link rel="stylesheet"
	    href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	    crossorigin="anonymous">
	
      <title>Students Directory</title>
     </head>
     
     <body>
     <div class="container">

		<h3>Students Directory</h3>
		<hr>
		
		<!-- Add a search form -->
		<form action="/StudentManagementProject/students/search" class="form-inline">
		
		<!-- Add a button -->
			<a href="/StudentManagementProject/students/showFormForAdd"
			class="btn btn-primary btn-sm mb-3"> Add Student </a> 
	    </form>
			
	  <table class="table table-bordered table-striped">
	        <thead class="thead-dark">
				 <tr>
					<th>Student_Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
			     </tr>
			</thead>
			
	         <tbody>
		        <c:forEach items="${ListofStudents}" var="tempStudent">
				   <tr>
				       <td><c:out value="${tempStudent.student_Id}" /></td>
				       <td><c:out value="${tempStudent.firstName}" /></td>
					   <td><c:out value="${tempStudent.lastName}" /></td>
					   <td><c:out value="${tempStudent.department}" /></td>
					   <td><c:out value="${tempStudent.country}" /></td>
					   <td>
					         <!-- Add "update" button/link --> 
						     <a href= "/StudentManagementProject/students/showFormForUpdate?studentId=${tempStudent.student_Id}" 
						     class="btn btn-info btn-sm"> Update </a>
						
						     <!-- Add "delete" button/link -->
						     <a href="/StudentManagementProject/students/delete?studId=${tempStudent.student_Id}"
						     class="btn btn-danger btn-sm" 
						     onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete </a>
                       </td>
                   </tr>
		         </c:forEach>
           </tbody>    
           
       </table>
       
       <a href = /StudentManagementProject/students/showFormForAdd>REGISTER NEW STUDENT</a>			
        
        </div>
    
     </body>
</html>
			
			


