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
<Link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/jblog.css'/>">
<script src="<c:url value='/assets/js/jquery/jquery-1.9.0.js'/>"></script>
<script>
$(function(){
	
	var Checkagree= false;
	var CheckId = false;
	
	$('#join_submit').on('click',function()
	{
 		if($("#agree-prov").is(":checked") == false)
 		{
 			alert("서비스약관에 동의해주세요.");
 			return false;
 		}
 		console.log("test");
 		$("#join-form").submit();
	});
	 // 처음에 등록 활성화 끄기
	 // $('#join_submit').prop("disabled", true).css("background-color", "#aaaaa");
	 
	 
	  $('#agree-prov').on('click',function()
	  {
		  	CheckId = $(this).prop('checked');
		  	if($("#agree-prov").is(":checked") == false)
	 		{
	 			alert("서비스약관에 동의해주세요.");
	 		}
	  });
	  
	$('#blog-id').change(function()
	{
		$('#btn-checkemail').show();
		$('#img-checkemail').hide();
	});
	
	$('#btn-checkemail').click(function(){
		var ID = $('#blog-id').val();
		console.log(ID);
		if(ID == '')
		{
			return;
		}
			
		/* ajax 통신 */
		$.ajax({
			url: "${pageContext.servletContext.contextPath }/user/api/checkId?ID=" + ID, 
			type: "get", 
			dataType: "json",
			data: "",
			success: function(response){
				if(response.result != "success"){
					console.log(response);
					//console.error(response.message);
					return;
				}
				
				if(response.data == true)
				{
					alert('이미 존재하는 아이디입니다.\n다른 아이디를 사용해 주세요.');
					$("#blog-id").focus();
					$("#blog-id").val("");
					return;
				}
				
				$('#btn-checkemail').hide();
				$('#img-checkemail').show();
				CheckId = true;
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
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<c:import url="/WEB-INF/views/includes/main_nav.jsp"/>
		<form:form modelAttribute="userVo" class="join-form" id="join-form" 
			name="joinForm" method="post" action="${pageContext.servletContext.contextPath }/user/join">
			<label class="block-label" for="name">이름</label>
			<input id="name"name="NAME" type="text" value="">
			<spring:hasBindErrors name="userVo">
				 <c:if test="${errors.hasFieldErrors('NAME') }">
					<p style="font-weight:bold; color:red; text-align:left; padding:0">
					  	<spring:message 
							code="${errors.getFieldError( 'NAME' ).codes[0] }" 				     
						    text="${errors.getFieldError( 'NAME' ).defaultMessage }" />
					</p> 
			   	</c:if>
			</spring:hasBindErrors>
			
			<label class="block-label" for="ID">아이디</label>
			<form:input id="ID" path="ID" />
			<input id="btn-checkemail" type="button" value="id 중복체크">
			<img id="img-checkemail" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
			<p style="font-weight:bold; color:#f00; text-align:left; padding:0; margin:0 ">
				<form:errors path="ID" />
			</p>
			
			<label class="block-label" for="PASSWORD">패스워드</label>
			<form:password id="password" path="PASSWORD" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input id="join_submit" type="button" value="가입하기">

		</form:form>
	</div>
</body>
</html>
