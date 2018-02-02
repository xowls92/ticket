package com.musical.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.musical.dao.ReservationDAO;
import com.musical.domain.Criteria;
import com.musical.domain.ReservationVO;
import com.musical.domain.SearchCriteria;
import com.musical.service.ReservationService;

public class ReservationServiceImpl implements ReservationService{

	private ReservationDAO resDAO;
	public void setReservationDAO(ReservationDAO resDAO){
		this.resDAO=resDAO;
	}
	@Override
	public void createRes(ReservationVO res) throws SQLException {
		resDAO.insertRes(res);
	}

	@Override
	public void updateRes(ReservationVO res) throws SQLException {

		resDAO.updateRes(res);
	}

	@Override
	public void deleteRes(int ttr_no) throws SQLException {

		resDAO.deleteRes(ttr_no);
	}

	@Override
	public List<ReservationVO> readResList() throws SQLException {
		List<ReservationVO> resList=resDAO.selectResList();
		return resList;
	}

	@Override
	public ReservationVO readResByTno(int ttr_no) throws SQLException {
		ReservationVO res=resDAO.selectResByTno(ttr_no);
		return res;
	}

	@Override
	public List<ReservationVO> readResListCriteria(Criteria cri)
			throws SQLException {
		List<ReservationVO> resList=resDAO.selectResListCriteria(cri);
		return resList;
	}

	@Override
	public List<ReservationVO> readSearchResList(SearchCriteria cri)
			throws SQLException {
		List<ReservationVO> resList=resDAO.selectSearchList(cri);
		return resList;
	}

	@Override
	public int readSearchResListCount(SearchCriteria cri) throws SQLException {
		int countList=resDAO.selectSearchListCount(cri);
		return countList;
	}

	
}
