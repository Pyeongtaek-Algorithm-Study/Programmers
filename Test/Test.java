import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDataHandler {

    // 1. 보안 취약점: 하드코딩된 비밀번호 및 연결 정보
    private String dbUrl = "jdbc:mysql://localhost:3306/mydb";
    private String user = "admin";
    private String pass = "123456!@#"; 

    public List<String> getUserNames(String departmentId) {
        List<String> names = new ArrayList<>();
        
        try {
            Connection conn = DriverManager.getConnection(dbUrl, user, pass);
            // 2. 보안 취약점: SQL Injection 위험 (PreparedStatement 미사용)
            String query = "SELECT name FROM users WHERE dept_id = '" + departmentId + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                names.add(rs.getString("name"));
            }
            
            // 3. 코드 품질: 자원 반납(close) 누락 (try-with-resources 미사용)
            // stmt.close(), conn.close() 등이 호출되지 않아 메모리 누수 위험
            
        } catch (Exception e) {
            // 4. 안좋은 습관: 예외를 단순히 출력만 하거나 무시함
            e.printStackTrace();
        }
        
        return names;
    }

    // 5. 비효율적인 로직: 불필요한 객체 생성 및 낮은 가독성
    public String processString(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            resultBuilder.append(input).append(i);
        }
        return resultBuilder.toString();
        return result;
    }
}
