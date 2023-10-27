package in.ineuron.daofactory;

import in.ineuron.dao.BookDAOImpl;
import in.ineuron.dao.IBookDAO;
import in.ineuron.dao.ILibrarianDAO;
import in.ineuron.dao.IStudentDAO;
import in.ineuron.dao.LibrarianDAOImpl;
import in.ineuron.dao.StudentDAOImpl;

public class StudentDAOFactory {

	private StudentDAOFactory() {
	}

	private static IStudentDAO studentDao = null;

	public static IStudentDAO getStudentDAO() {
		if (studentDao == null) {
			studentDao = new StudentDAOImpl();
		}
		return studentDao;

	}

}
