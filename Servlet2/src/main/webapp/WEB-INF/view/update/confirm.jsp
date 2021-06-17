<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新確認</title>
</head>
<body>
    <table>
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.gender}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
    </table>	
    <form action="./Update" method="post">
        <button type="submit">更新</button>
    </form>
    <form action="./UpdateForm" method="post">
        <button type="submit">入力に戻る</button>
    </form>
</body>
</html>