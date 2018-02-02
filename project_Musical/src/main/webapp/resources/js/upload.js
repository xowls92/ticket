$(".thumb").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".thumb").on(
		"drop",
		function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/com/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {
													
					var str = "";
					if (checkImageType(data)) {
						str = "<div><img src='/com/displayFile?fileName=" + data
								+ "'/><small data-src='" + data
								+ "'><input type='hidden' name='thumb_name' value='"+data+"'><button type='button'>X</button></small></div>"
					}

					$(".thumb").append(str);
				}

			});

		});
$(".seatmap").on("dragenter dragover", function(event) {
	event.preventDefault();
});
$(".seatmap").on(
		"drop",
		function(event) {
			event.preventDefault();
			
			if($('.seatmap div small').attr('data-src')==null){
			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/com/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {

					var str = "";
					if (checkImageType(data)) {									
						str = "<div><img src='/com/displayFile?fileName=" + data
								+ "'/><small data-src='" + data
								+ "'><input type='hidden' name='seatmap_name' value='"+data+"'><button>X</button></small></div>"
					}

					$(".seatmap").append(str);
				}

			});
			}
		});
$(".file").on("dragenter dragover", function(event) {
	event.preventDefault();
	
});
$(".file").on(
		"drop",
		function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();
			formData.append("file", file);

			$.ajax({
				url : '/com/upload',
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(data) {

					var str = "";
					if (checkImageType(data)) {
						str = "<div style='display:inline;'><img src='/com/displayFile?fileName=" + getImageLink(data)
								+ "'/><small class='file_submit' data-src='" + data
								+ "'><button>x</button></small></div>"
					}

					$(".file").append(str);
				}

			});

		});
function checkImageType(fileName) {
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}
function getOriginalName(fileName) {
	if (checkImageType(fileName)) {
		return;
	}

	var idx = fileName.indexOf("_") + 1;
	return fileName.substr(idx);
}
function getImageLink(fileName) {
	if (!checkImageType(fileName)) {
		return;
	}
	var front = fileName.substr(0, 12);
	var end = fileName.substr(14);

	return front + end;
}
$('.file,.seatmap,.thumb').on('click', 'small ', function(event) {
	var that = $(this);

	$.ajax({
		url : "/com/deleteFile",
		type : "post",
		dataType : "text",
		data : {
			fileName : $(this).attr("data-src")
		},
		success : function(result) {
			if (result == 'deleted') {
				that.parent("div").remove();
			}
		}
	});

});

$('#write').submit(function(event){
	event.preventDefault();
	
	var that=$(this);
	var str="";
	$('.file_submit').each(function(index){
		str+="<input type='hidden' name='file'"
		+"value='"+$(this).attr('data-src')+"'>";
	});
	
	that.append(str);
	that.get(0).submit();
});
function checkImageType(file_Name){
	var pattern=/jpg|gif|png|jpeg/i;
	
	return file_Name.match(pattern);
}

function getOri(fullName){
	
	var getLink;
		
		var front=file_name.substr(0,12); 
		var end=file_name.substr(14);  
		getLink="/displayFile?fileName="+front+end;
	
	return getLink;
}

function getThumb(fullName){
	
	var imgsrc
		imgsrc="/displayFile?fileName="+fullName;
	
	return imgsrc;
	
}
$('#addseat').on('click',function(event){
	if($('.seat_info').length<11){
		
	
	var str="<div class='seat_info'><input type='text' name='seat_grd'><input type='text' name='seat_no'><input type='text' name='seat_pri'><input type='time' name='seat_time'><input type='button' class='delseat' value='-'></div>";
	$(this).parent('div').append(str);
	}
})
$('#addseat').parent().on('click','.seat_info>.delseat',function(){
	$(this).parent('div').remove();
})
















