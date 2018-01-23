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
		
		sqlSession.update(NAMESPACE+".insertMc",mc);
		
	}

	@Override
	public void updateMc(MusicalVO mc) throws SQLException {
		
		sqlSession.update(NAMESPACE+".updateMc",mc);
	}

	@Override
	public void deleteMc(int mcno) throws SQLException {
		
		sqlSession.update(NAMESPACE+".deleteMc",mcno);
	}

	@Override
	public List<MusicalVO> selectMcList() throws SQLException {

		List<MusicalVO> McList=sqlSession.selectList(NAMESPACE+".selectMcList",null);
		return McList;
	}

	@Override
	public MusicalVO selectMusicalBymcno(int mcno) throws SQLException {
		MusicalVO mc = (MusicalVO)sqlSession.selectOne(NAMESPACE+".selectMusicalBymcno",mcno);
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

	@Override
	public void insertAttach(String mcname, int mcno) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("mcname",mcname);
		paramMap.put("mcno",mcno);
		
		sqlSession.update(NAMESPACE+".insertAttach",paramMap);
		
	}

	@Override
	public int selectMaxmcno() throws SQLException {
		return (Integer)sqlSession.selectOne(NAMESPACE+".selectMaxmcno",null);
	}

	@Override
	public List<String> selectAttach(int mcno) throws SQLException {
		List<String> files=sqlSession.selectList(NAMESPACE+".selectAttach",mcno);
		return files;
	}

	@Override
	public void deleteAttach(int mcno) throws SQLException {

		sqlSession.update(NAMESPACE+".deleteAttach",mcno);
	}

	@Override
	public void replaceAttach(String mcname, int mcno) throws SQLException {

		Map<String,Object>paraMap=new HashMap<String,Object>();
		
		paraMap.put("mcname", mcname);
		paraMap.put("mcno", mcno);
		
		sqlSession.update(NAMESPACE+".replaceAttach",paraMap);
	}

}
