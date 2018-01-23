<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">수정페이지</h3>
				</div>
				<!-- /.box-header -->

<form role="form" method="post">
	
	<input type='hidden' name='page' value="${cri.page }" /> 
	<input type='hidden' name='perPageNum' value="${cri.perPageNum }" />
	 
	<div class="box-body">

		<div class="form-group">
			<label for="exampleInputEmail1">글번호</label> <input type="text"
				name='mcno' class="form-control" value="${musicalVO.ttr_no}"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">글제목</label> <input type="text"
				name='title' class="form-control" value="${musicalVO.ttr_title}">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">내용</label>
			<textarea class="form-control" name="content" rows="3">${musicalVO.ttr_content}</textarea>
		</div>
		<div class="form-group">
			<label>장소</label> <input
				type="text" name="place" class="form-control"
				value="${musicalVO.ttr_place}">
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












