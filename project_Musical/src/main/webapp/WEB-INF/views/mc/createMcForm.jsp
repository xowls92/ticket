<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

			
			<div>
				<div>
					<h3>뮤지컬 글 등록</h3>
				</div>
				

				<form role="form" method="post">
					<div>						
						<div>
							<label>기업회원 아이디</label>
							<input type="text" name='com_id' placeholder="기업회원 아이디">
						</div>
						<div>
							<label>공연 종류</label>
							<input type="text" name='ttr_cat' placeholder="공연 종류를 작성하세요.">
						</div>
						<div>
							<label>뮤지컬 제목</label> 
							<input type="text"
								name='ttr_title' placeholder="제목을 입력하세요.">
						</div>
						<div>
						<label>뮤지컬 시작날짜</label> 							
							<input type="date" name='ttr_sdate' placeholder="시작 날짜 작성">
						</div>
						<div>
						<label>뮤지컬 종료날짜</label> 
							<input type="date" name='ttr_edate' placeholder="종료 날짜 작성">
						</div>
						<div>
						<label>뮤지컬 장소</label> 
							<input type="text" name='ttr_place' placeholder="장소 작성">
						</div>
						<div>
						<label>뮤지컬 시간정보</label> 
							<input type="text" name='ttr_time' placeholder="시간정보">
						</div>
						<div>
						<label>뮤지컬 알릴말</label> 
							<input type="text" name='ttr_alert' placeholder="알리는말">
						</div>
						<div>
							<label>뮤지컬 내용</label><br>
							<textarea name="ttr_content" rows="30" cols="170"
								placeholder="내용을 입력하세요."></textarea>
						</div>
						<div>
							<label>첨부파일</label>
							<div class="file" style="width:800px; height:200px; background-color:gray;"></div>
							
						</div>
					</div>
					
				
					<div>
						<button type="submit">제출</button>
					</div>
				</form>
			<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
			<script type="text/javascript" src="/resources/js/upload.js"></script>

			</div>
			
</body>
	

























