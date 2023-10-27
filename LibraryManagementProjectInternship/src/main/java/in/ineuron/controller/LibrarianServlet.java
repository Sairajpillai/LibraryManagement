package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.dto.Librarian;
import in.ineuron.service.ILibrarianService;
import in.ineuron.servicefactory.LibrarianServiceFactory;

@WebServlet("/librarian/*")
public class LibrarianServlet extends HttpServlet {
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
		ILibrarianService service = LibrarianServiceFactory.getLibrarianService();
		System.out.println(request.getRequestURI());
		HttpSession session = request.getSession();

		if (request.getRequestURI().endsWith("adminlogin")) {
			String id = request.getParameter("loginid");
			String password = request.getParameter("password");
			String role = service.verifyLibrerian(Integer.parseInt(id), password);
			session.setAttribute("role", role);
			RequestDispatcher rd = null;
			request.setAttribute("role", role);
			//rd = request.getRequestDispatcher("../AdminLoginResult.jsp");
			rd = request.getRequestDispatcher("../JSP/Librarian/AdminLoginResult.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("AddLibrarian")) {
			String loginResult = "success";
			String role = (String) session.getAttribute("role");
			String message = null;
			if (role == null || !role.equalsIgnoreCase("admin")) {
				loginResult = "failure";
			} else {
				String libfname = request.getParameter("libfname");
				String liblname = request.getParameter("liblname");
				String password = request.getParameter("password");

				Librarian lib = new Librarian();
				lib.setLibfname(libfname);
				lib.setLiblname(liblname);
				lib.setPassword(password);
				message = service.saveLibrarian(lib);
			}
			RequestDispatcher rd = null;
			request.setAttribute("message", message);
			request.setAttribute("loginResult", loginResult);
			//rd = request.getRequestDispatcher("../SaveResult.jsp");
			rd = request.getRequestDispatcher("../JSP/Librarian/SaveResult.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("FindLibrarian")) {
			String loginResult = "success";
			String role = (String) session.getAttribute("role");
			Librarian librarian = null;
			if (role == null || !role.equalsIgnoreCase("admin")) {
				loginResult = "failure";
			} else {
			String id = request.getParameter("id");
			librarian = service.getLiberarian(Integer.parseInt(id));
			}
			RequestDispatcher rd = null;
			System.out.println(librarian);
			request.setAttribute("librarian", librarian);
			request.setAttribute("loginResult", loginResult);
			//rd = request.getRequestDispatcher("../ViewLibrarian.jsp");
			rd = request.getRequestDispatcher("../JSP/Librarian/ViewLibrarian.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("EditLibrarian")) {
			String loginResult = "success";
			String role = (String) session.getAttribute("role");
			Librarian  librarian = null;
			if (role == null || !role.equalsIgnoreCase("admin")) {
				loginResult = "failure";
			} else {
			String id = request.getParameter("id");
			librarian = service.getLiberarian(Integer.parseInt(id));
			}
			System.out.println(librarian);
			RequestDispatcher rd = null;
			request.setAttribute("librarian", librarian);
			request.setAttribute("loginResult", loginResult);
			//rd = request.getRequestDispatcher("../UpdateLibrarian.jsp");
			rd = request.getRequestDispatcher("../JSP/Librarian/UpdateLibrarian.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("UpdateLibrarian")) {
			String libid = request.getParameter("libid");
			String libfname = request.getParameter("libfname");
			String liblname = request.getParameter("liblname");

			Librarian lib = new Librarian();
			lib.setLibid(Integer.parseInt(libid));
			lib.setLibfname(libfname);
			lib.setLiblname(liblname);

			String message = service.updateLibrarian(lib);
			System.out.println(message + "controller");

			RequestDispatcher rd = null;
			request.setAttribute("message", message);
			//rd = request.getRequestDispatcher("../../LibrarianUpdateResult.jsp");
			rd = request.getRequestDispatcher("../../JSP/Librarian/LibrarianUpdateResult.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("DeleteForm")) {
			String loginResult = "success";
			String role = (String) session.getAttribute("role");
			String status = null;
			if (role == null || !role.equalsIgnoreCase("admin")) {
				loginResult = "failure";
			} else {
			String libid = request.getParameter("libid");
			status = service.deleteLibrarian(Integer.parseInt(libid));
			}
			RequestDispatcher rd = null;

			request.setAttribute("status", status);
			request.setAttribute("loginResult", loginResult);
			//rd = request.getRequestDispatcher("../DeleteLibrarianResult.jsp");
			rd = request.getRequestDispatcher("../JSP/Librarian/DeleteLibrarianResult.jsp");
			rd.forward(request, response);

		}

	}

}
