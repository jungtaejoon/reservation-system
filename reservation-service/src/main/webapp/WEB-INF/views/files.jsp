<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file등록 폼</title>
</head>
<body>
<form method="post" action="/images" enctype="multipart/form-data">
    title : <input type="text" name="title"><br>
    productId : <input type="text" name="productId"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="등록">
</form>

<form method="post" action="/comments/{commentId}/files" enctype="multipart/form-data">
    title : <input type="text" name="title"><br>
    commentId : <input type="text" name="commentId"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="등록">
</form>
</body>
</html>