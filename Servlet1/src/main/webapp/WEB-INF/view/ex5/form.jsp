<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員情報入力フォーム</title>
    <link rel="stylesheet" href="./css/skyblue.css">
    <link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
    <link rel="stylesheet" href="./css/helper.css">
</head>
<body>
    <div class="bg-success padding-y-5">
        <div class="container padding-y-5 text-center">
            <strong>会員情報入力フォーム</strong>
        </div>
    </div>
    <div class="padding-y-5">
        <div style="width: 40%" class="container padding-y-5">
            <form action="./Ex5" method="post">
                <table border="1" class="table">
                    <tr>
                        <th><label for="userName"><span class="icon-smile pe-2x pe-va"></span>&nbsp;ユーザ名</label>
                        </th>
                        <td><input type="text" name="userName" id="userName" class="form-control"
                                value="${sessionScope.userName}"></td>
                    </tr>
                    <tr>
                        <th><label for="pass"><span class="icon-note pe-2x pe-va"></span>&nbsp;パスワード</label>
                        </th>
                        <td><input type="password" name="pass" id="pass" class="form-control"></td>
                    </tr>
                    <tr>
                        <th><span class="icon-users pe-2x pe-va"></span>&nbsp;性別</th>
                        <td>
                            <label class="fancy-radio"><input type="radio" name="gender" value="male" <c:if
                                    test="${sessionScope.genderMap.male}">checked</c:if>><span>男</span></label>
                            <label class="fancy-radio"><input type="radio" name="gender" value="female" <c:if
                                    test="${sessionScope.genderMap.female}">checked</c:if>
                                ><span>女</span></label>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="icon-joy pe-2x pe-va"></span>&nbsp;趣味</th>
                        <td>
                            <label class="fancy-checkbox"><input type="checkbox" name="hobby" value="book" <c:if
                                    test="${sessionScope.hobbyMap.book}">checked</c:if>><span>読書</span></label>
                            <label class="fancy-checkbox"><input type="checkbox" name="hobby" value="music"
                                    <c:if test="${sessionScope.hobbyMap.music}">checked</c:if>
                                ><span>音楽鑑賞</span></label>
                            <label class="fancy-checkbox"><input type="checkbox" name="hobby" value="travel"
                                    <c:if test="${sessionScope.hobbyMap.travel}">checked</c:if>
                                ><span>旅行</span></label>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="icon-bandaid pe-2x pe-va"></span>&nbsp;血液型</th>
                        <td>
                            <select name="blood" class="form-control">
                                <option value="A" <c:if test="${sessionScope.bloodMap.TypeA}">selected</c:if>>A型
                                <option value="B" <c:if test="${sessionScope.bloodMap.TypeB}">selected</c:if>>B型
                                <option value="O" <c:if test="${sessionScope.bloodMap.TypeO}">selected</c:if>>O型
                                <option value="AB" <c:if test="${sessionScope.bloodMap.TypeAB}">selected</c:if>
                                    >AB型
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="icon-note2 pe-2x pe-va"></span>&nbsp;備考</th>
                        <td><textarea rows="5" cols="20" name="remarks"
                                class="form-control">${sessionScope.remarks}</textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="text-right"><input type="submit" value="送信" class="btn"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
