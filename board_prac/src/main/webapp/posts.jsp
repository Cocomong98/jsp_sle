<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.MemberDAO, com.example.bean.MemberVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLE</title>
<style>
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#list td, #list th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align:center;
}
#list tr:nth-child(even){background-color: #B6FFA3;}
#list tr:hover {background-color: #238F14;}
#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #4EB044;
  color: white;
}
</style>
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deletepost.jsp?id=' + id;
	}
</script>
</head>
<body>
<h1>SEL원 현황</h1>
<%
	MemberDAO memberDAO = new MemberDAO();
	String id=request.getParameter("id");

	List<MemberVO> list = memberDAO.listMember();
	request.setAttribute("list",list);
%>
<table id="list" width="90%">
<tr>
	<th>No</th>
	<th>Github ID</th>
	<th>Name</th>
	<th>Profile Photo</th>
	<th>Email</th>
	<th>Gender</th>
	<th>Age</th>
	<th>Regdate</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${list}" var="u" varStatus="status">
	<tr>
		<td>${u.getSid()}</td>
		<td>${u.getUserid()}</td>
		<td>${u.getUsername()}</td>
		<td><c:if test="${u.getPhoto() ne ''}"><br />
			<img src="${pageContext.request.contextPath}/upload/${u.getPhoto()}" class="Photo"></c:if></td>
		<td>${u.getEmail()}</td>
		<td>${u.getGender()}</td>
		<td>${u.getAge()}</td>
		<td>${u.getRegdate()}</td>
		<td><a href="editform.jsp?id=${u.getSid()}">Edit</a></td>
		<td><a href="javascript:delete_ok('${u.getSid()}')">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><a href="addpostform.jsp">Add New Members!</a>
</body>
</html>