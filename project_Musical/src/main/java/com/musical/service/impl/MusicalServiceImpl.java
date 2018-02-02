package com.musical.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.musical.dao.MusicalDAO;
import com.musical.domain.MusicalVO;
import com.musical.domain.SearchCriteria;
import com.musical.domain.Seatinfo;
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
		
		Seatinfo[] seats = null;

		String[] seat_grds = mc.getSeat_grd();
		String[] seat_nos = mc.getSeat_no();
		String[] seat_pris = mc.getSeat_pri();
		Date[] seat_times = mc.getSeat_time();

		for (int i = 0; i < seat_grds.length; i++) {
			seats[i].setSeat_grd(seat_grds[i]);
			seats[i].setSeat_no(seat_nos[i]);
			seats[i].setSeat_pri(seat_pris[i]);
			seats[i].setSeat_time(seat_times[i]);
		}

		int ttr_no = musicalDAO.selectSearchListCount();
		String thumb = mc.getThumb_name();
		String seatmap = mc.getThumb_name();
		musicalDAO.insertThumb(thumb, ttr_no);
		musicalDAO.insertseatmap(seatmap, ttr_no);
		if (files == null)
			return;
		for (String file_name : files) {
			musicalDAO.insertAttach(file_name, ttr_no);
		}
		if (seats == null)
			return;
		for (Seatinfo seat : seats) {
			musicalDAO.insertseat(seat);
		}

	}

		
	
	@Transactional(propagation=Propagation.REQUIRED,
			   rollbackFor={Exception.class})
	@Override
	public void updateMc(MusicalVO mc) throws SQLException {

		musicalDAO.updateMc(mc);
		
		int ttr_no=mc.getTtr_no();
		/*musicalDAO.deleteAttach(ttr_no);*/
		
		String[] files=mc.getFiles();
		System.out.println(mc);
		if(files==null){return;}
		for(String file_name:files){
		/*	musicalDAO.replaceAttach(file_name, ttr_no);*/
		}
	}
	@Transactional(propagation=Propagation.REQUIRED,
		       rollbackFor={Exception.class})
	@Override
	public void deleteMc(int ttr_no) throws SQLException {

		musicalDAO.deleteMc(ttr_no);
/*		musicalDAO.deleteAttach(ttr_no);*/
	}
	@Transactional(isolation=Isolation.READ_COMMITTED,readOnly=true)
	@Override
	public List<MusicalVO> readMcList() throws SQLException {
		List<MusicalVO> mcList=musicalDAO.selectMcList();
		return mcList;
	}
	@Override
	public MusicalVO readMusicalBymcno(int ttr_no) throws SQLException {
		MusicalVO mc=musicalDAO.selectMusicalBymcno(ttr_no);
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
		int countList=musicalDAO.selectSearchListCount();
		return countList;
	}
	@Override
	public List<String> getAttach(int ttr_no) throws SQLException {
		List<String> file_names=musicalDAO.selectAttach(ttr_no);
		return file_names;
	}

	@Override
	public Seatinfo readseatbyseat_id(String seat_id) throws SQLException {
		Seatinfo seat = musicalDAO.selectseatbyseat_id(seat_id);
		return seat;
	}

	@Override
	public List<Seatinfo> readseatbyttr_no(int ttr_no) throws SQLException {
		List<Seatinfo> seat = musicalDAO.selectseatbyttr_no(ttr_no);
		return seat;
	}

	@Override
	public List<Seatinfo> readseat() throws SQLException {
		List<Seatinfo> seat = musicalDAO.selectseat();
		return seat;
	}
	
	
	
	
}
