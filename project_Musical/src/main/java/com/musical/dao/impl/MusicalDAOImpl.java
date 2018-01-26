package com.musical.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.musical.dao.MusicalDAO;
import com.musical.domain.MusicalVO;
import com.musical.domain.SearchCriteria;

public class MusicalDAOImpl implements MusicalDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession= sqlSession;
	}
	private static final String NAMESPACE="MusicalMapper";
	
	@Override
	public void insertMc(MusicalVO mc) throws SQLException {
		
		sqlSession.update(NAMESPACE+".insertMusical",mc);
		
	}

	@Override
	public void updateMc(MusicalVO mc) throws SQLException {
		
		sqlSession.update(NAMESPACE+".updateMc",mc);
	}

	@Override
	public void deleteMc(int ttr_no) throws SQLException {
		
		sqlSession.update(NAMESPACE+".deleteMc",ttr_no);
	}

	@Override
	public List<MusicalVO> selectMcList() throws SQLException {

		List<MusicalVO> McList=sqlSession.selectList(NAMESPACE+".selectMcList",null);
		return McList;
	}

	@Override
	public MusicalVO selectMusicalBymcno(int ttr_no) throws SQLException {
		MusicalVO mc = (MusicalVO)sqlSession.selectOne(NAMESPACE+".selectMusicalBymcno",ttr_no);
		return mc;
	}

	@Override
	public List<MusicalVO> selectSearchList(SearchCriteria cri)
			throws SQLException {
		
		List<MusicalVO> McList=sqlSession.selectList(NAMESPACE+".selectSearchMcList",cri);
		return McList;
	}

	@Override
	public int selectSearchListCount(SearchCriteria cri) throws SQLException {
		int listCount = (Integer)sqlSession.selectOne(NAMESPACE+".selectSearchListCount",cri);
		return listCount;
	}

	/*@Override
	public void insertAttach(String file_name, int ttr_no) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("mcname",file_name);
		paramMap.put("ttr_no",ttr_no);
		
		sqlSession.update(NAMESPACE+".insertAttach",paramMap);
		
	}
	
	@Override
	public List<String> selectAttach(int ttr_no) throws SQLException {
		List<String> files=sqlSession.selectList(NAMESPACE+".selectAttach",ttr_no);
		return files;
	}

	@Override
	public void deleteAttach(int ttr_no) throws SQLException {

		sqlSession.update(NAMESPACE+".deleteAttach",ttr_no);
	}

	@Override
	public void replaceAttach(String file_name, int ttr_no) throws SQLException {

		Map<String,Object>paraMap=new HashMap<String,Object>();
		
		paraMap.put("mcname", file_name);
		paraMap.put("ttr_no", ttr_no);
		
		sqlSession.update(NAMESPACE+".replaceAttach",paraMap);
	}*/

}
