<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>웹뷰어</title>
    <style>
		 p {
		  text-align: center;
		}
		table{
			table-layout: fixed;
			width:100%;
			text-align:center
		}
		#mypage{
			text-align:center;
		}
		#contents{
			width: 80%;
			margin-left: auto;
			margin-right: auto;
		}
	</style>
</head>
<body>
<jsp:include page="viewerheader.jsp">
    <jsp:param value="false" name="login"/>
</jsp:include>
	<p id="toMypage">
		<a href="/mypage">내서재로 가기</a><br>
	</p>
	<table>
	<tr>
	<td>
	<c:if test="${not empty prevAndNext.prevId}">
		<a href="/viewer?episodeId=${ prevAndNext.prevId }" class="prev">
		    이전화
		</a>
	</c:if>
	</td>
	<td>
	<c:if test="${not empty prevAndNext.nextId}">
		<a href="/viewer?episodeId=${ prevAndNext.nextId }" class="next">
		    다음화
		</a>
	</c:if>
	</td>
	</tr>
	</table>
	<br>
	<p id="contents">${ contents }<p>
	<br>
		<table>
	<tr>
	<td>
	<c:if test="${not empty prevAndNext.prevId}">
		<a href="/viewer?episodeId=${ prevAndNext.prevId }" class="prev">
		    이전화
		</a>
	</c:if>
	</td>
	<td>
	<c:if test="${not empty prevAndNext.nextId}">
		<a href="/viewer?episodeId=${ prevAndNext.nextId }" class="next">
		    다음화
		</a>
	</c:if>
	</td>
	</tr>
	</table>
<jsp:include page="footer.jsp"/>
</body>
</html>