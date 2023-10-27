package in.ineuron.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.daofactory.LibrarianDAOFactory;
import in.ineuron.dto.Book;
import in.ineuron.dto.BookHistory;
import in.ineuron.service.IBookService;
import in.ineuron.service.ILibrarianService;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.BookServiceFactory;
import in.ineuron.servicefactory.LibrarianServiceFactory;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet("/studentwork/*")
public class StudentWork extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		System.out.println(request);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		IStudentService service = StudentServiceFactory.getStudentService();
		IBookService bookService = BookServiceFactory.getLibrarianService();
		System.out.println(request.getRequestURI());

		if (request.getRequestURI().endsWith("stdlogin")) {
			String id = request.getParameter("loginid");
			String password = request.getParameter("password");
			String role = service.verifyStudent(Integer.parseInt(id), password);
			session.setAttribute("role", role);
			session.setAttribute("id", id);
			RequestDispatcher rd = null;
			request.setAttribute("role", role);
			System.out.println(role);
			rd = request.getRequestDispatcher("../JSP/StudentWork/StudentHomePage.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("searchbook")) {
			String loginResult = "success";
			String role = (String) session.getAttribute("role");
			String id = (String) session.getAttribute("id");
			String message = null;
			Boolean eligibility = null;
			String result="success";
			List<Book> booksList = new ArrayList<Book>();
			if (role == null || !role.equalsIgnoreCase("std")) {
				loginResult = "failure";
			} else {
				eligibility = bookService.bookEligibility(Integer.parseInt(id));
				if (eligibility==false) {
					result="failure";
				} else {
					String bookname = request.getParameter("bookname");
					String bookcategory = request.getParameter("authorname");
					String category = request.getParameter("category");

					booksList = bookService.searchBook(bookname, bookcategory, category);

					if (booksList != null) {
						for (Book book : booksList) {
							System.out.println(book);
						}
					}
					System.out.println(message);
				}
			}

			RequestDispatcher rd = null;
			request.setAttribute("booksList", booksList);
			request.setAttribute("loginResult", loginResult);
			request.setAttribute("result", result);
			// rd = request.getRequestDispatcher("../BookSaveResult.jsp");
			rd = request.getRequestDispatcher("../JSP/StudentWork/BookFindResult.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("requestbook")) {
			String role = (String) session.getAttribute("role");
			String id = (String) session.getAttribute("id");
			String loginResult = "success";
			String issueBook = null;
			String res = "failure";
			BookHistory bookhistory = new BookHistory();

			Boolean result = null;
			if (role == null || !role.equalsIgnoreCase("std")) {
				loginResult = "failure";
			} else {
				String bookid = request.getParameter("bookid");
				String bookname = request.getParameter("bookname");
				String bookcategory = request.getParameter("category");
				String author = request.getParameter("author");
				System.out.println(" " + bookid + " " + bookname + " " + bookcategory + " " + author);
				result = bookService.checkBook(Integer.parseInt(bookid), Integer.parseInt(id));
				if (result) {
					res="failure";
				} else {
					res="success";
					bookhistory.setBookid_fk(Integer.parseInt(bookid));
					bookhistory.setSid_fk(Integer.parseInt(id));
					issueBook = bookService.issueBook(bookhistory);
					System.out.println(issueBook);
				}

			}
			RequestDispatcher rd = null;
			request.setAttribute("res", res);
			request.setAttribute("loginResult", loginResult);
			request.setAttribute("issueBook", issueBook);
			rd = request.getRequestDispatcher("../../JSP/StudentWork/IssueBook.jsp");
			rd.forward(request, response);

		}
		
		if (request.getRequestURI().endsWith("pendingrequest")) {
			String role = (String) session.getAttribute("role");
			String id = (String) session.getAttribute("id");
			String loginResult = "success";
			List<BookHistory> pendingRequest = null;
			if (role == null || !role.equalsIgnoreCase("std")) {
				loginResult = "failure";
			} else {
				pendingRequest = bookService.getPendingRequest(Integer.parseInt(id));
				if(pendingRequest!=null) {
					for (BookHistory bookHistory : pendingRequest) {
						System.out.println(bookHistory);
					}
				}
				
			}
			RequestDispatcher rd = null;
			request.setAttribute("pendingRequest", pendingRequest);
			request.setAttribute("loginResult", loginResult);
			rd = request.getRequestDispatcher("../JSP/StudentWork/PendingRequest.jsp");
			rd.forward(request, response);
			
			
		}
		
		if (request.getRequestURI().endsWith("bookhistory")) {
			String role = (String) session.getAttribute("role");
			String id = (String) session.getAttribute("id");
			String loginResult = "success";
			List<BookHistory> bookHistoryList = null;
			if (role == null || !role.equalsIgnoreCase("std")) {
				loginResult = "failure";
			} else {
				bookHistoryList = bookService.getBookHistory(Integer.parseInt(id));
				if(bookHistoryList!=null) {
					for (BookHistory bookHistory : bookHistoryList) {
						System.out.println(bookHistory);
					}
				}
				
			}
			RequestDispatcher rd = null;
			request.setAttribute("bookHistoryList", bookHistoryList);
			request.setAttribute("loginResult", loginResult);
			rd = request.getRequestDispatcher("../JSP/StudentWork/BookHistory.jsp");
			rd.forward(request, response);
			
			
		}

		/*
		 * if (request.getRequestURI().endsWith("EditBook")) { String role = (String)
		 * session.getAttribute("role"); String loginResult = "success"; Book book =
		 * null; if (role == null || !role.equalsIgnoreCase("lib")) { loginResult =
		 * "failure"; } else { String id = request.getParameter("id"); //book =
		 * service.getBook(Integer.parseInt(id)); } RequestDispatcher rd = null;
		 * request.setAttribute("book", book); request.setAttribute("loginResult",
		 * loginResult); rd =
		 * request.getRequestDispatcher("../JSP/Book/UpdateBook.jsp");
		 * rd.forward(request, response);
		 * 
		 * }
		 * 
		 * if (request.getRequestURI().endsWith("UpdateBook")) { String bookid =
		 * request.getParameter("bookid"); String bookname =
		 * request.getParameter("bookname"); String bookcategory =
		 * request.getParameter("bookcategory"); Integer bookqty =
		 * Integer.parseInt(request.getParameter("bookqty"));
		 * 
		 * Book book = new Book(); book.setBookId(Integer.parseInt(bookid));
		 * book.setBookName(bookname); book.setBookCategory(bookcategory);
		 * book.setBookQty(bookqty); System.out.println(book); //String message =
		 * service.updateBook(book);
		 * 
		 * RequestDispatcher rd = null; //request.setAttribute("message", message); rd =
		 * request.getRequestDispatcher("../../JSP/Book/BookUpdateResult.jsp");
		 * rd.forward(request, response); }
		 * 
		 * if (request.getRequestURI().endsWith("DeleteForm")) { String role = (String)
		 * session.getAttribute("role"); String loginResult = "success"; String message
		 * = null; if (role == null || !role.equalsIgnoreCase("lib")) { loginResult =
		 * "failure"; } else { String bookid = request.getParameter("bookid");
		 * System.out.println(bookid); //message =
		 * service.deleteBook(Integer.parseInt(bookid)); } RequestDispatcher rd = null;
		 * request.setAttribute("message", message); request.setAttribute("loginResult",
		 * loginResult); rd =
		 * request.getRequestDispatcher("../JSP/Book/DeleteBook.jsp");
		 * rd.forward(request, response);
		 * 
		 * }
		 */

	}

}
