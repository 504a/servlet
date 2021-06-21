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
            <td><c:out value="${member.name}"/></td>
            <td><c:out value="${member.zip}"/></td>
            <td><c:out value="${member.address1}"/></td>
            <td><c:out value="${member.address2}"/></td>
            <td><c:out value="${member.phone}"/></td>
            <td><c:out value="${member.remarks}"/></td>
        </tr>
    </table>
    <form action="./Delete" method="post">
        <input type="hidden" name="id" value="<c:out value="${member.id}"/>">
        <input type="hidden" name="token" value="${sessionScope.token}"/>
	    <button type="submit">削除</button>
    </form>
    <form action="./" method="get">
	    <button type="submit">一覧に戻る</button>
    </form>
</body>
</html>