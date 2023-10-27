package in.ineuron.dto;

import java.io.Serializable;
import java.sql.Date;

public class Librarian implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer libid;
	private String libfname;
	private String liblname;
	private Date doj;
	private String password;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getLibid() {
		return libid;
	}

	public void setLibid(Integer libid) {
		this.libid = libid;
	}

	public String getLibfname() {
		return libfname;
	}

	public void setLibfname(String libfname) {
		this.libfname = libfname;
	}

	public String getLiblname() {
		return liblname;
	}

	public void setLiblname(String liblname) {
		this.liblname = liblname;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Librarian [libid=" + libid + ", libfname=" + libfname + ", liblname=" + liblname + ", doj=" + doj + "]";
	}

}
