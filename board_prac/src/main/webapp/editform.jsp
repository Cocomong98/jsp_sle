<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.dao.MemberDAO, com.example.bean.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Datas</title>
</head>
<body>

<%
	MemberDAO boardDAO = new MemberDAO();
	String id=request.getParameter("id");	
	MemberVO u=boardDAO.selectMember(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="<%=u.getSid() %>"/>
<table>
<tr><td>Github ID:</td><td><input type="text" name="title" value="<%= u.getUserid()%>"/></td></tr>
<tr><td>Name:</td><td><input type="text" name="writer" value="<%= u.getUsername()%>" /></td></tr>
<tr><td>Profile Photo:</td><td><input type="file" name="photo" value="${vo.getPhoto()}" />
	<c:if test="${vo.getPhoto() ne ''}"><br /><img src="${pageContext.request.contextPath}/upload/${vo.getPhoto()}" class="photo"></c:if></td></tr>
<tr><td>Email:</td><td><textarea cols="50" rows="5" name="content"><%= u.getEmail()%></textarea></td></tr>
<tr><td>Gender:</td><td><input type="text" name="gender" value="<%= u.getGender()%>" /></td></tr>
<tr><td>Age:</td><td><input type="text" name="age" value="<%= u.getAge()%>" /></td></tr>
<tr><td>Introduce:</td><td><textarea cols="50" rows="5" name="content"><%= u.getDetail()%></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Submit"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>