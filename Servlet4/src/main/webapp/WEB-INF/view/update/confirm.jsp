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
            <td><c:out value="${member.name}"/></td>
            <td><c:out value="${member.zip}"/></td>
            <td><c:out value="${member.address1}"/></td>
            <td><c:out value="${member.address2}"/></td>
            <td><c:out value="${member.phone}"/></td>
            <td><c:out value="${member.remarks}"/></td>
        </tr>
    </table>	
    <form action="./Update" method="post">
        <input type="hidden" name="token" value="${sessionScope.token}"/>
        <button type="submit">更新</button>
    </form>
    <form action="./UpdateForm" method="post">
        <button type="submit">入力に戻る</button>
    </form>
</body>
</html>