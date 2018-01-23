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
							<input type="text" name='cat' placeholder="공연 종류를 작성하세요.">
						</div>
						<div>
							<label>뮤지컬 제목</label> 
							<input type="text"
								name='title' placeholder="제목을 입력하세요.">
						</div>
						<div>							
							<input type="date" name='sdate' placeholder="시작 날짜 작성">
						</div>
						<div>
							<input type="date" name='edate' placeholder="종료 날짜 작성">
						</div>
						<div>
							<input type="text" name='place' placeholder="장소 작성">
						</div>
						<div>
							<input type="text" name='time' placeholder="시간정보">
						</div>
						<div>
							<input type="text" name='alert' placeholder="알리는말">
						</div>
						<div>
							<label>뮤지컬 내용</label><br>
							<textarea name="content" rows="30" cols="170"
								placeholder="내용을 입력하세요."></textarea>
						</div>
					</div>
					
				
					<div>
						<button type="submit">제출</button>
					</div>
				</form>


			</div>
			
	

























