<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>削除確認</title>
</head>
<body>
    <table>
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.gender}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
    </table>
    <form action="./Delete" method="post">
        <input type="hidden" name="id" value="<c:out value="${user.id}"/>">
	    <button type="submit">削除</button>
    </form>
    <form action="./" method="get">
	    <button type="submit">一覧に戻る</button>
    </form>
</body>
</html>