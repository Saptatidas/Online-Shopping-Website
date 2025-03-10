<%@page import="org.mis.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<%@include file="header.jsp" %>
<%@include file="footer.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/home-style.css">

<title>My Cart</title>
<style>
h3
{
	color: yellow;
	text-align: center;
}
</style>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">My Cart <i class='fas fa-cart-arrow-down'></i></div>
<%
String msg=request.getParameter("msg");
if("notPossible".equals(msg)){
%>
<h3 class="alert">There is only one Quantity! So click on remove!</h3>
<%} %>
<%
if("inc".equals(msg)){
%>
<h3 class="alert">Quantity  Increased Successfully!</h3>
<%} %>
<%
if("dec".equals(msg)){
%>
<h3 class="alert">Quantity  Decreased Successfully!</h3>
<%} %>
<%
if("removed".equals(msg)){
%>
<h3 class="alert">Product Successfully Removed!</h3>
<%} %>
<table>
<thead>
<%
String email = ""; // Initialize email variable with an empty string
// ... other variable declarations ...
		int total=0;
		int sno=0;
		try{
			Connection con=ConnectionProvider.createC();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select sum(total) from cart where email='"+email+"' and address is NULL");
			while(rs.next()){
				total=rs.getInt(1);
			}

		%>
          <tr>
            <th scope="col" style="background-color: yellow;">Total: <i class="fa fa-inr"></i><%out.println(total); %> </th>
            <%if(total>0){ %><th scope="col"><a href="addressPaymentForOrder.jsp">Proceed to order</a></th><%} %>
          </tr>
        </thead>
        <thead>
          <tr>
          <th scope="col">S.No</th>
            <th scope="col">Product Name</th>
            <th scope="col">Category</th>
            <th scope="col"><i class="fa fa-inr"></i> price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Sub Total</th>
            <th scope="col">Remove <i class='fas fa-trash-alt'></i></th>
          </tr>
        </thead>
        <tbody>
      	<%
      	ResultSet rs1=st.executeQuery("select *from product inner join cart on product.id=cart.product_id and cart.email'"+email+"' and cart.address is NULL");
      	while(rs1.next()){
      		
      	%>
          <tr>
			<%sno=sno+1; %>
           <td><%out.println(sno); %></td>
            <td><%=rs1.getString(2) %></td>
            <td><%=rs1.getString(3) %></td>
            <td><i class="fa fa-inr"></i><%=rs1.getString(4) %> </td>
            <td><a href=""><i class='fas fa-plus-circle'></i></a><%=rs1.getString(8) %>  <a href=""><i class='fas fa-minus-circle'></i></a></td>
            <td><i class="fa fa-inr"></i><%=rs.getString(10) %> </td>
            <td><a href="">Remove <i class='fas fa-trash-alt'></i></a></td>
          </tr>
<%
}
		}
		catch(Exception e){}
%>
        </tbody>
      </table>
      <br>
      <br>
      <br>

</body>
</html>