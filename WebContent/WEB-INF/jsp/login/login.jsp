<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-3.1.0.js">
    
</script>

<script>
	$(document).ready(function(){
		alert("오잉");
		
		$("#btnLogin").click(function(){
			var userid = $("#userid").val();
			var passwd = $("#passwd").val();
			
			if(userid == ""){
				alert("아이디를 입력해주세요");
				$("#userid").focus();
				return;
			}
			
			var exp = /[a-z0-9]$/;
			if(!exp.test(userid)){
				alert("영문자와 숫자만 입력 가능합니다.");
				$("#userid").focus();
				return;
			}
			
			if(passwd == ""){
				alert("비밀번호를 입력해주세요.");
				$("#passwd").focus();
				return;
			}
			
			var data = "userid=" + userid + "&passwd=" + passwd;
			alert(userid+passwd);
			$.ajax({
				type: "post",
				data: data,
				url: "login.do",
				success: function(value){
					$("#result").html(value);
				}
			});
		});
	});
	
	
</script>

</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" id="passwd"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="button" value="로그인" id="btnLogin">
				</td>
			</tr>
		</table>
		<div id="result">로그인 결과 출력 영역</div>
	</div>
</body>
</html>