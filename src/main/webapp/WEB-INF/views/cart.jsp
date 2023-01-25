<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니</h1>
	<h1>총 <span id="totalCount">${ cnt }</span>개</h1>
	<table>
		<thead>
			<tr>
				<th>소설제목</th>
				<th>회차</th>
				<th>회차제목</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ items }" var="item">
				<tr id="${ item.id }">
					<td>${ item.novelTitle }</td>
					<td>${ item.sequence }</td>
					<td>${ item.episodeTitle }</td>
					<td class="price">${ item.price }</td>
					<td><input type="button" class="delete" data-item-id="${ item.id }" value="삭제"></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th scope="row" colspan="3" >total</th>
				<td id="total"></td>
			</tr>
		</tfoot>
	</table>
	<script src="/resources/js/jquery-3.6.1.min.js"></script>
	<script>
		function updateTotalPrice(){
			let priceCells = [...document.getElementsByClassName('price')];
			let totalPrice =  priceCells.reduce(
					(acc, cur) => acc + Number(cur.innerText), 0);
			
			$("#total").html(totalPrice);
		}
		
		function updateTotalCount(){
			$("#totalCount").html($("tbody>tr").length);
		}
		
		updateTotalPrice();
		
		$(".delete").on("click", function(e){
		    $.ajax({
		        method : 'DELETE',
		        url : '/cart',
		        data : { id : e.target.dataset.itemId }
		      }).done(function(result){
		        //AJAX 성공시 실행 코드
		    	 $("#"+e.target.dataset.itemId).remove();
		         updateTotalCount();
		         updateTotalPrice();
		      })
		    });
		
		
	</script>
</body>
</html>