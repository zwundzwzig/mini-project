<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>🦊로그인🦊</title>
    <style type="text/css">
      body {
        margin: 0;
        position: relative;
      }

      .main {
        position: relative;
        margin: 0 auto;
        background-color: rgb(240, 240, 240);
        height: 330px;
      }

      .main .lower {
        position: relative;
        display: grid;
        justify-content: center;
        width: 90%;
        top: 30px;
        bottom: 30px;
        padding: 20px 10px 20px 10px;
        margin: 0 auto;
        border: 2px solid #012A5E;
        background-color: white;
        text-align: center;
      }

      .main .lower input[type=submit] {
        height: 30px;
        border-radius: 5px;
        background: #012A5E;
        color: white;
        cursor: pointer;
      }

      .main .lower input[type=submit]:hover {
        border-color: lightslategray;
        background: lightslategray;
      }

    </style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../header.jsp">
    <jsp:param value="false" name="login"/>
</jsp:include>

<main class="main">
    <div class="lower">
        <h1>로그인🦊</h1><br>
        <form action="<%=request.getContextPath() %>/login" method="post">
            아이디입력:<input type=text name="nickname"><br><br>
            암호입력:<input type=password name="password"><br><br>
            <input type=submit value="로그인">
        </form>
    </div>
</main>

<jsp:include page="../footer.jsp"/>

</body>

</html>
