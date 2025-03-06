package org.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.model.bean.UserBean;
import org.model.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
		HttpSession session=request.getSession();
		UserBean ubean=new UserBean();

    	ubean.setEmail(email);

    	ubean.setPass(pass);

		LoginDao ld=new LoginDao();
		boolean status=ld.login(ubean);
		
		if(status)
		{
			session.setAttribute("email", email);
			session.setAttribute("pass", pass);
			if(email.equals("admin@gmail.com") && pass.equals("admin"))
			{
				
				response.sendRedirect("adminHome.jsp");
			}
			else
			{
				response.sendRedirect("home.jsp");
			}
		}
		else
		{
			response.sendRedirect("login.jsp?msg=invalid");
		}
	}

}
