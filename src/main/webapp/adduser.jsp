<%@page import="db.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  // http://localhost:8080/Prjjsp02/adduser.jsp
  // ?userid=sky10
  // &username=%EC%8A%A4%EC%B9%B4%EC%9D%B410
  // &email=sky10%40green.com
    request.setCharacterEncoding("utf-8"); // 인코딩 형식을 한글파일로 설정하기 위해 (설정하지 않았을시 깨져보일수 있기 때문) 
	String   userid     =   request.getParameter("userid");  // request : 브라우저가 서버로 보낸 요청 객체 사용자가 입력한 id,name,email 이 있다
	String   username   =   request.getParameter("username");
	String   email      =   request.getParameter("email");    // request : 받는것, reponse : 내보내는것

	// db 에 저장
	DBHandler  db       =   new DBHandler(); // DBHandler 를 db로 정의
	db.addUser(userid, username, email); // 정의된 db 에 (userid, username, email)를 넣는 문장
	   // db.addUser : db라는 변수를 만들고 DBHandler에 있는 addUser 기능을 실행하는 문장
	
	response.sendRedirect("http://localhost:8080/Prjjsp02/"); // 작업이 끝낫으니 http://localhost:8080/Prjjsp02/ 로 접속해라고 하는 명령어 
	
	// 출력 자료들 userid, username, email
	System.out.println( userid );
	System.out.println( username );
	System.out.println( email );
	
%>    
    
    
    
    
    
    
    