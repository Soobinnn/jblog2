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
<script src="<c:url value='/assets/js/jquery/jquery-1.9.0.js'/>"></script>
<script>
$(function(){
	
	function appendCategory(list)
	{
		$(".category_list").append("<tr><td>"+list.category_NO+"</td><td>"+list.category_NAME+"</td><td>포스트수</td><td>"
				+list.description+"</td><td><img id='category_del' name='"+list.category_NO
				+"' src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td></tr>");	
	}
	
	// 카테고리 삭제
	$(document).on("click","#category_del",function(event)
	{
		var category_no = $(this).attr('name');
		var param = "CATEGORY_NO="+category_no	
	});
	
	// 카테고리 등록 & 리스트 불러오기(ajax)
	$('#category_submit').click(function()
	{
		var CATEGORY_NAME = $('#CATEGORY_NAME').val();
		var DESCRIPTION = $('#DESCRIPTION').val();
		var ID = "${sessionScope.authUser.ID}";
		
		if(CATEGORY_NAME == '' || DESCRIPTION=='')
		{
			return;
		}
		
		var category = "CATEGORY_NAME="+CATEGORY_NAME+"&DESCRIPTION="+DESCRIPTION+"&ID="+ID;
		
		/* ajax 통신 */
		$.ajax({
			url: "${pageContext.servletContext.contextPath }/blog/api/categoryWrite", 
			type: "post", 
			dataType: "json",
			data: category,
			success: function(response){
				if(response.result != "success"){
					console.log(response);
					//console.error(response.message);
					return;
				}
				//console.log(response);
				//console.log(response.data);
				
				$(".category_list").empty();
				var categorylist;
		        for(var i in response.data)
		        {
		        	categorylist = response.data[i];	 
		        	appendCategory(categorylist);
		        }
		          
				if(response.data == true)
				{
					alert('이미 존재하는 아이디입니다.\n다른 아이디를 사용해 주세요.');
					$("#blog-id").focus();
					$("#blog-id").val("");
					return;
				}
				$('#CATEGORY_NAME').val("");
				$('#DESCRIPTION').val("");
			},
			error: function(xhr, error){
				console.error("error:" + error)
			}
		});
		
	});	
});
</script>
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/includes/blog_nav.jsp'/>
		<div id="wrapper">
			<div id="content" class="full-screen">
			<c:import url='/WEB-INF/views/includes/blog_admin_nav.jsp'/>
		      	<table class="admin-cat">
		      	<thead>
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      	</thead>
		      	<tbody class="category_list">
		      	<c:forEach items="${categoryList}" var="vo" varStatus="status">
		      		<tr>
						<td>${vo.CATEGORY_NO}</td>
						<td>${vo.CATEGORY_NAME}</td>
						<td>포스트수</td>
						<td>${vo.DESCRIPTION}</td>
						<td><img id="category_del" name="${vo.CATEGORY_NO}" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
				</c:forEach>  
		      	</tbody>
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input id="CATEGORY_NAME" type="text" name="CATEGORY_NAME"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input id="DESCRIPTION" type="text" name="DESCRIPTION"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input id="category_submit" type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
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