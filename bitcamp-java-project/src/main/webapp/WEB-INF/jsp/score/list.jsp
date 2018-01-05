<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>성적관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>성적 목록</h1>

<div class="toolbar">
<a href='form' class='btn btn-primary btn-sm'>추가</a>
<form action="list" method="get" class="searchbox">
<input type="text" name="nm">
<button>검색</button>
</form>
</div>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>이름</th><th>합계</th><th>평균</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="score">
    <tr>
        <td>${score.no}</td>
        <td><a href='${score.no}'>${score.name}</a></td>
        <td>${score.sum}</td>
        <td>${score.aver}</td>
    </tr>
</c:forEach>

</tbody>
</table>

<c:set var="prevPageDisabled" value="${(pageNo > 1) ? '':'disabled'}"/>
<c:set var="prevPageTabIndex" value="${(pageNo > 1) ? 0 : -1}"/>
<c:set var="nextPageDisabled" value="${(pageNo < lastPageNo) ? '':'disabled'}"/>
<c:set var="nextPageTabIndex" value="${(pageNo < lastPageNo) ? 0 : -1}"/>

<nav aria-label="Page navigation">
  <ul class="pagination justify-content-center">
    <li class="page-item ${prevPageDisabled}"><a class="page-link" 
        href="list?pn=${pageNo - 1}"
        tabindex="${prevPageTabIndex}">이전</a></li>
        
    <li class="page-item"><a class="page-link" href="#">${pageNo}</a></li>
    
    <li class="page-item ${nextPageDisabled}"><a class="page-link" 
        href="list?pn=${pageNo + 1}"
        tabindex="${nextPageTabIndex}">다음</a></li>
  </ul>
</nav>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>











