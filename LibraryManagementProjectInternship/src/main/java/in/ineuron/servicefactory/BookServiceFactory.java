package in.ineuron.servicefactory;

import in.ineuron.service.BookServiceImpl;
import in.ineuron.service.IBookService;

public class BookServiceFactory {
	
	private BookServiceFactory() {
	}
	
	private static IBookService bookService = null;
	
	public static IBookService getLibrarianService() {
		if(bookService==null) {
			bookService= new BookServiceImpl();
		}
		return bookService;
	}

}
