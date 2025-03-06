<%@page import="org.mis.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<% 
try{
	  String name = request.getParameter("name");
      String email = request.getParameter("email");
      String phno = request.getParameter("phno");
      String answer = request.getParameter("answer");
      String pass = request.getParameter("pass");

	
		Connection con=ConnectionProvider.createC();
		PreparedStatement pstm=con.prepareStatement("insert into users values(?,?,?,?,?)");
		pstm.setString(1, name);
		pstm.setString(2, email);
		pstm.setString(3, phno);
		pstm.setString(4, answer);
		pstm.setString(5, pass);
//		pstm.setString(6, chk);
		pstm.executeUpdate();
		response.sendRedirect("signup.jsp?msg=valid");
	}catch(Exception e) {
		System.out.print(e);
		response.sendRedirect("signup.jsp?msg=invalid");
	}

%>