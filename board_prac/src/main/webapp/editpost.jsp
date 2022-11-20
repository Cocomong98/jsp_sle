<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.MemberDAO"%>
<%@ page import="com.example.bean.MemberVO" %>
<%@ page import="com.example.util.FileUpload" %>

<% request.setCharacterEncoding("utf-8"); %>


<jsp:setProperty property="*" name="u"/>s

<%
	MemberDAO boardDAO = new MemberDAO();
	FileUpload upload = new FileUpload();
	MemberVO u = upload.uploadPhoto(request);

	int i=boardDAO.updateMember(u);
	response.sendRedirect("posts.jsp");
%>