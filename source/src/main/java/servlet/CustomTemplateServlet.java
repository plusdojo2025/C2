package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class CustomTemplateServlet extends HttpServlet {

	public boolean checkLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String logout = request.getParameter("logout");
		boolean result = (logout != null);
		if (result) {
			HttpSession session = request.getSession();
			session.removeAttribute("id");
			checkNoneLogin(request, response);
		}
		return result;
	}

	protected final boolean checkNoneLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		boolean result = (session.getAttribute("mail") == null);
		if (result) {
			// LOGINにリダイレクトする
			response.sendRedirect("login");
		}
		return result;
	}

	protected final boolean checkDoneLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		boolean result = (session.getAttribute("mail") != null);
		if (result) {
			// Homeにリダイレクトする
			response.sendRedirect("home");
		}
		return result;
	}

	@Override
	protected abstract void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	@Override
	protected abstract void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

		
	}
