package com.greatlearning.StudentFest.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.StudentFest.Entity.Student;

@Repository
public class StudentServiceImpl implements StudentService{
	    // create sessionFactory
        @SuppressWarnings("unused")
		private SessionFactory sessionFactory;
        // create session
		private Session session;

		
		@Autowired
		StudentServiceImpl(SessionFactory sessionfactory){
			this.sessionFactory = sessionfactory;
			try {
				session = sessionfactory.getCurrentSession();
			}
			catch(HibernateException e){
				session = sessionfactory.openSession();
			}
		}


	    @Transactional
		
		public List<Student> findAll() {
			
			Transaction tx = session.beginTransaction();
			
			// find all the records from the database table(students)
		    @SuppressWarnings("unchecked")
			List<Student> students = session.createQuery("from Student").list();
			
			tx.commit();

		    return students;
		}

	    
		@Transactional
		public Student findById(int id) {

			Student student = new Student();

            Transaction tx = session.beginTransaction();

			// find record with Id from the database table
			student = session.get(Student.class, id);

		    tx.commit();

			return student;
		}

		

		@Transactional
		public void save(Student theStudent) {

			
			Transaction tx = session.beginTransaction();

			// save transaction
			session.saveOrUpdate(theStudent);

			tx.commit();

		}

		@Transactional
		public void deleteById(int Student_Id) {

		   Transaction tx = session.beginTransaction();

			// get transaction
			Student student = session.get(Student.class, Student_Id );

			// delete record
			session.delete(student);

			tx.commit();

		}

		@Transactional
		public List<Student> searchBy(String FirstName, String LastName, String Department, String Country) {
         
			Transaction tx = session.beginTransaction();
			String query = "";
			if (FirstName.length() != 0 && Department.length() != 0)
				query = "from Student where FirstName like '%" + FirstName + "%' or Department like '%" + Department + "%'";
			else if (FirstName.length() != 0)
				query = "from Student where FirstName like '%" + FirstName + "%'";
		    else if (Department.length() != 0)
				query = "from Student where  Department like '%" + Department + "%'";
			else
				System.out.println("Cannot search without input data");
          
	
			List<Student> student = session.createQuery(query).list();

			tx.commit();

			return student;
		}

		// print the loop
		@Transactional
		public void print(List<Student> student) {

			for (Student s : student) {
				System.out.println(s);
			}
	}


		@Override
		public List<Student> searchBy(String FirstName, String Department) {
			// TODO Auto-generated method stub
			return null;
		}

		
}
	
	

