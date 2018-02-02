package com.musical.domain;

import java.util.Date;

public class MyVO {
	
	private String ttr_no; //글번호
	private String mem_id;//회원 아이디
	private String mem_pw;//회원 비밀번호
	private String mem_name;//회원 이름
	private String mem_gender;//회원 성별
	private Date mem_birth;//회원 생년월일
	private String mem_mail;//회원 메일
	private String mem_mobile;//회원 폰번호
	private String mem_addr;//회원 주소
	private Date mem_date;//회원 가입일
	private String res_id; //예약아이디	
	private String res_date;//예약날짜
	private String res_nom;//좌석번호
	private String seat_id;//좌석id		
	
	public MyVO(){}
	public MyVO(String mem_id, String mem_pw, String mem_name,
			String mem_gender, Date mem_birth, String mem_mail,
			String mem_mobile, String mem_addr, Date mem_date, String res_id,
			String res_date, String res_nom, String seat_id, String ttr_no) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_gender = mem_gender;
		this.mem_birth = mem_birth;
		this.mem_mail = mem_mail;
		this.mem_mobile = mem_mobile;
		this.mem_addr = mem_addr;
		this.mem_date = mem_date;
		this.res_id = res_id;
		this.res_date = res_date;
		this.res_nom = res_nom;
		this.seat_id = seat_id;
		this.ttr_no = ttr_no;
	}
	@Override
	public String toString() {
		return "MyVO [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_name="
				+ mem_name + ", mem_gender=" + mem_gender + ", mem_birth="
				+ mem_birth + ", mem_mail=" + mem_mail + ", mem_mobile="
				+ mem_mobile + ", mem_addr=" + mem_addr + ", mem_date="
				+ mem_date + ", res_id=" + res_id + ", res_date=" + res_date
				+ ", res_nom=" + res_nom + ", seat_id=" + seat_id + ", ttr_no="
				+ ttr_no + "]";
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_mobile() {
		return mem_mobile;
	}
	public void setMem_mobile(String mem_mobile) {
		this.mem_mobile = mem_mobile;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public Date getMem_date() {
		return mem_date;
	}
	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getRes_nom() {
		return res_nom;
	}
	public void setRes_nom(String res_nom) {
		this.res_nom = res_nom;
	}
	public String getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}
	public String getTtr_no() {
		return ttr_no;
	}
	public void setTtr_no(String ttr_no) {
		this.ttr_no = ttr_no;
	}
	
	
}

















