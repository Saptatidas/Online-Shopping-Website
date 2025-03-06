<%@page import="org.mis.ConnectionProvider" %>
<%@page import="java.sql.*"%>
<%
try{
	Connection con =ConnectionProvider.createC();
	Statement st=con.createStatement();
	String q1="create table users(name varchar(100),email varchar(100)primary key,phno varchar(100),answer varchar(200),pass varchar(200))";
	String q2="create table product(id varchar(100),name varchar(500), category varchar(200), price decimal(20,2),active varchar(100))";
	String q3="create table cart(email varchar(100),product_id varchar(30),quantity int, price decimal(20,2),total int,address varchar(500),city varchar(200),country varchar(200),phno varchar(100),orderDate Date,deliveryDate Date,paymentMethod varchar(100),transactionId varchar(100), status varchar(100))";
	System.out.println(q1);
	System.out.println(q2);
	System.out.println(q3);

	//st.execute(q1);
	//st.execute(q2);//
	st.execute(q3);

	System.out.println("Table Created");
	con.close();
}catch(Exception e){
	System.out.print(e);
}
%>