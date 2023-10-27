package in.ineuron.daofactory;

import in.ineuron.dao.ILibrarianDAO;
import in.ineuron.dao.LibrarianDAOImpl;

public class LibrarianDAOFactory {

	private LibrarianDAOFactory() {
	}

	private static ILibrarianDAO librerianDao = null;

	public static ILibrarianDAO getLibrerianDAO() {
		if (librerianDao == null) {
			librerianDao = new LibrarianDAOImpl();
		}
		return librerianDao;

	}

}
