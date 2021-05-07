<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>제목</td>
			<td>내용</td>
			<td>작성일</td>
		</tr>
		<tr>
			<td>${data.title}</td>
			<td>${data.ctnt}</td>
			<td>${data.regdt}</td>
		</tr>
	</table>
	<a href="/mod?iboard=${param.pk}">수정</a>
	<a href="/del?iboard=${param.pk}">삭제</a>
</body>
</html>