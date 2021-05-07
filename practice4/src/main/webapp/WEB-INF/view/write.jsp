<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/write" method="post">
		<div>
			<input type="text" name="title">
		</div>
		<div>
			<textarea rows="20" cols="20" name="ctnt"></textarea>
		</div>
		<input type="submit" value="등록"> <input type="reset">
	</form>
</body>
</html>