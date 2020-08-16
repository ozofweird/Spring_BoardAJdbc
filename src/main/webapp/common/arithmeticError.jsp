<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page  isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>기본 에러 화면</title>
</head>
<body bgcolor="#ffffff" text="#000000">
	<!-- 타이틀 시작 -->
	<table style="border: 1px; margin: auto; border-collapse: collapse; 
			border-spacing: 0px; width: 100%;">
			<tr>
				<td align="center" bgcolor="orange"><b>기본 에러 화면입니다.</b></td>
			</tr>
	</table>
	<br>
	<!-- 에러 메시지 -->
	<table style="border: 1px; margin: auto; border-collapse: collapse;	
			border-spacing: 0px; width: 100%;">
			<tr>
				<td align="center">
				<br><br><br><br><br>
				Message: ${exception.message }
				<br><br><br><br><br>
				</td>
			</tr>
	</table>
</body>
</html>