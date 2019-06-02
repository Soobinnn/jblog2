<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/includes/blog_nav.jsp'/>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url='/WEB-INF/views/includes/blog_admin_nav.jsp'/>
				<form:form modelAttribute="post]Vo" class="write-form" id="write-form" 
				name="writeForm" method="post" action="${pageContext.servletContext.contextPath }/${sessionScope.authUser.ID}/postWrite" >
				<%-- <form action="${pageContext.servletContext.contextPath}/${sessionScope.authUser.ID}/postWrite" method="post"> --%>
			      	<table class="admin-cat-write">
			      		<tr>
			      			<td class="t">제목</td>
			      			<td>
			      				<input type="text" size="60" name="TITLE">
				      			<select name="CATEGORY_NO">
				      				<c:forEach items="${categoryNameList}" var="vo" varStatus="status">
				      				<option value="${vo.CATEGORY_NO }">${vo.CATEGORY_NAME}</option>
				      				</c:forEach>
				      			</select>
				      		</td>
			      		</tr>
			      		<tr>
			      			<td></td>
			      			<td>
			      				<spring:hasBindErrors name="postVo">
				 					<c:if test="${errors.hasFieldErrors('TITLE') }">
										<p style="font-weight:bold; color:red; text-align:left; padding:0">
					  					<spring:message 
											code="${errors.getFieldError( 'TITLE' ).codes[0] }" 				     
						    				text="${errors.getFieldError( 'TITLE' ).defaultMessage }" />
										</p> 
			   						</c:if>
								</spring:hasBindErrors>
							</td>
			      		</tr>
			      		<tr>
			      			<td class="t">내용</td>
			      			<td><textarea name="CONTENT"></textarea></td>
			      		</tr>
			      		<tr>
			      			<td>
			      			</td>
			      			<td>
			      			<spring:hasBindErrors name="postVo">
				 					<c:if test="${errors.hasFieldErrors('CONTENT') }">
										<p style="font-weight:bold; color:red; text-align:left; padding:0">
					  					<spring:message 
											code="${errors.getFieldError( 'CONTENT' ).codes[0] }" 				     
						    				text="${errors.getFieldError( 'CONTENT' ).defaultMessage }" />
										</p> 
			   						</c:if>
							</spring:hasBindErrors>
							</td>
						</tr>
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td class="s"><input type="submit" value="포스트하기"></td>
			      		</tr>
			      	</table>
				</form:form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>