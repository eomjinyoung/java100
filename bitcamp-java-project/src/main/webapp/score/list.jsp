<%@page import="java.io.PrintWriter"%>
<%@page import="java100.app.domain.Score"%>
<%@page import="java.util.List"%>
<%@page import="java100.app.listener.ContextLoaderListener"%>
<%@page import="java100.app.dao.ScoreDao"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
ScoreDao scoreDao = ContextLoaderListener.iocContainer.getBean(
        ScoreDao.class);
%>
<!DOCTYPE html>
<html>
<head>
<title>성적관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>
<%
out.flush();

RequestDispatcher rd = request.getRequestDispatcher("/header");
rd.include(request, response);
%>
<h1>성적 목록</h1>

<p><a href='form.jsp' class='btn btn-primary btn-sm'>추가</a></p>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>이름</th><th>합계</th><th>평균</th>
</tr>
</thead>
<tbody>
<%
try {
    List<Score> list = scoreDao.selectList();
    
    PrintWriter out2 = new PrintWriter(out);
    for (Score score : list) {
        out2.printf("<tr><td>%d</td><td>"
                + "<a href='view?no=%d'>%s</a>"
                + "</td><td>%d</td><td>%3.1f</td></tr>\n",
                score.getNo(),
                score.getNo(),
                score.getName(), 
                score.getSum(), 
                score.getAver());
    }
    
} catch (Exception e) {
    e.printStackTrace(); // for developer
    out.println(e.getMessage()); // for user
}
%>

</tbody>
</table>
<%
out.flush();

rd = request.getRequestDispatcher("/footer");
rd.include(request, response);
%>

</div>

<script src='../node_modules/jquery/dist/jquery.slim.min.js'></script>
<script src='../node_modules/popper.js/dist/umd/popper.min.js'></script>
<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js'></script>
</body>
</html>
