<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<script src="<%=request.getContextPath() %>resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="header.jsp">
    <jsp:param value="false" name="login"/>
</jsp:include>

<form action="<%=request.getContextPath() %>/onenovelpage">
상세페이지

</form>
<jsp:include page="footer.jsp"/>
</body>
</html>