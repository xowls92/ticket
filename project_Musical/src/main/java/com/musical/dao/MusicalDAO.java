package com.musical.dao;

import java.sql.SQLException;
import java.util.List;

import com.musical.domain.MusicalVO;
import com.musical.domain.SearchCriteria;

public interface MusicalDAO {

	void insertMc(MusicalVO mc) throws SQLException;//등록
	void updateMc(MusicalVO mc) throws SQLException;//수정
	void deleteMc(int ttr_no) throws SQLException;//삭제
	List<MusicalVO> selectMcList() throws SQLException;//리스트
	MusicalVO selectMusicalBymcno(int ttr_no) throws SQLException;//글번호

	//검색조건의 동적 쿼리문
	List<MusicalVO> selectSearchList(SearchCriteria cri)throws SQLException;
	int selectSearchListCount(SearchCriteria cri) throws SQLException;
	
	/*//파일 추가/삭제
	void insertAttach(String file_name,int ttr_no)throws SQLException;//첨부파일 이름
	List<String> selectAttach(int ttr_no)throws SQLException;
	void deleteAttach(int ttr_no)throws SQLException;
	void replaceAttach(String file_name,int ttr_no)throws SQLException;*/
	
	
}
