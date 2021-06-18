<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>追加確認</title>
</head>
<body>
    <table>
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.gender}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
    </table>	
    <form action="./Create" method="post">
        <input type="hidden" name="token" value="${sessionScope.token}"/>    
        <button type="submit">登録</button>
    </form>
    <form action="./CreateForm" method="get">
        <button type="submit">入力に戻る</button>
    </form>
</body>
</html>