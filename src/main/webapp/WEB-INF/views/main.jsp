<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>🦊사막여우🦊</title>
    <script src="resources/js/jquery-3.6.1.min.js"></script>
    <link href="resources/css/main.css" rel="stylesheet">
</head>
<body>
<!-- 상단바  -->
<jsp:include page="header.jsp">
    <jsp:param value="false" name="login"/>
</jsp:include>
<main class="main">
    <section class="upper">
        <div class="advertisement">
            <!-- 아직 사진 미완 :) -->
        </div>
    </section>
    <section class="lower">
        <div class="categoryList">
            <div class="category">
                <div class="top">
                    <div class="title">NEW! 신작</div>
                    <div class="btn">
                        <input type="button" value='<'>&nbsp;
                        <input type="button" value='>'>
                    </div>
                </div>
                <div class="novelList">

                </div>
            </div>
            <div class="category">
                <div class="top">
                    <div class="title">로맨스/로판 BEST</div>
                    <div class="btn">
                        <input type="button" value='<'>&nbsp;
                        <input type="button" value='>'>
                    </div>
                </div>
                <div class="novelList">

                </div>
            </div>
            <div class="category">
                <div class="top">
                    <div class="title">판타지/무협 BEST</div>
                    <div class="btn">
                        <input type="button" value='<'>&nbsp;
                        <input type="button" value='>'>
                    </div>
                </div>
                <div class="novelList">
                </div>
            </div>
            <div class="category">
                <div class="top">
                    <div class="title">BL BEST</div>
                    <div class="btn">
                        <input type="button" value='<'>&nbsp;
                        <input type="button" value='>'>
                    </div>
                </div>
                <div class="novelList">
                </div>
            </div>
        </div>
    </section>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>