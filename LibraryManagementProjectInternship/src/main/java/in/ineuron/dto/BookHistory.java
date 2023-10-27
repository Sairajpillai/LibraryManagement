package in.ineuron.dto;

import java.io.Serializable;
import java.sql.Date;

public class BookHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer bhid;
	private Date idate;
	private Date rdate;
	private Integer penalty;
	private String amountStatus;
	private Integer libid_fk;
	private Integer bookid_fk;
	private Integer sid_fk;
	private Date erdate;
	private Date reqdate;

	private String bookcategory;
	private String bookname;
	private String author;

	private String libfname;

	public String getLibfname() {
		return libfname;
	}

	public void setLibfname(String libfname) {
		this.libfname = libfname;
	}

	public String getBookcategory() {
		return bookcategory;
	}

	public void setBookcategory(String bookcategory) {
		this.bookcategory = bookcategory;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getReqdate() {
		return reqdate;
	}

	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}

	public Date getErdate() {
		return erdate;
	}

	public void setErdate(Date erdate) {
		this.erdate = erdate;
	}

	public Integer getBhid() {
		return bhid;
	}

	public void setBhid(Integer bhid) {
		this.bhid = bhid;
	}

	public Date getIdate() {
		return idate;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Integer getPenalty() {
		return penalty;
	}

	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}

	public String getAmountStatus() {
		return amountStatus;
	}

	public void setAmountStatus(String amountStatus) {
		this.amountStatus = amountStatus;
	}

	public Integer getLibid_fk() {
		return libid_fk;
	}

	public void setLibid_fk(Integer libid_fk) {
		this.libid_fk = libid_fk;
	}

	public Integer getBookid_fk() {
		return bookid_fk;
	}

	public void setBookid_fk(Integer bookid_fk) {
		this.bookid_fk = bookid_fk;
	}

	public Integer getSid_fk() {
		return sid_fk;
	}

	public void setSid_fk(Integer sid_fk) {
		this.sid_fk = sid_fk;
	}

	@Override
	public String toString() {
		return "BookHistory [bhid=" + bhid + ", idate=" + idate + ", rdate=" + rdate + ", penalty=" + penalty
				+ ", amountStatus=" + amountStatus + ", libid_fk=" + libid_fk + ", bookid_fk=" + bookid_fk + ", sid_fk="
				+ sid_fk + ", erdate=" + erdate + ", reqdate=" + reqdate + ", bookcategory=" + bookcategory
				+ ", bookname=" + bookname + ", author=" + author + ", libfname=" + libfname + "]";
	}

}
