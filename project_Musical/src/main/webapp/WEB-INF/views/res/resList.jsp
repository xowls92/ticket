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
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>

			<c:forEach items="${list}" var="ReservationVO">
				<tr>
					<td>${ReservationVO.ttr_no }</td>
					<td><a href="/com/readMcPage?ttr_no=${musicalVO.ttr_no}">${musicalVO.ttr_title }</a></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ReservationVO.res_date}" /></td>
				</tr>

			</c:forEach>		
		</table>
			<button>예약 취소</button>
	</div>
</body>
</html>