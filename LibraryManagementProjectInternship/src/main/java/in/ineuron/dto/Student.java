package in.ineuron.dto;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer sid;
	private String sfname;
	private String slname;
	private String password;
	private Integer fk_libid;
	private Date date;
	private String role;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSfname() {
		return sfname;
	}

	public void setSfname(String sfname) {
		this.sfname = sfname;
	}

	public String getSlname() {
		return slname;
	}

	public void setSlname(String slname) {
		this.slname = slname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getFk_libid() {
		return fk_libid;
	}

	public void setFk_libid(Integer fk_libid) {
		this.fk_libid = fk_libid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sfname=" + sfname + ", slname=" + slname + ", password=" + password
				+ ", fk_libid=" + fk_libid + ", date=" + date + ", role=" + role + "]";
	}

}
