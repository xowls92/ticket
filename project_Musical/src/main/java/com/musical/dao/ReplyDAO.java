package com.musical.dao;

import java.sql.SQLException;
import java.util.List;

import com.musical.domain.Criteria;
import com.musical.domain.ReplyVO;

public interface ReplyDAO {
	
	List<ReplyVO> selectReplyList(int ttr_no) throws SQLException;
	void insertReply(ReplyVO reply) throws SQLException;
	void updateReply(ReplyVO reply)throws SQLException;
	void deleteReply(int tr_rno) throws SQLException;
	
	List<ReplyVO> selectReplyListPage(int ttr_no,Criteria cri)throws SQLException;
	int countReply(int ttr_no) throws SQLException;
}
