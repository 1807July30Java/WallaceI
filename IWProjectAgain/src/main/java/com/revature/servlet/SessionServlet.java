package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1319793763433572026L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":\""+session.getAttribute("username")+"\"}");
			response.getWriter().write("{\"id\":\""+session.getAttribute("id")+"\"}");
			response.getWriter().write("{\"email\":\""+session.getAttribute("email")+"\"}");
			response.getWriter().write("{\"firstname\":\""+session.getAttribute("firstname")+"\"}");
			response.getWriter().write("{\"lastname\":\""+session.getAttribute("lastname")+"\"}");
			response.getWriter().write("{\"title\":\""+session.getAttribute("title")+"\"}");
			response.getWriter().write("{\"reportsto\":\""+session.getAttribute("reportsto")+"\"}");
		} else {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":null}");
			response.getWriter().write("{\"id\":null}");
			response.getWriter().write("{\"email\":null}");
			response.getWriter().write("{\"firstname\":null}");
			response.getWriter().write("{\"lastname\":null}");
			response.getWriter().write("{\"title\":null}");
			response.getWriter().write("{\"reportsto\":null}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
