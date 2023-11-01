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

@WebServlet("/librarianwork/*")
public class LibrarianWork extends HttpServlet {
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
		ILibrarianService service = LibrarianServiceFactory.getLibrarianService();
		IBookService bookService = BookServiceFactory.getLibrarianService();
		System.out.println(request.getRequestURI());

		if (request.getRequestURI().endsWith("IssueBook")) {
			String loginResult="success";
			String role = (String) session.getAttribute("role");
			String id = (String) session.getAttribute("id");
			//String role = service.verifyStudent(Integer.parseInt(id), password);
			//session.setAttribute("role", role);
			//session.setAttribute("id", id);
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {
			RequestDispatcher rd = null;
			request.setAttribute("role", role);
			
			List<BookHistory> bookRequestList = bookService.getBookRequest();
			
			for (BookHistory bookHistory : bookRequestList) {
				System.out.println(bookHistory);
			}
			
			//request.setAttribute("role", role);
			//request.setAttribute("id", id);
			request.setAttribute("loginResult", loginResult);
			request.setAttribute("bookRequestList", bookRequestList);
			System.out.println(id+"librarian work");
			
			rd = request.getRequestDispatcher("../JSP/LibrarianWork/PendingRequest.jsp");
			rd.forward(request, response);
			}
		}
		
		if (request.getRequestURI().endsWith("approvebook")) {
			String loginResult="success";
			String role = (String) session.getAttribute("role");
			String id = (String) session.getAttribute("id");
			String bhid = request.getParameter("reqid");
			String bookid = request.getParameter("bookid");
			String bookname = request.getParameter("bookname");
			String bookcategory = request.getParameter("author");
			String category = request.getParameter("category");
			String reqdate = request.getParameter("reqdate");
			String approveStatus = "failure";
			String bookUpdateStatus = "failure";
			
			System.out.println(bookcategory+" "+bookname+" "+category+" "+reqdate+" "+bookid);
			
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {
				
				
				String status = bookService.getQty(Integer.parseInt(/*bhid*/bookid),Integer.parseInt(id));
				System.out.println(status+"update");
				if(status.equalsIgnoreCase("success")) {
					bookUpdateStatus = bookService.updateBookQty(Integer.parseInt(bookid));
				}
				
				if(bookUpdateStatus.equalsIgnoreCase("success")) {
					approveStatus = bookService.approveBook(Integer.parseInt(bhid),Integer.parseInt(id));
				}
				
				
				RequestDispatcher rd = null;
				request.setAttribute("loginResult", loginResult);
				request.setAttribute("status", status);
				request.setAttribute("bookUpdateStatus", bookUpdateStatus);
				request.setAttribute("approveStatus", approveStatus);
				
				rd = request.getRequestDispatcher("../../JSP/LibrarianWork/IssueBook.jsp");
				rd.forward(request, response);
			}
		}
		
		if (request.getRequestURI().endsWith("IssuedBookList")) {
			String loginResult="success";
			String role = (String) session.getAttribute("role");
			String id = (String) session.getAttribute("id");
			String sid = request.getParameter("sid");
				
			List<BookHistory> bookList = bookService.getIssuedBookList(Integer.parseInt(sid));
				for (BookHistory bookHistory : bookList) {
					System.out.println(bookHistory);
				}
				
				RequestDispatcher rd = null;
				request.setAttribute("loginResult", loginResult);
				request.setAttribute("bookList", bookList);
				rd = request.getRequestDispatcher("../JSP/LibrarianWork/AcceptBookPage.jsp");
				rd.forward(request, response);
			
		}
		
		if (request.getRequestURI().endsWith("acceptbook")) {
			String loginResult="success";
			String role = (String) session.getAttribute("role");
			String id = (String) session.getAttribute("id");
			String bookid = request.getParameter("bookid");
			String bhid = request.getParameter("reqid");
			String penalty = request.getParameter("penalty");
			String amountStatus = request.getParameter("amountStatus");
			String acceptStatus = "failure";
			String bookUpdateStatus = "failure";
			
			
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {
				
					bookUpdateStatus = bookService.updateBookQtyAccept(Integer.parseInt(bookid));
				
				if(bookUpdateStatus.equalsIgnoreCase("success")) {
					acceptStatus = bookService.acceptBook(Integer.parseInt(bhid),Integer.parseInt(penalty),amountStatus);
				}
				System.out.println(acceptStatus);
				
				
				RequestDispatcher rd = null;
				request.setAttribute("loginResult", loginResult);
				request.setAttribute("bookUpdateStatus", bookUpdateStatus);
				request.setAttribute("acceptStatus", acceptStatus);
				
				rd = request.getRequestDispatcher("../../JSP/LibrarianWork/AcceptBook.jsp");
				rd.forward(request, response);
			}
		}
		

		/*
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
			
			
		}*/

		

	}

}
