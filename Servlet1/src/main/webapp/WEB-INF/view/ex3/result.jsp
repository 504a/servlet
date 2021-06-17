<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
        crossorigin="anonymous">
    <title>結果表示</title>
</head>
<body>
    <div class="container">
        <!-- https://getbootstrap.jp/docs/4.5/content/tables/ -->
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">名前</th>
                    <th scope="col">クラス</th>
                    <th scope="col">国語</th>
                    <th scope="col">数学</th>
                    <th scope="col">英語</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${name}" />
                    </td>
                    <td>
                        <c:out value="${cl}" />
                    </td>
                    <td>
                        <c:out value="${jap}" />
                    </td>
                    <td>
                        <c:out value="${math}" />
                    </td>
                    <td>
                        <c:out value="${eng}" />
                    </td>
                </tr>

            </tbody>
        </table>
        <a class="btn btn-primary" href="./Ex3">戻る</a>
    </div>

</body>
</html>
