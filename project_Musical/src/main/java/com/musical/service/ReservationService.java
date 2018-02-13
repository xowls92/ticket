package com.musical.service;

import java.sql.SQLException;
import java.util.List;

import com.musical.domain.Criteria;
import com.musical.domain.ReservationVO;
import com.musical.domain.SearchCriteria;

public interface ReservationService {

	int countresbyseat_id(String seat_id) throws SQLException;

	ReservationVO selectresbyres_id(String res_id) throws SQLException;
	ReservationVO selectresbyres_nom(int res_nom,String seat_id) throws SQLException;
	List<ReservationVO> selectresbyseat_id(String seat_id) throws SQLException;
	List<ReservationVO> selectresbymem_id(String mem_id) throws SQLException;
	List<ReservationVO> selectresbyttr_no(int ttr_no) throws SQLException;
	
	void insertres(ReservationVO res) throws SQLException;
	void deleteResid(String res_id) throws SQLException;
	void deleteResnom(String res_nom) throws SQLException;
	void deletettrno(int ttr_no) throws SQLException;
	
	List<ReservationVO> readResList() throws SQLException;
}
