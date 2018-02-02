package com.musical.dao;

import java.sql.SQLException;
import java.util.List;

import com.musical.domain.Criteria;
import com.musical.domain.MyVO;
import com.musical.domain.SearchCriteria;

public interface MyDAO {
	
	void deleteMy(int ttr_no)throws SQLException;//삭제
	List<MyVO> selectResList() throws SQLException;	//예약 리스트
	List<MyVO> selectRecList() throws SQLException;	//예약 리스트
	
	MyVO selectMyByTno(int ttr_no) throws SQLException;
	List<MyVO> selectMyListCriteria(Criteria cri) throws SQLException;;
	
	//검색
	List<MyVO> selectSearchList(SearchCriteria cri)throws SQLException;
	int selectSearchListCount(SearchCriteria cri) throws SQLException;
	
}
