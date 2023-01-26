<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>웹뷰어</title>
</head>
<body>
	<a href="/mypage">내서재로 가기</a>
	<c:if test="${not empty prevAndNext.prevId}">
		<a href="/viewer?episodeId=${ prevAndNext.prevId }">
		    이전화
		</a>
	</c:if>
	<c:if test="${not empty prevAndNext.nextId}">
		<a href="/viewer?episodeId=${ prevAndNext.nextId }">
		    다음화
		</a>
	</c:if>
	<br>
${ contents }
	<br>
	<c:if test="${not empty prevAndNext.prevId}">
		<a href="/viewer?episodeId=${ prevAndNext.prevId }">
		    이전화
		</a>
	</c:if>
	<c:if test="${not empty prevAndNext.nextId}">
		<a href="/viewer?episodeId=${ prevAndNext.nextId }">
		    다음화
		</a>
	</c:if>

</body>
</html>