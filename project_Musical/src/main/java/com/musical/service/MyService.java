package com.musical.service;

import java.sql.SQLException;
import java.util.List;

import com.musical.domain.Criteria;
import com.musical.domain.MyVO;
import com.musical.domain.SearchCriteria;

public interface MyService {

	void deleteMy(int ttr_no)throws SQLException;
	List<MyVO> readMyList() throws SQLException;
	MyVO readMyByTno(int ttr_no)throws SQLException;
	List<MyVO> readMyListCriteria(Criteria cri)throws SQLException;
	List<MyVO> readSearchMyList(SearchCriteria cri)throws SQLException;
	int readSearchMyListCount(SearchCriteria cri) throws SQLException;
	
	
}
