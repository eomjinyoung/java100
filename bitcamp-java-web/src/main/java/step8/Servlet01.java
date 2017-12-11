// GET/POST 요청 처리하기
//
package step8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step8/Servlet01")
public class Servlet01 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>GET/POST 요청 처리</title>");
        out.println("</head>");
        out.println("<body>");
        
        // 클라이언트가 요청한 방식을 알고 싶다면 
        // HttpServletRequest의 getMethod()를 호출하라!
        out.printf("<h1>%s 요청</h1>\n", req.getMethod());
        out.printf("name=%s<br>\n", req.getParameter("name"));
        out.printf("age=%s<br>\n", req.getParameter("age"));
        out.println("</body>");
        out.println("</html>");
    }
}









