<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>file등록 폼</title>
</head>
<body>
<form method="post" action="/files/product" enctype="multipart/form-data">
프로덕트ID: <input type="text" name="productId"><br>
	<input type="file" name="file"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="등록">
</form>
</body>
</html>