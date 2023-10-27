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
import in.ineuron.dto.Student;
import in.ineuron.service.IBookService;
import in.ineuron.service.ILibrarianService;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.BookServiceFactory;
import in.ineuron.servicefactory.LibrarianServiceFactory;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet("/student/*")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		System.out.println(request);
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
		ILibrarianService libService = LibrarianServiceFactory.getLibrarianService();
		System.out.println("Inside doprocess "+request.getRequestURI());

		if (request.getRequestURI().endsWith("liblogin")) {
			String id = request.getParameter("loginid");
			String password = request.getParameter("password");
			String role = libService.verifyLibrerian(Integer.parseInt(id), password);
			session.setAttribute("role", role);
			session.setAttribute("libid", id);
			RequestDispatcher rd = null;
			request.setAttribute("role", role);
			rd = request.getRequestDispatcher("../JSP/Student/StudentLoginResult.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("AddStudent")) {
			String loginResult = "success";
			String role = (String) session.getAttribute("role");
			String libid=(String) session.getAttribute("libid");
			String message = null;
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String password = request.getParameter("password");

				Student student = new Student();
				student.setSfname(fname);
				student.setSlname(lname);
				student.setPassword(password);
				student.setFk_libid(Integer.parseInt(libid));
			
				message = service.saveStudent(student);
				System.out.println(message);
			}

			RequestDispatcher rd = null;
			request.setAttribute("message", message);
			request.setAttribute("loginResult", loginResult);
			rd = request.getRequestDispatcher("../JSP/Student/StudentSaveResult.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("FindStudent")) {
			String role = (String) session.getAttribute("role");
			String loginResult = "success";
			Student student = null;
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {

				String id = request.getParameter("id");
				student = service.getStudent(Integer.parseInt(id));
			}
			RequestDispatcher rd = null;
			request.setAttribute("student", student);
			request.setAttribute("loginResult", loginResult);
			System.out.println(student);
			rd = request.getRequestDispatcher("../JSP/Student/ViewStudent.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("EditStudent")) {
			String role = (String) session.getAttribute("role");
			String loginResult = "success";
			Student student = null;
			if (role == null || !role.equalsIgnoreCase("lib")) {
				loginResult = "failure";
			} else {
				String id = request.getParameter("id");
				student = service.getStudent(Integer.parseInt(id));
			}
			RequestDispatcher rd = null;
			request.setAttribute("student", student);
			request.setAttribute("loginResult", loginResult);
			rd = request.getRequestDispatcher("../JSP/Student/UpdateStudent.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("UpdateStudent")) {
			String sid = request.getParameter("sid");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String password = request.getParameter("password");
			String libid=(String) session.getAttribute("libid");

			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSfname(fname);
			student.setSlname(lname);
			student.setPassword(password);
			student.setFk_libid(Integer.parseInt(libid));
			System.out.println(student);
			String message = service.updateStudent(student);
			System.out.println(message+"update result");

			RequestDispatcher rd = null;
			request.setAttribute("message", message);
			rd = request.getRequestDispatcher("../../JSP/Student/StudentUpdateResult.jsp");
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
				message = service.deleteStudent(Integer.parseInt(bookid));
			}
			RequestDispatcher rd = null;
			request.setAttribute("message", message);
			request.setAttribute("loginResult", loginResult);
			rd = request.getRequestDispatcher("../JSP/Student/DeleteStudent.jsp");
			rd.forward(request, response);

		}

	}

}
