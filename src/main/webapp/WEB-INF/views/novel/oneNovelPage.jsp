<%@page import="episodes.EpisodesDTO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<script src="<%=request.getContextPath() %>resources/js/jquery-3.6.1.min.js"></script>
<script>
/* 체크박스 전체 선택 */
$(document).ready(function(){
	$("#all").click(function(){
		if($("#all").prop("checked")){
			$("input[name=check]").prop("checked", true);
		} else{
			$("input[name=check]").prop("checked", false);
		} 
	});
	
	//체크된 소설 장바구니 넘기기
	$("#cart").click(function(e){
		var chk = confirm("장바구니?");
		if(chk){
			alert("담았다리");
			$("form").attr("action","/cartIn");
// 			document.getElementById("f").submit();
		}else{
			e.preventDefault();
		}
	});
	
	$("#buy").click(function(e){
		var chk = confirm("구매하시겠습니까?");
		if(chk){
			alert("구매되었습니다.");
			$("form").attr("action","/buyNow");
		}else{
			e.preventDefault();
		}
	});
	
});
   

    </script>
    <style type="text/css">
      #detail {
        width: 63%;
        height: 430px;
        float: right;
      }

      #check {
        width: 53px;
      }

      #first_tr {
        border: 1px solid grey;
        background-color: #f5f5dc;
      }

      #second_tr {
        height: 32px;
      }

      #page {
        width: 100%;
        text-align: center;
      }

      #sand {
        width: 20px;
        height: 18px;
      }

      #btn {
        width: auto;
        height: auto;
        text-align: center;
      }

      table {
        border: 1px solid grey;
        border-collapse: collapse;
        width: 100%;
        text-align: center;
      }

      b {
        color: #012A5E;
      }

      #b2 {
        color: #055375;
      }

      #title {
        width: 25%;
        height: 400px;
        float: left;
      }
    </style>
</head>
<body>
<!-- 상단바  -->
<jsp:include page="../header.jsp">
    <jsp:param value="false" name="login"/>
</jsp:include>

<!-- 웹소설 표지 /cart -->
<form action="<%=request.getContextPath() %>" id="f" method="post">
    <img id="title" src="resources/images/novel/${dto.id}.jpg">

<!-- 웹소설 설명란 -->
<div id="detail"> 
<br><br><h1> ${dto.title} </h1>
<b>연재중&nbsp;&nbsp;|&nbsp;&nbsp;작가 ${dto.author}&nbsp;&nbsp;|&nbsp;&nbsp;${dto.genre }
		&nbsp;&nbsp;|&nbsp;&nbsp;${dto.indate }&nbsp;&nbsp;|
		&nbsp;&nbsp;조회수 ${dto.viewcount}&nbsp;&nbsp;|&nbsp;&nbsp;좋아요&nbsp;&nbsp;</b>
<hr /><br><br>
${dto.description}
<br><br><br><br><br><br><hr /><br><br>
<b>1화 소장: 모래 2알 <img id="sand" src="resources/images/sand.png"></b>
</div>  
<div id="blank" style="clear:both;"></div>
 
<input type="hidden" value="2" name="user_id">
<!-- 에피소드 목록 -->
<table>
<tr id="first_tr">
<td style="width:55px;">회차</td>
<td style="width:70%;">제목</td>
<td id="check"><input type="checkbox" id="all" name="all"></td>
<td>가격</td>
</tr>

<!-- 에피소드 출력 -->
<c:forEach items="${list}" var="epi">
	<tr id="second_tr"><td>${epi.sequence }화 ${epi.id }</td><td>${epi.title }</td>
		<td>
			<c:if test="${epi.price !=0}">
				<input type="checkbox" name="check" value="${epi.id}">
			</c:if>
			<c:if test="${epi.price ==0}">
				<b id="b2"><c:out value="소장중"/></b>
			</c:if>
		</td>
	<td>
		<c:if test="${epi.price ==0}">
			<c:out value="-"/>
		</c:if>
		<c:if test="${epi.price !=0}">
			<c:out value="모래 ${epi.price }알"/>
		</c:if>
	</td>
	</tr>
</c:forEach>
</table>
    <!-- 페이징 -->
    <div id="page">
        <%
            int totalCnt = (int) request.getAttribute("cnt");
            int totalPage = 0;
            if (totalCnt % 7 == 0) {
                totalPage = totalCnt / 7;
            } else {
                totalPage = totalCnt / 7 + 1;
            }
            for (int i = 1; i <= totalPage; i++) {
        %>
        <a href="oneNovelPage?id=${dto.id}&page=<%=i%>"><%=i%>페이지</a>
        <%
            }
        %>
    </div>

<!-- 장바구니, 구매 버튼 -->
<div id="btn">
<input type="hidden" value="${dto.id}" name="id">
<input type="hidden" value=<%=session.getAttribute("loginid") %> name="user_id">
<input type="submit" value="장바구니 담기" id="cart" name="cart">
<input type="submit" value="구매" id="buy" name="buy">
</div>
</form>
<jsp:include page="../footer.jsp"/>
</body>
</html>



 
 






