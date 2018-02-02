<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<div>
	<div>
		<h3>뮤지컬</h3>
	</div>

<form method="post">
	<input type='hidden' name='ttr_no' value="${musicalVO.ttr_no}" />
	
	

<div>
	<div>
		<label>썸네일</label> 
		<img src="/displayFile?fileName=${musicalVO.thumb_name}">
	</div>	
	<div>
		<img src='"+getThumb(thumb_name)+"'><ori data_src='"+getOri(thumb_name)+"'>
	</div>
	<div>
		<label>좌석</label> 
		<img src="/displayFile?fileName=${musicalVO.seatmap_name}">
	</div>	
	<div>
		<label>제목</label> 
		<input type="text" name='ttr_title' value="${musicalVO.ttr_title}" readonly="readonly">
	</div>
	<div>
		<label>내용</label>
		<textarea name="ttr_content" rows="30" readonly="readonly">
			${musicalVO.ttr_content}
		</textarea>
	</div>
	<div>
		<label>장소</label> 
		<input type="text" name="ttr_place" value="${musicalVO.ttr_place}" readonly="readonly">
	</div>
	<div>
		<label>알림</label> 
		<input type="text" name="ttr_alert" value="${musicalVO.ttr_alert}" readonly="readonly">
	</div>
	<div>
		<label>시간정보</label> 
		<input type="text" name="ttr_time" value="${musicalVO.ttr_time}" readonly="readonly">
	</div>	
	<div>
		<label>시작일</label>
		<input type="text" name="ttr_sdate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${musicalVO.ttr_sdate}" />" readonly="readonly">~
	</div>
	
	<div>
		<label>종료일</label>
		<input type="text" name="ttr_edate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${musicalVO.ttr_edate}" />" readonly="readonly">	
	</div>
</div>
</form>
<!-- /.box-body -->
	<script src="resources/js/upload.js" ></script>
<div>	
	<button id="goResBtn" type="submit" class="btn btn-res">예약</button>
	<button id="modifyMcBtn" type="submit" class="btn btn-warning">수정</button>
	<button id="deleteMcBtn" type="submit" class="btn btn-danger">삭제</button>
	<button id="listMcBtn" type="submit" class="btn btn-primary">목 록</button>
	<button id="zzimgoBtn"type="submit" class="btn btn-zzim">찜하기</button>
</div>

<script>
				
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){		
			formObj.attr("action", "modifyPageForm");		
			formObj.attr("method", "get");		
			formObj.submit();
		});
		
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "removeMusical");
			formObj.submit();
		});
		
		$(".btn-primary").on("click", function(){
			self.location = "mclistA";
		});
		$(".btn-zzim").on("click", function(){
			self.location = "zzim";
		});
		$(".btn-res").on("click", function(){
			self.location = "res/resList";
		});
	});
	
</script>

<script>
				
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#modifyMcBtn").on("click", function() {
		formObj.attr("action", "modifyPageForm");
		formObj.attr("method", "get");
		formObj.submit();
	});

	$("#removeMcBtn").on("click", function() {
		
		var arr=[];
		$('.uploadedList li').each(function(index){
			arr.push($(this).attr('data-src'));				
		});
		
		if(arr.length>0){
			$.post('/deleteAllFiles',{files:arr},function(){});
		}
		
		
		formObj.attr("action", "removeMusical");
		formObj.submit();
	});

	$("#listBoMcBtn").on("click", function() {
		formObj.attr("method", "get");
		formObj.attr("action", "mclistA");
		formObj.submit();
	});
	
	var ttr_no=${musicalVO.ttr_no};
	var template=Handlebars.compile($('#templateAttach').html());
	
	$.getJSON("/sboard/getAttach/"+ttr_no,function(list){
		$(list).each(function(){
			var fileInfo=getFileInfo(this);
			
			var html=template(fileInfo);
			$(".uploadedList").append(html);
		});
	});
	
	$('.uploadedList').on('click','.mailbox-attachment-info a',function(event){
		var fileLink=$(this).attr("href");
		if(checkImageType(fileLink)){
			event.preventDefault();
			
			var imgTag=$('#popup_img');
			imgTag.attr('src',fileLink);
			
			//console.log(imgTag.attr('src'));
			
			$('.popup').show('slow');
			imgTag.addClass('show');
		}
	});
	
	$('#popup_img').on('click',function(){
		$('.popup').hide('slow');
	});
});

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>
<script id="template" type="text/x-handlebars-template">
{{#each .}}
	<li class="replyLi" data-rno={{rno}} >
		<i class="fa fa-comments bg-blue" ></i>
		<div class="timeline-item">
			<span class="time">
				<i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
			</span>
			<h3 class="timeline-header"><strong>{{rno}}</strong>-{{replyer}}</h3>
			<div class="timeline-body">{{replytext}}</div>
			<div class="timeline-footer">
				<a class="btn btn-primary btn-xs"
					data-toggle="modal" data-target="#modifyModal">Modify</a>
			</div>
		</div>
	</li>
{{/each}}
	</script>
<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
	<span class="mailbox-attachment-icon has-img">
		<img src="{{imgsrc}}" alt="Attachment" />
	</span>
	<div class="mailbox-attachment-info">
		<a href="{{getLink}}" class="mailbox-attachment-name">
			{{fileName}}</a>
	</div>
</li>
</script>





</div>
		
		