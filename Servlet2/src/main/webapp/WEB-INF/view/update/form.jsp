<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー更新</title>
</head>
<body>
	<!-- bootStrapの適用なしバージョン -->
    <form action="./UpdateConfirm" method="post">
        <table>
            <tr>
                <th><label for="name">名前</label></th>
                <td><input type="text" name="name" id="name" value="${user.name}"></td>
             </tr>
            <tr>
                <th>性別</th>
                <td>
                    <label><input type="radio" name="gender" value="男" <c:if test="${genderMap.male}">checked</c:if>><span>男</span></label>
                    <label><input type="radio" name="gender" value="女" <c:if test="${genderMap.female}">checked</c:if>><span>女</span></label>
                </td>
            </tr>
            <tr>
                <th><label for="age">年齢</label></th>
                <td><input type="text" name="age" id="age" value="${user.age}"></td>
           	</tr>
        </table>
        <input type="hidden" name="id" id="id" value="${user.id}">
        <button type="submit">更新</button>
    </form>
    <form action="./" method="get">
	    <button type="submit">一覧に戻る</button>
    </form>  
</body>
</html>