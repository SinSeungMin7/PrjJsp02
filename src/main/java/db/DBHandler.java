package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler {

	private String driver = "oracle.jdbc.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuid  = "sky";
	private String dbpwd  = "1234";
	
	// 회원추가
	public  int addUser(String userid, String username, String email) 
			throws ClassNotFoundException, SQLException {
	 
	 	Class.forName(driver);  
	 	// jsp 에서는 throw 안해도 에러가 나지 않는다
	 	Connection         conn = DriverManager.getConnection(url, dbuid, dbpwd); // CTRL + SHIFT + M  : jsp 에서 씀
	 	String              sql = "";
	 	sql   +=  "INSERT INTO TUSER VALUES( ?, ?, ? ) ";
	 	PreparedStatement pstmt = conn.prepareStatement(sql);
	 	pstmt.setString( 1, userid );
	 	pstmt.setString( 2, username );
	 	pstmt.setString( 3, email );
	 	
	 	int aftcnt = pstmt.executeUpdate(); // 추가할것이기 때문에 Update 사용
	 	
	 	pstmt.close();
	 	conn.close();
	 	
	 	return aftcnt;
	}

}
