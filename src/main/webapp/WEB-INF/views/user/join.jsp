<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>🦊회원가입🦊</title>
    <style type="text/css">
      body {
        margin: 0;
        position: relative;
      }

      .main {
        position: relative;
        margin: 0 auto;
        background-color: rgb(240, 240, 240);
        height: 380px;
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

      tr, th{
        padding: 10px;
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

      .main .lower input[type=reset] {
        height: 30px;
        border-radius: 5px;
        background: #012A5E;
        color: white;
        cursor: pointer;
      }

      .main .lower input[type=reset]:hover {
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
        <h1>회원가입🦊</h1>
        <form action="<%=request.getContextPath() %>/join" enctype="multipart/form-data"
              method="POST">
            <table>
                <tr>
                    <th><label for="nickname">닉네임 입력 : </label></th>
                    <td><input type="text" id="nickname" name="nickname" required></td>
                </tr>
                <tr>
                    <th><label for="password"> 비밀번호 입력 : </label></th>
                    <td><input type="password" id="password" name="password" required></td>
                </tr>
                <tr>
                    <th><label for="age"> 나이 입력 : </label></th>
                    <td><input type="text" id="age" name="age" required></td>
                </tr>
                <tr>
                    <th><input type="submit" value="회원가입"></th>
                    <td><input type="reset" value="취소"></td>
                </tr>
            </table>
        </form>
    </div>
</main>

<jsp:include page="../footer.jsp"/>

</body>

</html>
