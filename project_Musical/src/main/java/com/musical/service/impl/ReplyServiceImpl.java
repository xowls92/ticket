package com.musical.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.musical.dao.ReplyDAO;
import com.musical.domain.Criteria;
import com.musical.domain.ReplyVO;
import com.musical.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{

	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO){
		this.replyDAO=replyDAO;
	}
	@Override
	public List<ReplyVO> getReplyList(int ttr_no) throws SQLException {
		return replyDAO.selectReplyList(ttr_no);
	}

	@Override
	public void addReply(ReplyVO reply) throws SQLException {
		replyDAO.insertReply(reply);
		
	}

	@Override
	public void modifyReply(ReplyVO reply) throws SQLException {
		replyDAO.updateReply(reply);
		
	}

	@Override
	public void removeReply(int tr_rno) throws SQLException {
		replyDAO.deleteReply(tr_rno);
		
	}

	@Override
	public List<ReplyVO> getReplyListPage(int ttr_no, Criteria cri)
			throws SQLException {
		return replyDAO.selectReplyListPage(ttr_no, cri);
	}

	@Override
	public int countReply(int ttr_no) throws SQLException {
		return replyDAO.countReply(ttr_no);
	}

}
