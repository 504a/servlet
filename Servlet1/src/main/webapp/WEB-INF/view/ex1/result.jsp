<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>結果表示</title>
</head>
<body>
    <p><c:out value="${name}"/></p>
    <p>${gender}</p>
    <p>${age}</p>
    <p><a href="./Ex1">戻る</a></p>
</body>
</html>
