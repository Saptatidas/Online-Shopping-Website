package org.controller; // Update with your actual  package name

import org.model.bean.*; // Update with your actual package name
import org.model.dao.*; // Update with your actual package name

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Sign")
public class Sign extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phno = request.getParameter("phno");
        String ans = request.getParameter("ans");
        String pass = request.getParameter("pass");
		HttpSession session=request.getSession();
        UserBean ubean=new UserBean();
    	ubean.setName(name);
    	ubean.setEmail(email);
    	ubean.setPhno(phno);
    	ubean.setPass(pass);
    	ubean.setAns(ans);

        SignupDao ld = new SignupDao();
        int i=ld.insert(ubean);

        if(i!=0)
    	{
    		response.sendRedirect("signup.jsp?msg=valid");
    		//pw.println("<h2>Sucessfully Registered!</h2>");
    	}
    	else
    	{
    		response.sendRedirect("signup.jsp?msg=invalid");
    		//pw.println("<h2>Their is some issue!</h2>");
    	}
    	}
    }
