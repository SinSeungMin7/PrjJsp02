package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler {

	private String driver = "oracle.jdbc.OracleDriver";  // 오라클 DB와 통신할 때 사용하는 전용 드라이버의 이름
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // DB의 실제 주소 
	                         // (127.0.0.1은 내 컴퓨터, 1521은 포트 번호, xe는 DB 이름)
	private String dbuid  = "sky";    // DB에 들어갈 아이디 비밀번호
	private String dbpwd  = "1234";
	
	// 회원추가
	public  int addUser(String userid, String username, String email) 
			throws ClassNotFoundException, SQLException {
		
		// 오라클 driver 소환 준비단계
	 	Class.forName(driver);  
	 	// jsp 에서는 throw 안해도 에러가 나지 않는다
	 	
	 	// db와 연결된 통로 생성 conn으로 정의 conn을 통해 명령 내릴수있음
	 	Connection         conn = DriverManager.getConnection(url, dbuid, dbpwd); // CTRL + SHIFT + M  : jsp 에서 씀
	 	// DB에게 내릴 명령서를 작성합니다.
	 	// '?'는 나중에 데이터를 채워 넣을 빈칸(예약석)입니다. 보안과 편의를 위해 사용
	 	String              sql = "";
	 	sql   +=  "INSERT INTO TUSER VALUES( ?, ?, ? ) ";
	 	// 작성한 명령서(sql)를 들고 갈 '배달원(pstmt)'을 만듭니다. 아직 출발은 안 했어요
	 	PreparedStatement pstmt = conn.prepareStatement(sql);
	 	// 아까 비워둔 첫 번째, 두 번째, 세 번째 '?' 자리에 실제 데이터들을 순서대로 쏙쏙 끼워 넣습니다
	 	pstmt.setString( 1, userid );
	 	pstmt.setString( 2, username );
	 	pstmt.setString( 3, email );
	 	
	 // 설명: 드디어 명령을 실행합니다! 'Update'는 데이터를 넣거나 바꿀 때 씁니다.
	 // 실행 결과(저장된 행의 개수, 보통 1)를 aftcnt에 저장합니다.
	 	int aftcnt = pstmt.executeUpdate(); // 추가할것이기 때문에 Update 사용
	 	
	 	pstmt.close();
	 	conn.close();
	 // "성공적으로 1줄 저장했어!"라고 JSP에게 보고함
	 	return aftcnt;
	}

}
