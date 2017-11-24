package java100.app.control;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import java100.app.domain.Score;

public class ScoreController extends GenericController<Score> {
    
    @Override
    public void destroy() {}
    
    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // => com.mysql.jdbc.Driver 클래스를 로딩한다.
            // => static {} 블록을 수행한다.
            //    => Driver 인스턴스를 생성한다.
            //    => DriverManager에 그 인스턴스를 등록한다.
            
        } catch (ClassNotFoundException ex) {
            // 이 예외가 발생하면 init()를 호출한 쪽에 예외를 던진다.
            // 단 RuntimeException 예외인 경우 스텔스 방식으로 전달되기 때문에,
            // 굳이 메서드 선언부에 어떤 예외를 던지는지 적시할 필요는 없다.
            throw new RuntimeException(
                    "JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }
    
    @Override
    public void execute(Request request, Response response) {

        switch (request.getMenuPath()) {
        case "/score/add": this.doAdd(request, response); break;
        case "/score/list": this.doList(request, response); break;
        case "/score/view": this.doView(request, response); break;
        case "/score/update": this.doUpdate(request, response); break;
        case "/score/delete": this.doDelete(request, response); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        
        out.println("[성적 삭제]");
        
        Score score = findByName(name);
        
        if (score == null) {
            out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            list.remove(score);
            out.println("삭제했습니다.");
        }
    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        
        out.println("[성적 변경]");
        
        Score score = findByName(name);
        
        if (score == null) {
            out.printf("'%s'의 성적 정보가 없습니다.\n", name);
            return;
        } 
        
        score.setKor(Integer.parseInt(request.getParameter("kor")));
        score.setEng(Integer.parseInt(request.getParameter("eng")));
        score.setMath(Integer.parseInt(request.getParameter("math")));
        
        out.println("변경하였습니다!");
    }

    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        
        Score score = findByName(name);
        
        out.println("[성적 상세 정보]");
        
        if (score == null) {
            out.printf("'%s'의 성적 정보가 없습니다.\n", name);
            return;
        }
        
        out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                score.getName(),
                score.getKor(),
                score.getEng(),
                score.getMath(),
                score.getSum(), 
                score.getAver());
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[성적 목록]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "select no,name,kor,eng,math from ex_score");
             ResultSet rs = pstmt.executeQuery();){
            
            while (rs.next()) {
                int sum = rs.getInt("kor") + rs.getInt("eng") + rs.getInt("math");
                float aver = sum / 3f;
                out.printf("%4d, %-4s, %4d, %6.1f\n",
                        rs.getInt("no"),
                        rs.getString("name"), 
                        sum, aver);
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doAdd(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "insert into ex_score(name,kor,eng,math) values(?,?,?,?)");
             ){
            
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setInt(2, Integer.parseInt(request.getParameter("kor")));
            pstmt.setInt(3, Integer.parseInt(request.getParameter("eng")));
            pstmt.setInt(4, Integer.parseInt(request.getParameter("math")));
            
            pstmt.executeUpdate();
            out.println("저장하였습니다.");
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
    private Score findByName(String name) {
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            if (score.getName().equals(name)) {
                return score;
            }
        }
        return null;
    }
}













