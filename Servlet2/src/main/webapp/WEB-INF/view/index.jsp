<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>一覧表示</title>
</head>
<body>
    <form action="./CreateForm" method="get">
        <button type="submit">追加</button>
    </form>
    <table>
        <c:forEach var="user" items="${list}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.gender}"/></td>
                <td><c:out value="${user.age}"/></td>
                <td>
                    <form action="./DeleteConfirm" method="post">
                        <input type="hidden" name="id" value="<c:out value="${user.id}"/>">
                        <button type="submit">削除</button>
                    </form>
                </td>
                <td>
                    <form action="./UpdateForm" method="post">
                        <input type="hidden" name="id" value="<c:out value="${user.id}"/>">
                        <button type="submit">更新</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>