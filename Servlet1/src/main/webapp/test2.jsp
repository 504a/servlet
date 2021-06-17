<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map,java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Map<String,String> map = new HashMap<>();
map.put("mapKey","TEST!!");
map.put("apple","りんご!!");
request.setAttribute("mapData",map);
%>

${mapData.apple}

</body>
</html>