<%@page import="java100.app.domain.Score"%>
<%@page import="java100.app.listener.ContextLoaderListener"%>
<%@page import="java100.app.dao.ScoreDao"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
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
<h1>성적 등록 결과</h1>
<%
ScoreDao scoreDao = ContextLoaderListener.iocContainer.getBean(
        ScoreDao.class);
try {
    Score score = new Score();
    score.setName(request.getParameter("name"));
    score.setKor(Integer.parseInt(request.getParameter("kor")));
    score.setEng(Integer.parseInt(request.getParameter("eng")));
    score.setMath(Integer.parseInt(request.getParameter("math")));

    scoreDao.insert(score);
%>
    <p>저장하였습니다.</p>
<%
} catch (Exception e) {
    e.printStackTrace(); // for developer
    out.println(e.getMessage()); // for user
}
%>

<p><a href='list' class='btn btn-primary btn-sm'>목록</a></p>
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

    