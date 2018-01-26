package com.musical.service;
import java.sql.SQLException;
import java.util.List;

import com.musical.domain.MusicalVO;
import com.musical.domain.SearchCriteria;


public interface MusicalService {

	void createMc(MusicalVO mc) throws SQLException;
	void updateMc(MusicalVO mc) throws SQLException;
	void deleteMc(int ttr_no) throws SQLException;
	
	List<MusicalVO> readMcList() throws SQLException;
	MusicalVO readMusicalBymcno(int ttr_no)throws SQLException;	
	
	List<MusicalVO> readSearchMusicalList(SearchCriteria cri)throws SQLException;
	int readSearchMcListCount(SearchCriteria cri)throws SQLException;
	
	/*List<String> getAttach(int ttr_no)throws SQLException;*/
	
}
