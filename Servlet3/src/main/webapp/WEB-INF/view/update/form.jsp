<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <td><input type="text" name="name" id="name" value="${member.name}"></td>
            </tr>
      <tr>
          <th><label for="zip">郵便番号</label></th>
          <td><input type="text" name="zip" id="zip" value="${member.zip}"></td>
       </tr>
       <tr>
          <th><label for="address1">住所１</label></th>
          <td><input type="text" name="address1" id="address1" value="${member.address1}"></td>
       </tr>
       <tr>
          <th><label for="address2">住所２</label></th>
          <td><input type="text" name="address2" id="address2" value="${member.address2}"></td>
       </tr>
       <tr>
          <th><label for="phone">電話番号</label></th>
          <td><input type="text" name="phone" id="phone" value="${member.phone}"></td>
       </tr>
       <tr>
          <th><label for="remaeks">備考</label></th>
          <td><input type="text" name="remarks" id="remarks" value="${member.remarks}"></td>
       </tr>

        </table>
        <input type="hidden" name="id" id="id" value="${member.id}">
        <input type="hidden" name="token" value="${sessionScope.token}" />

        <button type="submit">更新</button>
    </form>
    <form action="./" method="get">
        <button type="submit">一覧に戻る</button>
    </form>
</body>
</html>
