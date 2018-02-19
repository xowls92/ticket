package com.musical.domain;

import java.util.Date;

public class ZzimVO {
	
		private int zzim_no;
		private String mem_id;
		private int ttr_no;
		private Date zzim_date;
		public int getZzim_no() {
			return zzim_no;
		}
		public void setZzim_no(int zzim_no) {
			this.zzim_no = zzim_no;
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
		public Date getZzim_date() {
			return zzim_date;
		}
		public void setZzim_date(Date zzim_date) {
			this.zzim_date = zzim_date;
		}
		public ZzimVO(){}
		public ZzimVO(int zzim_no, String mem_id, int ttr_no, Date zzim_date) {
			super();
			this.zzim_no = zzim_no;
			this.mem_id = mem_id;
			this.ttr_no = ttr_no;
			this.zzim_date = zzim_date;
		}
		@Override
		public String toString() {
			return "ZzimVO [zzim_no=" + zzim_no + ", mem_id=" + mem_id
					+ ", ttr_no=" + ttr_no + ", zzim_date=" + zzim_date + "]";
		};
}
