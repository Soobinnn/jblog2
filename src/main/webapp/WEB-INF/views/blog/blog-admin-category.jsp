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
	$('#category_submit').click(function(){
		var CATEGORY_NAME = $('#CATEGORY_NAME').val();
		var DESCRIPTION = $('#DESCRIPTION').val();
		var ID = "${sessionScope.authUser.ID}";
		console.log(CATEGORY_NAME);
		console.log(DESCRIPTION);
		
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
			data: "category",
			success: function(response){
				if(response.result != "success"){
					console.log(response);
					//console.error(response.message);
					return;
				}
				/*  $("#chatArea").empty();
		        	var messagelist;
		        	var _chatRoomId; 
		        	 for(var i in data)
		        	 {
		        		 messagelist = data[i];	 
		        		 _chatRoomId = data[i].chatroom_id;
		        		 appendMessage(messagelist);
		        	 }
		        	 lookRoom = _chatRoomId;
		        	// 채팅방 위에 닉네임
		     		$("#chat_info_nick").empty();
		     		$("#chat_info_nick").append("<span id='chat_info_receiver'>"+follow+"</span>");
		     		$("#chat_info_img").empty();
		     		$("#chat_info_img").append("<img id='target_img' src='"+_profile+"'width='60px' height='60px'>");
		         } */
				if(response.data == true)
				{
					alert('이미 존재하는 아이디입니다.\n다른 아이디를 사용해 주세요.');
					$("#blog-id").focus();
					$("#blog-id").val("");
					return;
				}
				$('#CATEGORY_NAME').empty();
				$('#DESCRIPTION').empty();
			},
			error: function(xhr, error){
				console.error("error:" + error)
			}
		});
		
		console.log(ID);
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
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
					<tr>
						<td>3</td>
						<td>미분류</td>
						<td>10</td>
						<td>카테고리를 지정하지 않은 경우</td>
						<td><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>  
					<tr>
						<td>2</td>
						<td>스프링 스터디</td>
						<td>20</td>
						<td>어쩌구 저쩌구</td>
						<td><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
					<tr>
						<td>1</td>
						<td>스프링 프로젝트</td>
						<td>15</td>
						<td>어쩌구 저쩌구</td>
						<td><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>					  
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