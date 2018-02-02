package com.musical.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class MusicalVO2 {

	private int ttr_no;//글번호
	private String com_id;//기업아이디
	private String ttr_cat;//전시종류
	private String ttr_title;//제목
	private String ttr_date;//등록일
	private String ttr_sdate;//행사시작일
	private String ttr_edate;//행사종료일
	private String ttr_place;//행사장소
	private String ttr_time;//시간정보
	private String ttr_alert;//알림
	private String ttr_content;//상세설명
	private String thumb_name;//썸네일
	private String seatmap_name;//자리	
	private String[] files;
	private String[] seat_grd;
	private String[] seat_no;
	private String[] seat_pri;
	private String[] seat_time;
	
	@Override
	public String toString() {
		return "MusicalVO [ttr_no=" + ttr_no + ", com_id=" + com_id
				+ ", ttr_cat=" + ttr_cat + ", ttr_title=" + ttr_title
				+ ", ttr_date=" + ttr_date + ", ttr_sdate=" + ttr_sdate
				+ ", ttr_edate=" + ttr_edate + ", ttr_place=" + ttr_place
				+ ", ttr_time=" + ttr_time + ", ttr_alert=" + ttr_alert
				+ ", ttr_content=" + ttr_content + ", thumb_name=" + thumb_name
				+ ", seatmap_name=" + seatmap_name + ", files="
				+ Arrays.toString(files) + ", seat_grd="
				+ Arrays.toString(seat_grd) + ", seat_no="
				+ Arrays.toString(seat_no) + ", seat_pri="
				+ Arrays.toString(seat_pri) + ", seat_time="
				+ Arrays.toString(seat_time) + "]";
	}
	public int getTtr_no() {
		return ttr_no;
	}
	public void setTtr_no(int ttr_no) {
		this.ttr_no = ttr_no;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getTtr_cat() {
		return ttr_cat;
	}
	public void setTtr_cat(String ttr_cat) {
		this.ttr_cat = ttr_cat;
	}
	public String getTtr_title() {
		return ttr_title;
	}
	public void setTtr_title(String ttr_title) {
		this.ttr_title = ttr_title;
	}
	public String getTtr_date() {
		return ttr_date;
	}
	public void setTtr_date(String ttr_date) {
		this.ttr_date = ttr_date;
	}
	public String getTtr_sdate() {
		return ttr_sdate;
	}
	public void setTtr_sdate(String ttr_sdate) {
		this.ttr_sdate = ttr_sdate;
	}
	public String getTtr_edate() {
		return ttr_edate;
	}
	public void setTtr_edate(String ttr_edate) {
		this.ttr_edate = ttr_edate;
	}
	public String getTtr_place() {
		return ttr_place;
	}
	public void setTtr_place(String ttr_place) {
		this.ttr_place = ttr_place;
	}
	public String getTtr_time() {
		return ttr_time;
	}
	public void setTtr_time(String ttr_time) {
		this.ttr_time = ttr_time;
	}
	public String getTtr_alert() {
		return ttr_alert;
	}
	public void setTtr_alert(String ttr_alert) {
		this.ttr_alert = ttr_alert;
	}
	public String getTtr_content() {
		return ttr_content;
	}
	public void setTtr_content(String ttr_content) {
		this.ttr_content = ttr_content;
	}
	public String getThumb_name() {
		return thumb_name;
	}
	public void setThumb_name(String thumb_name) {
		this.thumb_name = thumb_name;
	}
	public String getSeatmap_name() {
		return seatmap_name;
	}
	public void setSeatmap_name(String seatmap_name) {
		this.seatmap_name = seatmap_name;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public String[] getSeat_grd() {
		return seat_grd;
	}
	public void setSeat_grd(String[] seat_grd) {
		this.seat_grd = seat_grd;
	}
	public String[] getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(String[] seat_no) {
		this.seat_no = seat_no;
	}
	public String[] getSeat_pri() {
		return seat_pri;
	}
	public void setSeat_pri(String[] seat_pri) {
		this.seat_pri = seat_pri;
	}
	public String[] getSeat_time() {
		return seat_time;
	}
	public void setSeat_time(String[] seat_time) {
		this.seat_time = seat_time;
	}
	
	public MusicalVO toMusicalVO(){
		MusicalVO mv=new MusicalVO();
		mv.setTtr_no(ttr_no);
		mv.setCom_id(com_id);
		mv.setTtr_cat(ttr_cat);
		mv.setTtr_title(ttr_title);
		mv.setTtr_place(ttr_place);
		mv.setTtr_time(ttr_time);
		mv.setTtr_alert(ttr_alert);
		mv.setTtr_content(ttr_content);
		mv.setThumb_name(thumb_name);
		mv.setSeatmap_name(seatmap_name);
		mv.setFiles(files);
		mv.setSeat_grd(seat_grd);
		mv.setSeat_no(seat_no);
		mv.setSeat_pri(seat_pri);
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			/*mv.setTtr_date(format.parse(ttr_date));*/
			mv.setTtr_sdate(format.parse(ttr_sdate));
			mv.setTtr_edate(format.parse(ttr_edate));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}	
}




















