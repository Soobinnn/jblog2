<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<ul class="menu">
	<c:choose>
		<c:when test='${empty sessionScope.authUser}'>
			<li><a href="${pageContext.servletContext.contextPath }/user/login">로그인</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/user/join">회원가입</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/user/login">내블로그</a></li>
		</c:when>
		<c:when test='${!empty sessionScope.authUser}'>
			<li>${sessionScope.authUser.NAME}님 
			<li><a href="${pageContext.servletContext.contextPath}/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/${sessionScope.authUser.ID}">내블로그</a></li>
		</c:when>
	</c:choose>
</ul>