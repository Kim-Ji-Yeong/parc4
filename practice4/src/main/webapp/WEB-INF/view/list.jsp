<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<a href="/write">글쓰기</a>
	<table>
		<tr>
			<td>no</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>

				<td>${item.iboard}</td>
				<td><a href="/detail?pk=${item.iboard}">${item.title}</a></td>
				<td>${item.regdt}</td>
		</c:forEach>

		</tr>
	</table>
</body>
</html>