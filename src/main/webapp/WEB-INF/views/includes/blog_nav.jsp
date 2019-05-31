<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div id="header">	
		<h1><a href="${pageContext.servletContext.contextPath}/${blogInfo.ID}" class="head_" style="color:white">${blogInfo.TITLE}</a></h1>
		<c:choose>
			<c:when test='${sessionScope.authUser.ID==blogInfo.ID}'>
					<ul>
						<li><a href="${pageContext.servletContext.contextPath}/user/logout">로그아웃</a></li>
						<li><a href="${pageContext.servletContext.contextPath}/${sessionScope.authUser.ID}/admin">블로그 관리</a></li>
					</ul>
			</c:when>
			<c:when test='${empty sessionScope.authUser}'>
					<ul>
						<li><a href="${pageContext.servletContext.contextPath}/user/login">로그인</a></li>
					</ul>
			</c:when>
			<c:otherwise>
					<ul>
						<li><a href="${pageContext.servletContext.contextPath}/user/logout">로그아웃</a></li>
					</ul>					
			</c:otherwise>
		</c:choose>
	</div>