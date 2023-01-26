<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/viewer?episodeId=${ prevAndNext.prevId }">
		이전화
	</a>
	<a href="/viewer?episodeId=${ prevAndNext.nextId }">
		다음화
	</a>
	
	${ contents }
	
	<a href="/viewer?episodeId=${ prevAndNext.prevId }">
		이전화
	</a>
	<a href="/viewer?episodeId=${ prevAndNext.nextId }">
		다음화
	</a>
	
</body>
</html>