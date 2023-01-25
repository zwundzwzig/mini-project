<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<h1>내 서재</h1>
	<table>
		<thead>
			<th>소설제목</th>
			<th>회차</th>
			<th>회차제목</th>
			<th>열람</th>
		</thead>
		<tbody>
			<c:forEach items="${purchases}" var="purchase">
				<tr>
				<td>${ purchase.novelTitle }</td>
				<td>${ purchase.sequence }</td>
				<td>${ purchase.episodeTitle }</td>
				<td><input type="button" data-episode-id="${ purchase.episodeId }" value="열람"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>