<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
			<div id="content">
				<div class="blog-content">
					<h4>${mainView.postView.TITLE}</h4>
					<p>
						${mainView.postView.CONTENT}
					<p>
				</div>
				<ul class="blog-list">
				<c:forEach items="${mainView.postList}" var="poster" varStatus="status">
					<li><a href="${pageContext.servletContext.contextPath}/${blogInfo.ID}/${poster.CATEGORY_NO}/${poster.POST_NO}">${poster.TITLE}</a><span>${poster.REG_DATE}</span></li>
				</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${blogInfo.LOGO}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
			<c:forEach items="${mainView.categoryList}" var="vo"  varStatus="status">
				<li><a href="${pageContext.servletContext.contextPath}/${vo.ID}/${vo.CATEGORY_NO}">${vo.CATEGORY_NAME}</a></li>
			</c:forEach>	
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>