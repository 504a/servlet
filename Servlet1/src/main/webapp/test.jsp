<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPの基本</title>
</head>
<body>
<%-- コメント --%>
<%!
	//変数の宣言
	int cnt1 = 0;

	//メソッドの定義
	int adding(int num1,int num2) {
		return num1 + num2;
	}
%>
<%
	//変数宣言
	int cnt2 = 0;
%>
<p>データの出力</p>
<%= cnt1 %> :<%= cnt2 %><br>
<%= adding(cnt1,cnt2) %><br>
<%
	//処理
	cnt1++;
	cnt2++;
%>
</body>
</html>