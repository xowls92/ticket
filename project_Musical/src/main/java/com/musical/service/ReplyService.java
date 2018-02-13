package com.musical.service;

import java.sql.SQLException;
import java.util.List;

import com.musical.domain.Criteria;
import com.musical.domain.ReplyVO;

public interface ReplyService {

	List<ReplyVO>getReplyList(int ttr_no) throws SQLException;
	
	void addReply(ReplyVO reply) throws SQLException;
	void modifyReply(ReplyVO reply)throws SQLException;
	void removeReply(int tr_rno) throws SQLException;
	
	List<ReplyVO> getReplyListPage(int ttr_no, Criteria cri) 
				throws SQLException;
	int countReply(int ttr_no) throws SQLException;
}
