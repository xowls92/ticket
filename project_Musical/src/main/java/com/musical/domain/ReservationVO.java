package com.musical.domain;

import java.util.Date;

public class ReservationVO {

	private String res_id;//예약아이디
	private Date res_date;//예약날짜
	private int res_nom;//좌석 번호
	private String seat_id;//좌석 아이디
	private String mem_id;//회원 아이디
	private int ttr_no;//글번호
	
	public ReservationVO(){}
	public ReservationVO(String res_id, Date res_date, int res_nom,
			String seat_id, String mem_id, int ttr_no) {
		super();
		this.res_id = res_id;
		this.res_date = res_date;
		this.res_nom = res_nom;
		this.seat_id = seat_id;
		this.mem_id = mem_id;
		this.ttr_no = ttr_no;
	}
	@Override
	public String toString() {
		return "ReservationVO [res_id=" + res_id + ", res_date=" + res_date
				+ ", res_nom=" + res_nom + ", seat_id=" + seat_id + ", mem_id="
				+ mem_id + ", ttr_no=" + ttr_no + "]";
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public Date getRes_date() {
		return res_date;
	}
	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}
	public int getRes_nom() {
		return res_nom;
	}
	public void setRes_nom(int res_nom) {
		this.res_nom = res_nom;
	}
	public String getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getTtr_no() {
		return ttr_no;
	}
	public void setTtr_no(int ttr_no) {
		this.ttr_no = ttr_no;
	}
	
	
}
