package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Invoice;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.InvoiceDAO;
import com.revature.dao.InvoiceDAOImpl;

public class ProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8343002811379165553L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		EmployeeDAO empDao = new EmployeeDAOImpl();
		Employee emp = empDao.getMyEmpInfo(username);
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
//		System.out.println(session.getAttribute("username").toString());
		session.setAttribute("id", emp.getId());
		session.setAttribute("email", emp.getEmail());
		session.setAttribute("firstName", emp.getFirstname());
		session.setAttribute("lastName", emp.getLastname());
		session.setAttribute("title", emp.getTitle());
		session.setAttribute("manager", emp.getReportsTo());
		request.getRequestDispatcher("profile.html").include(request, response);
		if (session != null && session.getAttribute("username") != null) {
			System.out.println(emp.getReportsTo());
			if (emp.getReportsTo() != "") { //if I have a manager
				System.out.println(emp.getTitle() != "New Hire");
				if (emp.getTitle() != "New Hire") { //and if I'm a manager
					
					
					InvoiceDAO invD = new InvoiceDAOImpl();
					List<Invoice> inv = invD.getMyEmpPendingInvoices(emp.getId());
					try {
						String invList = om.writeValueAsString(inv);
						pw.println(invList);
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				//REQUEST SHIT
				pw.println("<form class=\"displayDiv\" method=\"post\">");
				pw.println("Requested Amount:");
				pw.println("<input type=\"number\" name=\"amount\" autocomplete=\"off\" autofocus pattern=\"[0-9]{4}\" placeholder=\"0000\" />");
				pw.println("<br>");
				pw.println("<br>");
				pw.println("<input type=\"submit\" value=\"Submit\" />");
				pw.println("</form>");
	            
			
				pw.println("<div class=\"displayDiv\">");
				pw.println("<a href=\"logout\">Logout</a>");
				pw.println("</div>");
				
			}
			pw.println("</body><script src=\"scripts/check.js\"></script></html>");
		} else {
			response.sendRedirect("login");
		}
	}
	}

