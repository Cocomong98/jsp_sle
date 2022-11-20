<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Member</h1>
<form action="addpost.jsp" method="post" enctype="multipart/form-data">
<table>
<tr><td>Github ID:</td><td><input type="text" name="userid"/></td></tr>
<tr><td>Name:</td><td><input type="text" name="username"/></td></tr>
<tr><td>Profile Photo:</td><td><input type="file" name="photo"/></td></tr>
<tr><td>Email:</td><td><input type="text" name="email"/></td></tr>
<tr><td>Gender:</td><td><input type="text" name="gender"/></td></tr>
<tr><td>Age:</td><td><input type="int" name="age"/></td></tr>
<tr><td>Introduce:</td><td><textarea cols="50" rows="5" name="detail"></textarea></td></tr>
<tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>