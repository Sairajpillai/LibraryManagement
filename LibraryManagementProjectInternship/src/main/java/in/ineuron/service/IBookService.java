package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.BookHistory;

public interface IBookService {

public String saveBook(Book book);
	
	public Book getBook(int id);
	
	public String updateBook(Book book);
	
	public String deleteBook(int id);
	
	public List<Book> searchBook(String bookname,String authorname,String category);
	
	public Boolean checkBook(Integer bookid, Integer sid);
	
	public String issueBook(BookHistory bookhistory);
	
	
	public Boolean bookEligibility(int id);
	
	public List<BookHistory> getPendingRequest(int id);
	
	public List<BookHistory> getBookHistory(int id);

}
