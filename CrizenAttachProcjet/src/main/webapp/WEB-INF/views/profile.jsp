<%@page import="com.song.woo.model.AttachInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%
 AttachInfo dto=(AttachInfo)request.getAttribute("dto");
%>
</head>
<body>
<img src="C:\my\<%=dto.getNmFile()%>">
</body>
</html>