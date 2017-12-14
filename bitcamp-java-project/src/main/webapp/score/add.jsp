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
<header>
<nav class='navbar navbar-expand-lg navbar-light bg-light'>
<a class='navbar-brand' href='../index.html'>
  <img src='../images/bootstrap-solid.svg' width='30' height='30' class='d-inline-block align-top' alt=''>
  비트캠프
</a>
<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
  <span class='navbar-toggler-icon'></span>
</button>
<div class='collapse navbar-collapse' id='navbarNav'>
<ul class='navbar-nav'>
  <li class='nav-item'>
    <a class='nav-link' href='../score/list'>성적</a>
  </li>
  <li class='nav-item'>
    <a class='nav-link' href='../member/list'>회원</a>
  </li>
  <li class='nav-item'>
    <a class='nav-link' href='../board/list'>게시판</a>
  </li>
  <li class='nav-item'>
    <a class='nav-link' href='../room/list'>강의실</a>
  </li>
</ul>
</div>
</nav>
</header>
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
    out.println("<p>저장하였습니다.</p>");

} catch (Exception e) {
    e.printStackTrace(); // for developer
    out.println(e.getMessage()); // for user
}
%>

<p><a href='list' class='btn btn-primary btn-sm'>목록</a></p>
<footer>
    비트캠프 자바100기@2017
</footer>
</div>
<script src='../node_modules/jquery/dist/jquery.slim.min.js'></script>
<script src='../node_modules/popper.js/dist/umd/popper.min.js'></script>
<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js'></script>
</body>
</html>

    