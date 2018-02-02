package com.musical.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.musical.dao.MyDAO;
import com.musical.domain.Criteria;
import com.musical.domain.MyVO;
import com.musical.domain.SearchCriteria;
import com.musical.service.MyService;

public class MyServiceImpl implements MyService{

	private MyDAO myDAO;
	public void setMyDAO(MyDAO myDAO){
		this.myDAO=myDAO;
	}
	
	@Override
	public void deleteMy(int ttr_no) throws SQLException {

		myDAO.deleteMy(ttr_no);
	}

	@Override
	public List<MyVO> readMyList() throws SQLException {
		List<MyVO> MyResList=myDAO.selectResList();
		List<MyVO> MyRecList=myDAO.selectRecList();
		
		return MyResList;
	}

	@Override
	public MyVO readMyByTno(int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyVO> readMyListCriteria(Criteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyVO> readSearchMyList(SearchCriteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int readSearchMyListCount(SearchCriteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
