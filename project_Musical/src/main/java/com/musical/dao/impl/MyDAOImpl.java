package com.musical.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.musical.dao.MyDAO;
import com.musical.domain.Criteria;
import com.musical.domain.MyVO;
import com.musical.domain.SearchCriteria;

public class MyDAOImpl implements MyDAO{

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	private static final String NAMESPACE = "MyMapper";

	@Override
	public void deleteMy(int ttr_no) throws SQLException {
		sqlSession.update(NAMESPACE + ".deleteBoard", ttr_no);
		
	}
	@Override
	public List<MyVO> selectResList() throws SQLException {
		List<MyVO> ResList=sqlSession.selectList(NAMESPACE+".selectResList",null);
		
		return ResList;
	}
	@Override
	public List<MyVO> selectRecList() throws SQLException {
		List<MyVO> RecList=sqlSession.selectList(NAMESPACE+".selectRecList",null);
		
		return RecList;
	}
	@Override
	public MyVO selectMyByTno(int ttr_no) throws SQLException {
		MyVO my = (MyVO) sqlSession.selectOne(NAMESPACE + ".selectMyByTno",ttr_no);
		return my;
	}
	@Override
	public List<MyVO> selectMyListCriteria(Criteria cri) throws SQLException {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MyVO> myList = sqlSession.selectList(NAMESPACE+".selectMyList",null,rowBounds);
		return myList;
	}
	@Override
	public List<MyVO> selectSearchList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MyVO> myList = sqlSession.selectList(NAMESPACE+".selectSearchMyList",cri,rowBounds);
		return myList;
	}
	@Override
	public int selectSearchListCount(SearchCriteria cri) throws SQLException {
		int listCount = (int) sqlSession.selectOne(NAMESPACE+".selectSearchMyCount",cri);
		return listCount;
	}
	
	
	
	}
