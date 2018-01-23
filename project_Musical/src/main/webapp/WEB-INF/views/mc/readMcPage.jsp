<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<div>
	<div>
		<h3>뮤지컬</h3>
	</div>

<form role="form" method="post">
	<input type='hidden' name='mcno' value="${musicalVO.ttr_no}" />
	
	<input type='hidden' name='page' value="${cri.page }" /> 
	<input type='hidden' name='perPageNum' value="${cri.perPageNum }" /> 
	

</form>

<div class="box-body">
	<div class="form-group">
		<label for="exampleInputEmail1">제목</label> <input type="text"
			name='title' class="form-control" value="${musicalVO.ttr_title}"
			readonly="readonly">
	</div>
	<div>
		<label>내용</label>
		<textarea name="content" rows="30" readonly="readonly">
			${musicalVO.ttr_content}
		</textarea>
	</div>
	<div>
		<label>장소</label> <input type="text" name="place" value="${musicalVO.ttr_place}"
			readonly="readonly">
	</div>
</div>

<!-- /.box-body -->

<div>
	<!-- <button type="submit" class="btn btn-warning">수정</button>
	<button type="submit" class="btn btn-danger">삭제</button>
	<button type="submit" class="btn btn-primary">목록</button> -->
	<a href=""><button type="submit">예약</button></a>
	<a href="modifyPage"><button type="submit" onclick="location.href='modifyPage?ttr_no=${musicalVO.ttr_no}'">수정</button></a>
	<button type="submit" onclick="location='deleteMc?ttr_no=${musicalVO.ttr_no}'">삭제</button>
	<a href="mclistA"><button type="submit" class="btn btn-primary">목록</button></a>
	<a href=""><button type="submit">찜하기</button></a>
</div>


				<script>
				
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){		
		formObj.attr("action", "modifyPage");		
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "removePage");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		formObj.attr("action", "mclistA");
		formObj.attr("method", "get");
		formObj.submit();
	});
	
});

</script>




			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->