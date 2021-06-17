<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員情報確認</title>
    <link rel="stylesheet" href="./css/skyblue.css">
    <link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
    <link rel="stylesheet" href="./css/helper.css">
</head>
<body>
    <div class="bg-success padding-y-5">
        <div class="container padding-y-5 text-center">
            <strong>会員情報確認</strong>
        </div>
    </div>
    <div class="padding-y-5">
        <div style="width: 40%" class="container padding-y-5">
            <table border="1" class="table">
                <tr>
                    <th><span class="icon-smile pe-2x pe-va"></span>&nbsp;ユーザ名</th>
                    <td>
                        <c:out value="${userName}" />
                    </td>
                </tr>
                <tr>
                    <th><span class="icon-note pe-2x pe-va"></span>&nbsp;パスワード</th>
                    <td>
                        <c:out value="${pass}" />
                    </td>
                </tr>
                <tr>
                    <th><span class="icon-users pe-2x pe-va"></span>&nbsp;性別</th>
                    <td>
                        <c:out value="${gender}" />
                    </td>
                </tr>
                <tr>
                    <th><span class="icon-joy pe-2x pe-va"></span>&nbsp;趣味</th>
                    <td>
                        <c:out value="${hobbyList}" />
                    </td>
                </tr>
                <tr>
                    <th><span class="icon-bandaid pe-2x pe-va"></span>&nbsp;血液型</th>
                    <td>
                        <c:out value="${blood}" />
                    </td>
                </tr>
                <tr>
                    <th><span class="icon-note2 pe-2x pe-va"></span>&nbsp;備考</th>
                    <td>${remarks}</td>
                </tr>
                <tr>
                    <td colspan="2" class="text-right"><a href="./Ex5">戻る</a></td>
                </tr>
            </table>
        </div>
    </div>

</body>
</html>
