<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>team4-bookstore</title>
    <script src="resources/js/jquery-3.6.1.min.js"></script>
    <link href="resources/css/main/searchResult.css" rel="stylesheet">
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../header.jsp">
    <jsp:param value="false" name="login"/>
</jsp:include>
<main class="main">
    <section class="section1">
        <div class="right">
            <div class="menu1">
                <div class="top">
                    <div class="title">검색결과</div>
                </div>
                <div class="bottom1" id="month_box">
                    <c:forEach items="${searchresult }" var="novel" varStatus="b">
                        <c:set var="img_path" value="resources/images/novel/"/>
                        <c:set var="img_src" value="${img_path }${novel.id }.jpg"/>
                        <div class="item">
                            <img src="${img_src }">
                            <div class="description">
                                <div class="book_name"><a
                                        href="productdetail/${novel.id}">${novel.title }</a>
                                </div>
                                <div class="writer">${novel.title }</div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</main>

<jsp:include page="../footer.jsp"/>

</body>

</html>