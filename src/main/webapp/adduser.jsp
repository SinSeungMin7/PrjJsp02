<%@page import="db.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  // http://localhost:8080/PrjJsp02/adduser.jsp
  // ?userid=sky10
  // &username=%EC%8A%A4%EC%B9%B4%EC%9D%B410
  // &email=sky10%40green.com
    request.setCharacterEncoding("utf-8");
	String   userid     =   request.getParameter("userid");
	String   username   =   request.getParameter("username");
	String   email      =   request.getParameter("email");

	// db 에 저장
	DBHandler  db       =   new DBHandler();
	db.addUser(userid, username, email);
	
	response.sendRedirect("http://localhost:8080/Prjjsp02/");
	
	System.out.println( userid );
	System.out.println( username );
	System.out.println( email );
	
	
%>    
    
    
    
    
    
    
    