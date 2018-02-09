<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>예약</h1>
	<div>
		<table>
			<tr>
				<th>예약이름</th>
				<th>예약날짜</th>
				<th>글제목</th>
				<th>좌석번호</th>				
			</tr>

			<c:forEach items="${list}" var="reservationVO">
				<tr>
					<td>
						<a href="readRes?res_id=${reservationVO.res_id}">${reservationVO.res_id }</a>
					</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${reservationVO.res_date}" /></td>
					<td>
						<a href="<c:url value="/readMcPage" />?ttr_no=${reservationVO.ttr_no }">
							${reservationVO.ttr_title }
						</a>	
				</td>
					<td>${reservationVO.res_nom }</td>
				</tr>
			</c:forEach>		
		</table>
			<button>예약 취소</button>
	</div>
</body>
</html>



















