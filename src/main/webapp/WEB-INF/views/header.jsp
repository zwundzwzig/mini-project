<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>🦊사막여우🦊</title>
    <script src="resources/js/jquery-3.6.1.min.js"></script>
    <link href="resources/css/header.css" rel="stylesheet">
    <script>
      $(document).ready(function () {
        $('#search').click(function (e) {
          if ($('#keyword').val() == "") {
            e.preventDefault()
            alert("검색어를 입력해주세요!")
            return false;
          }
        })
      });
    </script>
</head>
<body>
<header class="header">
    <nav class="nav">
        <div class="menu">
            <%
                if (session.getAttribute("loginid") != null) {%>
            <a class="a" href="/"> ${nickname } 님 환영합니다!</a>
            <a class="a" href="/cart">장바구니</a>
            <a class="a" href="/mypage">내서재</a>
            <a class="a" href="/logout">로그아웃</a>
            <%} else {%>
            <a class="a" href="/join">회원가입</a>
            <a class="a" href="/login">로그인</a>
            <%} %>
        </div>
    </nav>
</header>
<header class="header2">
    <nav class="nav2">
        <a class="logo" href="/"><img src="resources/images/logo.jpg"></a>
        <div class="menu">
            <form action="search" method="get">
                <select id="search_select" name="search_select">
                    <option value="title">제목</option>
                    <option value="author">저자</option>
                    <option value="genre">장르</option>
                </select>
                <input type="text" placeholder="검색어 입력" name="keyword" id="keyword">
                <button type="submit" id="search">검색</button>
            </form>
        </div>
    </nav>
</header>
<header class="header3">
    <nav class="nav3">
        <div class="menu3">
            <a class="a" href="/">인기순</a>
            <a class="a" href="/">조회순</a>
            <a class="a" href="/">로맨스/로판</a>
            <a class="a" href="/">판타지/무협</a>
            <a class="a" href="/">BL</a>
        </div>
    </nav>
</header>
<hr class="end">
</body>
</html>