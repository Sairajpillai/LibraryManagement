package in.ineuron.service;

import java.util.Calendar;
import java.util.List;

import in.ineuron.dao.IBookDAO;
import in.ineuron.daofactory.BookDAOFactory;
import in.ineuron.dto.Book;
import in.ineuron.dto.BookHistory;

public class BookServiceImpl implements IBookService {

	IBookDAO bookDao = null;

	@Override
	public String saveBook(Book book) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		book.setBookDate(sqlDate);
		book.setFkLibId(4);
		bookDao = BookDAOFactory.getBookDAO();
		if (bookDao != null) {
			return bookDao.saveBook(book);
		}
		return "failure";
	}

	@Override
	public Book getBook(int id) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.getBook(id);
	}

	@Override
	public String updateBook(Book book) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.updateBook(book);
	}

	@Override
	public String deleteBook(int id) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.deleteBook(id);
	}

	@Override
	public List<Book> searchBook(String bookname, String authorname, String category) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.searchBook(bookname, authorname, category);
	}

	@Override
	public Boolean checkBook(Integer bookid, Integer sid) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.checkBook(bookid, sid);
	}

	@Override
	public String issueBook(BookHistory bookhistory) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		bookhistory.setReqdate(sqlDate);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sqlDate);
		calendar.add(Calendar.DAY_OF_MONTH, 15);
		
		java.util.Date newUtilDate = calendar.getTime();
		java.sql.Date rDate = new java.sql.Date(newUtilDate.getTime());

		bookDao = BookDAOFactory.getBookDAO();
		bookhistory.setErdate(rDate);
		return bookDao.issueBook(bookhistory);
	}

	@Override
	public Boolean bookEligibility(int id) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.bookEligibility(id);
	}

	@Override
	public List<BookHistory> getPendingRequest(int id) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.pendingRequest(id);
	}

	@Override
	public List<BookHistory> getBookHistory(int id) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.bookHistory(id);
	}

}
