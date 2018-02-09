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
	<input type='text' name='ttr_no' value="${musicalVO.ttr_no}" readonly/>
	<input type='text' name='com_id' value="${musicalVO.com_id}" readonly/>
	

<div>
	<label>썸네일</label>
	<div class="thumb"
		style="width: 200px; height: 200px; background-color: white;">
	</div>
	<label>좌석배치도</label>
	<div class="seatmap"
		style="width: 200px; height: 200px; background-color: white;">
	</div>
	
	<%-- <div>
		<label>썸네일</label> 
		<img src="/displayFile?fileName=${musicalVO.thumb_name}">
	</div>	
	<div>
		<img src='"+getThumb(thumb_name)+"'><ori data_src='"+getOri(thumb_name)+"'>
	</div>
	<div>
		<label>좌석</label> 
		<img src="/displayFile?fileName=${musicalVO.seatmap_name}">
	</div> --%>	
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
	<div>
		<label>좌석정보</label>
			<table id="seat_table">
				<tr>
					<td>등급</td>
					<td>좌석수</td>
					<td>가격</td>
					<td>날짜</td>
					<td>시간</td>
				</tr>
			</table>
	</div>
	<label>사진자료</label>
	<div class="file"
		style="width: 800px; height: 200px; background-color: white;">
	</div>
</div>
</form>
	<div class="popup back" style="display: none;"></div>
	<div id="popup_front" class='popup front' style="display: none;">
		<img id="popup_img" />
	</div>
<!-- /.box-body -->
	<script src="/com/resources/js/upload.js" ></script>

<a href="/com/res/createRes?ttr_no=${musicalVO.ttr_no }"><button>예약</button></a>
<a href="/com/mclistA"><button>목록</button></a>
<a href="/com/removeMusical?ttr_no=${musicalVO.ttr_no }"><button>삭제</button></a>
<a href="/com/modifyPageForm?ttr_no=${musicalVO.ttr_no } "><button>수정</button></a>
<a href="/com/my/zzim?ttr_no=${musicalVO.ttr_no }"><button>찜</button></a>

<script>
	var sdate=new Date('${musicalVO.ttr_sdate}');
	$(document).ready(function(){
		var seats=null;
		var str=""
		<c:forEach var="seat" items="${musicalVO.seat_grd}" varStatus="status">
			str+="<tr><input type='hidden' name='seat_id' value='${musicalVO.seat_id[status.count-1]}'>" +
			"<td id='seat_info'><input type='text' name='seat_grd' value='${musicalVO.seat_grd[status.count-1]}' readonly></td>"+
			"<td><input type='int' name='seat_no' value='${musicalVO.seat_no[status.count-1]}' readonly></td>"+
			"<td><input type='int' name='seat_pri' value='${musicalVO.seat_pri[status.count-1]}' readonly></td>"+
			"<td><input type='date' name='seat_date' value='<fmt:formatDate pattern='yyyy-MM-dd' value='${musicalVO.seat_date[status.count-1]}' />' readonly></td>"+
			"<td><input type='time' name='seat_time' value='<fmt:formatDate pattern='HH:mm' value='${musicalVO.seat_time[status.count-1]}' />' readonly></td>"+
		"</tr>"
		</c:forEach>
		$('#seat_table').append(str);
			var ttr_no=${musicalVO.ttr_no};
			var thumb_name="${musicalVO.thumb_name}"
			var thumb="<div class='min'><img src='"+getThumb(thumb_name)+"'><ori data_src='"+getOri(thumb_name)+"'></div>"
			var seatmap_name="${musicalVO.seatmap_name}"
			var seatmap="<div class='min'><img src='"+getThumb(seatmap_name)+"'><ori data_src='"+getOri(seatmap_name)+"'></div>"
			$(".thumb").append(thumb);
			$(".seatmap").append(seatmap);
			$.getJSON("/com/mc/getFiles/"+ttr_no,function(list){
				$(list).each(function(){
					var file;
					file="<img src='"+getOri(this)+"'>";
					$(".file").append(file);
				})
			})
			$('.min').on('click',function(event){
				var fileLink=$(this).children('ori').attr('data_src')
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
		})

</script>
</div>
		
		