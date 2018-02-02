package com.musical.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.musical.dao.ReservationDAO;
import com.musical.domain.Criteria;
import com.musical.domain.ReservationVO;
import com.musical.domain.SearchCriteria;

public class ReservationDAOImpl implements ReservationDAO{

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession= sqlSession;
	}
	
	private static final String NAMESPACE="ResMapper";
	
	@Override
	public void insertRes(ReservationVO res) throws SQLException {

		sqlSession.update(NAMESPACE+".insertRes",res);
	}

	@Override
	public void updateRes(ReservationVO res) throws SQLException {

		sqlSession.update(NAMESPACE+".updateRes",res);
	}

	@Override
	public void deleteRes(int ttr_no) throws SQLException {

		sqlSession.update(NAMESPACE+".deleteRes",ttr_no);
	}

	@Override
	public List<ReservationVO> selectResList() throws SQLException {
		List<ReservationVO> resList=sqlSession.selectList(NAMESPACE+".selectResList",null);
		return resList;
	}

	@Override
	public ReservationVO selectResByTno(int ttr_no) throws SQLException {
		ReservationVO res = (ReservationVO) sqlSession.selectOne(NAMESPACE+".selectResByTno",ttr_no);
		return res;
	}

	@Override
	public List<ReservationVO> selectResListCriteria(Criteria cri) throws SQLException {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<ReservationVO> resList=sqlSession.selectList(NAMESPACE+".selectResList",null,rowBounds);
		return resList;
	}

	@Override
	public List<ReservationVO> selectSearchList(SearchCriteria cri)
			throws SQLException {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<ReservationVO> resList = sqlSession.selectList(NAMESPACE+".selectSearchResList",cri,rowBounds);
		return resList;
	}

	@Override
	public int selectSearchListCount(SearchCriteria cri) throws SQLException {
		int listCount=(int) sqlSession.selectOne(NAMESPACE+".selectSearchResCount",cri);
		return listCount;
	}

}
