package com.musical.domain;

import java.util.Date;

public class Seatinfo {
	
	private String seat_id;//좌석 아이디
	private int ttr_no; //글 번호
	private String seat_grd;//좌석 등급
	private int seat_no;//좌석 번호
	private int seat_pri;//좌석 가격
	private Date seat_date;
	private Date seat_time;//예약시간대
	
	public String getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}
	public int getTtr_no() {
		return ttr_no;
	}
	public void setTtr_no(int ttr_no) {
		this.ttr_no = ttr_no;
	}
	public String getSeat_grd() {
		return seat_grd;
	}
	public void setSeat_grd(String seat_grd) {
		this.seat_grd = seat_grd;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public int getSeat_pri() {
		return seat_pri;
	}
	public void setSeat_pri(int seat_pri) {
		this.seat_pri = seat_pri;
	}
	public Date getSeat_time() {
		return seat_time;
	}
	public void setSeat_time(Date seat_time) {
		this.seat_time = seat_time;
	}
	
	public Date getSeat_date() {
		return seat_date;
	}
	public void setSeat_date(Date seat_date) {
		this.seat_date = seat_date;
	}
	public Seatinfo(){}
	public Seatinfo(String seat_id, int ttr_no, String seat_grd, int seat_no,
			int seat_pri, Date seat_date, Date seat_time) {
		super();
		this.seat_id = seat_id;
		this.ttr_no = ttr_no;
		this.seat_grd = seat_grd;
		this.seat_no = seat_no;
		this.seat_pri = seat_pri;
		this.seat_date = seat_date;
		this.seat_time = seat_time;
	}
	@Override
	public String toString() {
		return "Seatinfo [seat_id=" + seat_id + ", ttr_no=" + ttr_no
				+ ", seat_grd=" + seat_grd + ", seat_no=" + seat_no
				+ ", seat_pri=" + seat_pri + ", seat_date=" + seat_date
				+ ", seat_time=" + seat_time + "]";
	};
}
