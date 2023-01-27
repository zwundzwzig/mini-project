<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <style>
		h1 {
		  text-align: center;
		}
		table{
			    table-layout: fixed;
			    width:100%;
			    margin-left: auto;
			    margin-right: auto;
		      	border-collapse: collapse;
  				border: 1px solid grey;
  				text-align: center;
		}
		thead tr{
        	background-color: #F5F5DC;
        	border: 1px solid grey;
		}
		tbody tr{
			height: 32px;
		}
	</style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="header.jsp">
    <jsp:param value="false" name="login"/>
</jsp:include>
<h1>내 서재</h1>
<c:if test="${empty purchases }">
	<h1>구매하신 소설이 없어요ㅜ</h1>
</c:if>

<c:if test="${ not empty purchases }">
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
            <td><a href="/viewer?episodeId=${purchase.episodeId}" target="_blank">열람</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
</c:if>
<jsp:include page="footer.jsp"/>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script>
</script>
</body>
</html>