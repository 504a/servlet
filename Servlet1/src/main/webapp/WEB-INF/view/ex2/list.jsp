<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
</head>
<body>
	<table>
		<tr>
			<th>名前</th><th>性別</th><th>年齢</th>
		</tr>
		<c:forEach var="person" items="${list}">
		<tr>
			<td><c:out value="${person.name}"/></td>
			<td><c:out value="${person.gender}"/></td>
			<td><c:out value="${person.age}"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>