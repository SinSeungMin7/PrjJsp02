<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // name="username" , 대소문자 구분
    request.setCharacterEncoding("utf-8");  // 넘어오는 데이터의 인코딩
    String   username = request.getParameter("username"); 
    
    // db 조회
    String   driver = "oracle.jdbc.OracleDriver";
    String   url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    String   dbuid  = "sky";
    String   dbpwd  = "1234";    
    
    Class.forName(driver);
    Connection         conn   =  DriverManager.getConnection(url, dbuid, dbpwd);
    String             sql    =  "";
    sql   +=  "SELECT * FROM TUSER";
    sql   +=  " WHERE USERNAME LIKE ?";
    PreparedStatement  pstmt  =  conn.prepareStatement(sql);
    pstmt.setString(1, "%"+ username + "%");
    
   ResultSet          rs     =  pstmt.executeQuery();
   String             tag    = "";
   while( rs.next() ) {
	   String  userid      =   rs.getString("userid");
	   String  ousername   =   rs.getString("username");
	   String  email       =   rs.getString("email");
	   
	   tag   +=  "<li>"+  userid  + "," + ousername + ","  + email + "</li>";
	    
   }
   
   rs.close();
   pstmt.close();
   conn.close();
    
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>List jsp</h2>
	<p>검색할 이름:<%=username %></p>
	<ul><%=tag %></ul>
</body>
</html>