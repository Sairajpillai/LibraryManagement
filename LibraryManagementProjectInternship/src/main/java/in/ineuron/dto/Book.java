package in.ineuron.dto;

import java.io.Serializable;
import java.sql.Date;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer bookId;
	private String bookName;
	private String bookCategory;
	private Integer bookQty;
	private Date bookDate;
	private Integer fkLibId;
	private String author;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Integer getBookQty() {
		return bookQty;
	}

	public void setBookQty(Integer bookQty) {
		this.bookQty = bookQty;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Integer getFkLibId() {
		return fkLibId;
	}

	public void setFkLibId(Integer fkLibId) {
		this.fkLibId = fkLibId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookCategory=" + bookCategory + ", bookQty="
				+ bookQty + ", bookDate=" + bookDate + ", fkLibId=" + fkLibId + ", author=" + author + "]";
	}

}
