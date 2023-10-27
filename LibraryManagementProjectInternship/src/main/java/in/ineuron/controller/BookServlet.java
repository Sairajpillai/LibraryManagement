package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.daofactory.LibrarianDAOFactory;
import in.ineuron.dto.Book;
import in.ineuron.service.IBookService;
import in.ineuron.service.ILibrarianService;
import in.ineuron.servicefactory.BookServiceFactory;
import in.ineuron.servicefactory.LibrarianServiceFactory;

@WebServlet("/book/*")
public class BookServlet extends HttpServlet {
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
		IBookService service = BookServiceFactory.getLibrarianService();
		ILibrarianService libService = LibrarianServiceFactory.getLibrarianService();
		System.out.println(request.getRequestURI());

		if (request.getRequestURI().endsWith("liblogin")) {
			String id = request.getParameter("loginid");
			String password = request.getParameter("password");
			String role = libService.verifyLibrerian(Integer.parseInt(id), password);
			session.setAttribute("role", role);
			RequestDispatcher rd = null;
			request.setAttribute("role", role);
			//rd = request.getRequestDispatcher("../AdminLoginResult.jsp");
			rd = request.getRequestDispatcher("../JSP/Book/LibrarianLoginResult.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("AddBook")) {
			String loginResult = "success";
			String role = (String) session.getAttribute("role");
			String message = null;
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {
				String bookname = request.getParameter("bookname");
				String bookcategory = request.getParameter("bookcategory");
				String bookqty = request.getParameter("bookqty");
				String author = request.getParameter("bookauthor");

				Book book = new Book();
				book.setBookName(bookname);
				book.setBookCategory(bookcategory);
				book.setBookQty(Integer.parseInt(bookqty));
				book.setAuthor(author);
				

				message = service.saveBook(book);
				System.out.println(message);
			}

			RequestDispatcher rd = null;
			request.setAttribute("message", message);
			request.setAttribute("loginResult", loginResult);
			//rd = request.getRequestDispatcher("../BookSaveResult.jsp");
			rd = request.getRequestDispatcher("../JSP/Book/BookSaveResult.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("FindBook")) {
			String role = (String) session.getAttribute("role");
			String loginResult = "success";
			Book book = null;
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {

				String id = request.getParameter("id");
				book = service.getBook(Integer.parseInt(id));
			}
			RequestDispatcher rd = null;
			request.setAttribute("book", book);
			request.setAttribute("loginResult", loginResult);
			System.out.println(book);
			rd = request.getRequestDispatcher("../JSP/Book/ViewBook.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("EditBook")) {
			String role = (String) session.getAttribute("role");
			String loginResult = "success";
			Book book = null;
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {
				String id = request.getParameter("id");
				book = service.getBook(Integer.parseInt(id));
			}
			RequestDispatcher rd = null;
			request.setAttribute("book", book);
			request.setAttribute("loginResult", loginResult);
			rd = request.getRequestDispatcher("../JSP/Book/UpdateBook.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("UpdateBook")) {
			String bookid = request.getParameter("bookid");
			String bookname = request.getParameter("bookname");
			String bookcategory = request.getParameter("bookcategory");
			String bookauthor = request.getParameter("bookauthor");
			Integer bookqty = Integer.parseInt(request.getParameter("bookqty"));

			Book book = new Book();
			book.setBookId(Integer.parseInt(bookid));
			book.setBookName(bookname);
			book.setBookCategory(bookcategory);
			book.setAuthor(bookauthor);
			book.setBookQty(bookqty);
			System.out.println(book);
			String message = service.updateBook(book);

			RequestDispatcher rd = null;
			request.setAttribute("message", message);
			rd = request.getRequestDispatcher("../../JSP/Book/BookUpdateResult.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("DeleteForm")) {
			String role = (String) session.getAttribute("role");
			String loginResult = "success";
			String message = null;
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {
				String bookid = request.getParameter("bookid");
				System.out.println(bookid);
				message = service.deleteBook(Integer.parseInt(bookid));
			}
			RequestDispatcher rd = null;
			request.setAttribute("message", message);
			request.setAttribute("loginResult", loginResult);
			rd = request.getRequestDispatcher("../JSP/Book/DeleteBook.jsp");
			rd.forward(request, response);

		}

	}

}
