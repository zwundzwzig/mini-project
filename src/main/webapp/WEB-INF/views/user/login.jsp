<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../header.jsp">
    <jsp:param value="false" name="login"/>
</jsp:include>

<main class="main">
    <h1>로그인폼</h1>
    <form action="<%=request.getContextPath() %>/login" method="post">
        아이디입력:<input type=text name="nickname"><br>
        암호입력:<input type=password name="password"><br>
        <input type=submit value="로그인">
    </form>
</main>

<jsp:include page="../footer.jsp"/>

</body>

</html>
