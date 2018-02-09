package com.musical.dao;

import java.sql.SQLException;
import java.util.List;

import com.musical.domain.Criteria;
import com.musical.domain.ReservationVO;
import com.musical.domain.SearchCriteria;

public interface ReservationDAO {

	void insertRes(ReservationVO res)throws SQLException;
	void updateRes(ReservationVO res)throws SQLException;
	void deleteRes(int ttr_no)throws SQLException;
	
	List<ReservationVO> selectResList()throws SQLException;
	ReservationVO selectResById(String res_id)throws SQLException;
	List<ReservationVO> selectResListCriteria(Criteria cri)throws SQLException;
	
	List<ReservationVO> selectSearchList(SearchCriteria cri)throws SQLException;
	int selectSearchListCount(SearchCriteria cri)throws SQLException;
}
