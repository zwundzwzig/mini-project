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
				<th>선택</th>
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
					<td><input type="checkbox" id="ch${ item.id }" class="rowCheckbox" data-item-id="${ item.id }" checked="checked"></td>
					<td>${ item.novelTitle }</td>
					<td>${ item.sequence }</td>
					<td>${ item.episodeTitle }</td>
					<td class="price" id="price${ item.id }">${ item.price }</td>
					<td><input type="button" class="delete" data-item-id="${ item.id }" value="삭제"></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th scope="row" colspan="4" >선택된 작품의 total</th>
				<td id="total"></td>
			</tr>
		</tfoot>
	</table>
	
	<input type="button" id="buy" value="결제하기">
	
	<script src="/resources/js/jquery-3.6.1.min.js"></script>
	<script>
		function updateTotalPrice(){
			let priceCells = [...document.getElementsByClassName('price')];
			let totalPrice =  priceCells.reduce(
					(acc, cur) => acc + Number(cur.innerText)
					, 0);
			
			$("#total").html(totalPrice);
		}
		
		function updateTotalCount(){
			$("#totalCount").html($("tbody>tr").length);
		}
		
		updateTotalPrice();
		
		$(".rowCheckbox").change(function(){
			let oldNum = Number($("#total").text());
			let oldCount = Number($("#totalCount").text());
			if($(this).is(":checked")){
				var newNum = oldNum + Number($("#price"+this.dataset.itemId).text());
				let newCount = oldCount + 1;
				$("#totalCount").text(newCount);
			}else{
				var newNum = oldNum - Number($("#price"+this.dataset.itemId).text());
				let newCount = oldCount - 1;
				$("#totalCount").text(newCount);
			}
			$("#total").text(newNum);
		});
		
		$(".delete").on("click", function(e){
		    $.ajax({
		        method : 'DELETE',
		        url : '/cart',
		        data : { id : e.target.dataset.itemId }
		      }).done(function(result){
		        //AJAX 성공시 실행 코드
		        if($("#ch"+e.target.dataset.itemId).is(":checked")){
		        	let oldNum = Number($("#total").text());
		        	var newNum = oldNum - Number($("#price"+e.target.dataset.itemId).text());
		        	$("#total").text(newNum);
		        }
		    	 $("#"+e.target.dataset.itemId).remove();
		      })
		    });
		
		$("#buy").on("click", function(){
	
			let request = $.ajax({
			  url: "/buy",
			  method: "POST",
			  dataType: "json"
			});
			request.done(function( response ) {
				if (response == true) {
                    alert("결제에 성공하셨습니다.");
                    window.location = "/mypage";
                }
			});
				 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
		})
		
		
		
		 
		
		
	</script>
</body>
</html>