<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<div>
	<h3>수정페이지</h3>
</div>
				

<form role="form" method="post">
	<input type='hidden' name='ttr_no' value="${musicalVO.ttr_no}" />
	 
	<div>
		<div>
		<label>제목</label> 
		<input type="text" name='title' value="${musicalVO.ttr_title}">
		<div>
			<label>내용</label>
			<textarea name="content" rows="30">
				${musicalVO.ttr_content}
			</textarea>
		</div>
		<div>
			<label>장소</label> 
			<input type="text" name="place" value="${musicalVO.ttr_place}">
		</div>
		<div>
			<label>알림</label> 
			<input type="text" name="place" value="${musicalVO.ttr_alert}" readonly="readonly">
		</div>
		<div>
			<label>시간정보</label> 
			<input type="text" name="place" value="${musicalVO.ttr_time}" readonly="readonly">
		</div>
		<div>
			<label>시작일</label>
			<input type="date" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${musicalVO.ttr_sdate}" />" >~
		</div>
		
		<div>
			<label>종료일</label>
			<input type="date" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${musicalVO.ttr_edate}" />" >	
		</div>
	</div>
	</div>	
	<!-- /.box-body -->
</form>


<div class="box-footer">
	<button type="submit" class="btn btn-primary">저장</button>
	<button type="submit" class="btn btn-warning">취소</button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-warning").on("click", function() {
			formObj.attr("action", "mclistA");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-primary").on("click", function() {
			formObj.attr("action","modifyPage");
			formObj.submit();
		});

	});
</script>




			










