package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import db.DBHandler;


@WebServlet("/adduser2")
public class AddUser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*   
    // 생성자 (실행순서 1번) : 보통 생략하고 사용함
    public AddUser2() {
    	System.out.println("생성자");
    }

    // init (실행순서 2번) - 초기화 : 보통 생략하고 사용함 
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행");
	}

	// destroy 클래스의 인스턴스 소멸될때 실행된다 (실행순서 4번) : 보통 생략하고 사용함
	public void destroy() {
		System.out.println("destroy() 실행");
	}

	// service (실행순서 3번) - doGet/doPost 판단
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
	}
    */
	// doGet 실행순서 5번
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		// System.out.println("doGet() 실행");
		String userid   = request.getParameter("userid");
		String username = request.getParameter("username");
		String email    = request.getParameter("email");
		
		DBHandler db = new DBHandler();
		try {
            db.addUser(userid, username, email);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // 에러 발생 시 콘솔에 출력
        }
		
		response.sendRedirect("/Prjjsp02/");		
		
		/*
		// console
		System.out.println(userid);
		// Html 페이지에 출력
		// application/xml(.xml), application/json(.json), plain/text(.txt)
		response.setContentType("  text/html; charset=utf-8 ");
		PrintWriter out = response.getWriter();
		out.write( userid );
		out.close();
		*/
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	// doPost
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		System.out.println("doPost() 실행");
		doGet(request, response);
	}

}








