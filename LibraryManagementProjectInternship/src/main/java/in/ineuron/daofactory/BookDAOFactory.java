package in.ineuron.daofactory;

import in.ineuron.dao.BookDAOImpl;
import in.ineuron.dao.IBookDAO;
import in.ineuron.dao.ILibrarianDAO;
import in.ineuron.dao.LibrarianDAOImpl;

public class BookDAOFactory {

	private BookDAOFactory() {
	}

	private static IBookDAO bookDao = null;

	public static IBookDAO getBookDAO() {
		if (bookDao == null) {
			bookDao = new BookDAOImpl();
		}
		return bookDao;

	}

}
