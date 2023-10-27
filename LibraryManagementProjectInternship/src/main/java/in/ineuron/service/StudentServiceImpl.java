package in.ineuron.service;

import in.ineuron.dao.IStudentDAO;
import in.ineuron.daofactory.StudentDAOFactory;
import in.ineuron.dto.Student;

public class StudentServiceImpl implements IStudentService {
	
	IStudentDAO studentDao = null;

	@Override
	public String saveStudent(Student student) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		student.setDate(sqlDate);
		student.setRole("std");
		studentDao = StudentDAOFactory.getStudentDAO();
		if (studentDao != null) {
			return studentDao.saveStudent(student);
		}
		return "failure";
	}

	@Override
	public Student getStudent(int id) {
		studentDao = StudentDAOFactory.getStudentDAO();
		return studentDao.getStudent(id);
	}

	@Override
	public String updateStudent(Student student) {
		studentDao = StudentDAOFactory.getStudentDAO();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		student.setDate(sqlDate);
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(int id) {
		studentDao = StudentDAOFactory.getStudentDAO();
		return studentDao.deleteStudent(id);
	}

	@Override
	public String verifyStudent(int id, String password) {
		studentDao = StudentDAOFactory.getStudentDAO();
		return studentDao.verifyStudent(id, password);
	}

}
