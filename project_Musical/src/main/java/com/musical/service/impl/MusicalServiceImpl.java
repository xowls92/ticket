package com.musical.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.musical.dao.MusicalDAO;
import com.musical.domain.MusicalVO;
import com.musical.domain.SearchCriteria;
import com.musical.service.MusicalService;

public class MusicalServiceImpl implements MusicalService{

	private MusicalDAO musicalDAO;
	public void setMusicalDAO(MusicalDAO musicalDAO){
		this.musicalDAO=musicalDAO;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	
	@Override
	public void createMc(MusicalVO mc) throws SQLException {

		musicalDAO.insertMc(mc);
		String[]files=mc.getFiles();
		int mcno=musicalDAO.selectMaxmcno();
		
		if(files==null)return;
		for(String mcname:files){
			musicalDAO.insertAttach(mcname, mcno);
		}
	}
	@Transactional(propagation=Propagation.REQUIRED,
			   rollbackFor={Exception.class})
	@Override
	public void updateMc(MusicalVO mc) throws SQLException {

		musicalDAO.updateMc(mc);
		
		int ttr_no=mc.getTtr_no();
		musicalDAO.deleteAttach(ttr_no);
		
		String[] files=mc.getFiles();
		System.out.println(mc);
		if(files==null){return;}
		for(String mcname:files){
			musicalDAO.replaceAttach(mcname, ttr_no);
		}
	}
	@Transactional(propagation=Propagation.REQUIRED,
		       rollbackFor={Exception.class})
	@Override
	public void deleteMc(int mcno) throws SQLException {

		musicalDAO.deleteMc(mcno);
		musicalDAO.deleteAttach(mcno);
	}
	@Transactional(isolation=Isolation.READ_COMMITTED,readOnly=true)
	@Override
	public List<MusicalVO> readMcList() throws SQLException {
		List<MusicalVO> mcList=musicalDAO.selectMcList();
		return mcList;
	}
	@Override
	public MusicalVO readMusicalBymcno(int mcno) throws SQLException {
		MusicalVO mc=musicalDAO.selectMusicalBymcno(mcno);
		return mc;
	}
	@Override
	public List<MusicalVO> readSearchMusicalList(SearchCriteria cri)
			throws SQLException {
		List<MusicalVO> mcList=musicalDAO.selectSearchList(cri);
		return mcList;
	}
	@Override
	public int readSearchMcListCount(SearchCriteria cri) throws SQLException {
		int countList=musicalDAO.selectSearchListCount(cri);
		return countList;
	}
	@Override
	public List<String> getAttach(int mcno) throws SQLException {
		List<String> mcnames=musicalDAO.selectAttach(mcno);
		return mcnames;
	}
	
	
	
	
}
