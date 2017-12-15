<%@page import="java100.app.domain.Member"%>
<%@page import="java100.app.listener.ContextLoaderListener"%>
<%@page import="java100.app.dao.MemberDao"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
MemberDao memberDao = ContextLoaderListener.iocContainer.getBean(
        MemberDao.class);
%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>
<%
out.flush();
RequestDispatcher rd = request.getRequestDispatcher("/header.jsp");
rd.include(request, response);
%>
<h1>회원 등록 결과</h1>
<%
try {
    
    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    
    memberDao.insert(member);%>
    <p>저장하였습니다.</p>
<%    
} catch (Exception e) {
    e.printStackTrace(); // for developer%>
    <%=e.getMessage() %>
<%
} %>
<p><a href='list.jsp' class='btn btn-primary btn-sm'>목록</a></p>
<%
out.flush();
rd = request.getRequestDispatcher("/footer.jsp");
rd.include(request, response);
%>
</div>

<script src='../node_modules/jquery/dist/jquery.slim.min.js'></script>
<script src='../node_modules/popper.js/dist/umd/popper.min.js'></script>
<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js'></script>

</body>
</html>
