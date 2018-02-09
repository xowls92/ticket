package com.musical.service;

import java.sql.SQLException;
import java.util.List;

import com.musical.domain.Criteria;
import com.musical.domain.ReservationVO;
import com.musical.domain.SearchCriteria;

public interface ReservationService {

	void createRes(ReservationVO res)throws SQLException;
	void updateRes(ReservationVO res)throws SQLException;
	void deleteRes(int ttr_no)throws SQLException;
	List<ReservationVO> readResList()throws SQLException;
	ReservationVO readResById(String res_id)throws SQLException;
	List<ReservationVO> readResListCriteria(Criteria cri)throws SQLException;
	List<ReservationVO> readSearchResList(SearchCriteria cri)throws SQLException;
	int readSearchResListCount(SearchCriteria cri)throws SQLException;
	
}
