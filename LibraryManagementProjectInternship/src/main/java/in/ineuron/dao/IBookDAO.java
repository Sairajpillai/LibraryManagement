package in.ineuron.dao;

import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.BookHistory;

public interface IBookDAO {
	
	public String saveBook(Book book);
	
	public Book getBook(int id);
	
	public String updateBook(Book book);
	
	public String deleteBook(int id);
	
	
	
	public List<Book> searchBook(String bookname,String authorname,String category);
	
	public Boolean checkBook(Integer bookid, Integer sid);
	
	public String issueBook(BookHistory bookhistory);
	
	public Boolean bookEligibility(int id);
	
	public Boolean bookEligibility2(int id);
	
	public List<BookHistory> pendingRequest(int id);
	
	public List<BookHistory> bookHistory(int id);
	
	
	
	public List<BookHistory> getBookRequest();
	
	public Integer getBookQty(int id);
	
	public String approveBook(java.sql.Date idate,java.sql.Date erdate,int libid,int bhid);
	
	public String updateBookQty(int bookId);
	
	public List<BookHistory> getIssuedBookList(int id);
	
	public String updateBookQtyAccept(int bookid);
	
	public String acceptBook(int bhid,int amount,String amountStatus,java.sql.Date rdate);
	
}
