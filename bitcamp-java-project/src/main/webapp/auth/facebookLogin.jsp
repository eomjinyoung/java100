<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<c:url var="facebookMe" value="https://graph.facebook.com/v2.12/me">
    <c:param name="access_token" value="${param.access_token}"/>
    <c:param name="fields" value="id,name,email"/>
    <c:param name="format" value="json"/>
    <c:param name="method" value="get"/>
</c:url>
<p>${facebook}</p>
<textarea cols="80" rows="10"><c:import url="${facebookMe}"/></textarea>


</div>

</body>
</html>