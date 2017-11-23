// DBMS 서버에게 SQL문을 보내기 - insert + 사용자 입력
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) throws Exception {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("제목? ");
        String title = keyboard.nextLine();
        
        System.out.print("내용? ");
        String contents = keyboard.nextLine();
        keyboard.close();
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(
            "insert into jdbc_test(title,conts,regdt)"
            + " values('" + title
            + "','" + contents
            + "',now())");
        
        System.out.println("입력 완료!");
        
        stmt.close();
        con.close();
    }

}









