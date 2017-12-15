<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>강의실관리</title>
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
<h1>새 강의실</h1>
<form action="add.jsp" method='post'>
<div class='form-group row'>
<label for='location' class='col-sm-2 col-form-label'>지역</label>
<div class='col-sm-10'>
<input class='form-control' id='location' type='text' name='location'>
</div>
</div>
<div class='form-group row'>
<label for='name' class='col-sm-2 col-form-label'>강의실명</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'>
</div>
</div>
<div class='form-group row'>
<label for='capacity' class='col-sm-2 col-form-label'>수용인원</label>
<div class='col-sm-10'>
<input class='form-control' id='capacity' type='number' name='capacity'>
</div>
</div>
<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm'>등록</button>
</div>
</div>
</form>
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
    