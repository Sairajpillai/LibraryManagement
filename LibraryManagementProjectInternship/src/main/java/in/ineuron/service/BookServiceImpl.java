package in.ineuron.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
	public Boolean bookEligibility2(int id) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.bookEligibility2(id);
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

	@Override
	public List<BookHistory> getBookRequest() {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.getBookRequest();
	}

	@Override
	public String getQty(int bhid, int libid) {
		bookDao = BookDAOFactory.getBookDAO();
		Integer qty = bookDao.getBookQty(bhid);
		System.out.println(qty+"quantity"+bhid);
		String status = null;
		if (qty > 0) {
			/*
			 * java.util.Date utilDate = new java.util.Date(); java.sql.Date sqlDate = new
			 * java.sql.Date(utilDate.getTime());
			 * 
			 * Calendar calendar = Calendar.getInstance(); calendar.setTime(sqlDate);
			 * calendar.add(Calendar.DAY_OF_MONTH, 15);
			 * 
			 * java.util.Date newUtilDate = calendar.getTime(); java.sql.Date rDate = new
			 * java.sql.Date(newUtilDate.getTime());
			 * 
			 * String update = bookDao.approveBook(sqlDate, rDate,libid, bhid);
			 * if(update.equalsIgnoreCase("success")) {
			 * 
			 * }
			 */

			status = "success";
		} else {
			status = "failure";
		}

		return status;
	}

	@Override
	public String approveBook(int bhid, int libid) {
		bookDao = BookDAOFactory.getBookDAO();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sqlDate);
		calendar.add(Calendar.DAY_OF_MONTH, 15);

		java.util.Date newUtilDate = calendar.getTime();
		java.sql.Date rDate = new java.sql.Date(newUtilDate.getTime());

		String updateStatus = bookDao.approveBook(sqlDate, rDate, libid, bhid);
		return updateStatus;
	}

	@Override
	public String updateBookQty(int bookId) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.updateBookQty(bookId);
	}

	@Override
	public List<BookHistory> getIssuedBookList(int id) {
		bookDao = BookDAOFactory.getBookDAO();
		List<BookHistory> issuedBookList = bookDao.getIssuedBookList(id);
		for (BookHistory bookHistory : issuedBookList) {
			Date erDate = bookHistory.getErdate();

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			// Convert SQL dates to LocalDate objects
			LocalDate localDate1 = erDate.toLocalDate();
			LocalDate localDate2 = sqlDate.toLocalDate();

			 //boolean isDateLessThanCurrent = localDate1.isBefore(localDate2);
			boolean isCurrentDateGreaterThanReturnDate = localDate2.isAfter(localDate1);
			System.out.println(isCurrentDateGreaterThanReturnDate+"in service");

			int fine = 0;
			String amountStatus = "-"; 

			if (isCurrentDateGreaterThanReturnDate) {
				// Calculate the difference in days
				int differenceInDays = (int) ChronoUnit.DAYS.between(localDate1, localDate2);
				System.out.println(differenceInDays+"in service");
				if (differenceInDays > 0) {
					fine = differenceInDays * 10;
					amountStatus = "Pending";
				}
			}
			bookHistory.setPenalty(fine);
			bookHistory.setAmountStatus(amountStatus);
		}
		// TODO Auto-generated method stub
		return issuedBookList;
	}

	@Override
	public String updateBookQtyAccept(int bookid) {
		bookDao = BookDAOFactory.getBookDAO();
		return bookDao.updateBookQtyAccept(bookid);
	}

	@Override
	public String acceptBook(int bhid, int amount, String amountStatus) {
		bookDao = BookDAOFactory.getBookDAO();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date rdate = new java.sql.Date(utilDate.getTime());
		if(amountStatus.equalsIgnoreCase("pending")) {
		amountStatus="paid";
		}
		return bookDao.acceptBook(bhid, amount, amountStatus, rdate);
	}

	

}
