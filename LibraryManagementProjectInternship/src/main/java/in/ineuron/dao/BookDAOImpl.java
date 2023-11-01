package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import in.ineuron.dto.Book;
import in.ineuron.dto.BookHistory;
import in.ineuron.util.JdbcUtil;

public class BookDAOImpl implements IBookDAO {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;

	@Override
	public String saveBook(Book book) {
		String status = "failure";
		String insertQuery = "insert into books(`bookname`,`bookcategory`,`bookqty`,`bookdate`,`fk_libid`,`author`) values(?,?,?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(insertQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setString(1, book.getBookName());
				preparedStatement.setString(2, book.getBookCategory());
				preparedStatement.setInt(3, book.getBookQty());
				preparedStatement.setDate(4, book.getBookDate());
				preparedStatement.setInt(5, book.getFkLibId());
				preparedStatement.setString(6, book.getAuthor());

				int rowEffected = preparedStatement.executeUpdate();
				if (rowEffected == 1) {
					status = "success";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Book getBook(int id) {
		Book book = null;
		String selectQuery = "select bookid,bookname,bookcategory,bookqty,bookdate,author from books where bookid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(selectQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();

			}
			if (resultSet != null) {
				if (resultSet.next()) {
					book = new Book();
					book.setBookId(resultSet.getInt(1));
					book.setBookName(resultSet.getString(2));
					book.setBookCategory(resultSet.getString(3));
					book.setBookQty(resultSet.getInt(4));
					book.setBookDate(resultSet.getDate(5));
					// book.setBookQty(resultSet.getInt(4));
					book.setAuthor(resultSet.getString(6));
					return book;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public String updateBook(Book book) {
		String sqlUpdateQuery = "update books set bookname=?,bookcategory=?,bookqty=?,author=? where bookid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setString(1, book.getBookName());
				preparedStatement.setString(2, book.getBookCategory());
				preparedStatement.setInt(3, book.getBookQty());
				preparedStatement.setString(4, book.getAuthor());
				preparedStatement.setInt(5, book.getBookId());

				int rowEffected = preparedStatement.executeUpdate();
				if (rowEffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {

			e.printStackTrace();
		}
		return "faliure";
	}

	@Override
	public String deleteBook(int id) {
		String sqlDeleteQuery = "delete from books where bookid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlDeleteQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				int rowEffected = preparedStatement.executeUpdate();
				if (rowEffected == 1) {
					return "success";
				} else {
					return "not found";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "failure";
		}
		return "faliure";

	}

	@Override
	public List<Book> searchBook(String bname, String aname, String cat) {
		String bookname = bname;
		String author = aname;
		String bookcategory = cat;
		List<Book> bookList = new ArrayList<Book>();

		// Determine the number of fields with values
		int numberOfFieldsWithValue = 0;
		if (!bookname.isEmpty())
			numberOfFieldsWithValue++;
		if (!author.isEmpty())
			numberOfFieldsWithValue++;
		if (!bookcategory.isEmpty())
			numberOfFieldsWithValue++;
		System.out.println(numberOfFieldsWithValue);
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				statement = connection.createStatement();
			}/*
			StringBuilder sql = new StringBuilder("SELECT bookname,bookcategory,author FROM books");

			if (numberOfFieldsWithValue > 0) {
				sql.append(" WHERE ");
			}

			if (!bookname.isEmpty()) {
				sql.append("bookname = '").append(bookname).append("'");
				if (numberOfFieldsWithValue > 1) {
					sql.append(" AND ");
				}
			}

			if (!author.isEmpty()) {
				sql.append("author = '").append(author).append("'");
				if (numberOfFieldsWithValue > 2) {
					System.out.println("inside author");
					sql.append(" AND ");
				}
			}

			if (!bookcategory.isEmpty()) {
				sql.append("bookcategory = '").append(bookcategory).append("'");
			}*/
			/*
	           StringBuilder sql = new StringBuilder("SELECT bookname,bookcategory,author FROM books");

	            if (numberOfFieldsWithValue > 0) {
	                sql.append(" WHERE ");
	            }

	            boolean needAnd = false; // Flag to track if we need to add an 'AND' clause

	            if (!bookname.isEmpty()) {
	                sql.append("bookname = '").append(bookname).append("'");
	                needAnd = numberOfFieldsWithValue > 1;
	            }

	            if (!author.isEmpty()) {
	                if (needAnd) {
	                    sql.append(" AND ");
	                }
	                sql.append("author = '").append(author).append("'");
	                needAnd = numberOfFieldsWithValue > 2;
	            }

	            if (!bookcategory.isEmpty()) {
	                if (needAnd) {
	                    sql.append(" AND ");
	                }
	                sql.append("bookcategory = '").append(bookcategory).append("'");
	            }*/
			
	           StringBuilder sql = new StringBuilder("SELECT bookid,bookname,bookcategory,author FROM books WHERE ");

			
			 if (!bookname.isEmpty()) {
	                sql.append("bookname = '").append(bookname).append("'");
	            }
	            if (!author.isEmpty()) {
	                if (!bookname.isEmpty()) {
	                    sql.append(" AND ");
	                }
	                sql.append("author = '").append(author).append("'");
	            }
	            if (!bookcategory.isEmpty()) {
	                if (!bookname.isEmpty() || !author.isEmpty()) {
	                    sql.append(" AND ");
	                }
	                sql.append("bookcategory = '").append(bookcategory).append("'");
	            }

			if (statement != null) {
				System.out.println(sql.toString());
				resultSet = statement.executeQuery(sql.toString());
			}
			if (resultSet != null) {
				while (resultSet.next()) {
					System.out.println("Entered booklist");
					Book book = new Book();
					book.setBookId(resultSet.getInt(1));
					book.setBookName(resultSet.getString(2));
					book.setBookCategory(resultSet.getString(3));
					book.setAuthor(resultSet.getString(4));
					bookList.add(book);
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}

		return bookList;
	}

	@Override
	public Boolean checkBook(Integer bookid, Integer sid) {
		Boolean result = false;
		int rowcount=0;
		String selectQuery = "select count(*) as row_count from book_history where bookid_fk=? and sid_fk=? and rdate IS NULL";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(selectQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, bookid);
				preparedStatement.setInt(2, sid);
				resultSet = preparedStatement.executeQuery();

			}
			
			if (resultSet != null) {
				if (resultSet.next()) {
					rowcount=resultSet.getInt("row_count");
				}
			}
			if(rowcount==1) {
				result=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String issueBook(BookHistory bookhistory) {
		String status = "failure";
		String insertQuery = "insert into book_history(`reqdate`,`bookid_fk`,`sid_fk`,`erdate`) values(?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(insertQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setDate(1, bookhistory.getReqdate());
				preparedStatement.setInt(2, bookhistory.getBookid_fk());
				preparedStatement.setInt(3, bookhistory.getSid_fk());
				preparedStatement.setDate(4, bookhistory.getErdate());

				int rowEffected = preparedStatement.executeUpdate();
				if (rowEffected == 1) {
					status = "success";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean bookEligibility(int id) {
		Boolean result = true;
		int rowcount=0;
		//String selectQuery = "select count(*) as row_count from book_history where sid_fk=? and idate IS NOT NULL;";
		String selectQuery = "select count(*) as row_count from book_history where sid_fk=? and rdate is NULL and idate is not null;";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(selectQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();

			}
			
			if (resultSet != null) {
				if (resultSet.next()) {
					rowcount=resultSet.getInt("row_count");
					System.out.println(rowcount+"rowcount");
				}
			}
			if(rowcount==3) {
				result=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Boolean bookEligibility2(int id) {
		Boolean result = true;
		int rowcount=0;
		//String selectQuery = "select count(*) as row_count from book_history where sid_fk=? and idate IS NOT NULL;";
		String selectQuery = "select count(*) as row_count from book_history where sid_fk=? and rdate is NULL and reqdate is not null;";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(selectQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();

			}
			
			if (resultSet != null) {
				if (resultSet.next()) {
					rowcount=resultSet.getInt("row_count");
					System.out.println(rowcount+"rowcount");
				}
			}
			if(rowcount==3) {
				result=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<BookHistory> pendingRequest(int id) {
		BookHistory bookhistory = null;
		List<BookHistory> pendingRequestList = new ArrayList<BookHistory>();
		String sqlQuery = "select bookname,bookcategory,author,reqdate from book_history bh inner join books b on \r\n"
				+ "bh.bookid_fk=b.bookid where bh.sid_fk=? and bh.idate is null";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();

			}
			if (resultSet != null) {
				while (resultSet.next()) {
					bookhistory = new BookHistory();
					bookhistory.setBookname(resultSet.getString(1));
					bookhistory.setBookcategory(resultSet.getString(2));
					bookhistory.setAuthor(resultSet.getString(3));
					bookhistory.setReqdate(resultSet.getDate(4));
					pendingRequestList.add(bookhistory);
					//return book;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pendingRequestList;
	}

	@Override
	public List<BookHistory> bookHistory(int id) {
		BookHistory bookhistory = null;
		List<BookHistory> bookHistoryList = new ArrayList<BookHistory>();
		String sqlQuery = "SELECT books.bookname,books.bookcategory,books.author, \r\n"
				+ "librarians.libfname,\r\n"
				+ "book_history.idate,book_history.reqdate,book_history.penalty,book_history.amountstatus,book_history.erdate,book_history.rdate\r\n"
				+ "FROM book_history\r\n"
				+ "INNER JOIN books ON book_history.bookid_fk = books.bookid\r\n"
				+ "INNER JOIN librarians ON book_history.libid_fk = librarians.libid where book_history.sid_fk=?;";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();

			}
			if (resultSet != null) {
				while (resultSet.next()) {
					bookhistory = new BookHistory();
					bookhistory.setBookname(resultSet.getString(1));
					bookhistory.setBookcategory(resultSet.getString(2));
					bookhistory.setAuthor(resultSet.getString(3));
					
					bookhistory.setLibfname(resultSet.getString(4));
					
					bookhistory.setIdate(resultSet.getDate(5));
					bookhistory.setReqdate(resultSet.getDate(6));
					bookhistory.setPenalty(resultSet.getInt(7));
					bookhistory.setAmountStatus(resultSet.getString(8));
					bookhistory.setErdate(resultSet.getDate(9));
					bookhistory.setRdate(resultSet.getDate(10));
					bookHistoryList.add(bookhistory);
					//return book;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookHistoryList;
	}

	@Override
	public List<BookHistory> getBookRequest() {
		BookHistory bookhistory = null;
		List<BookHistory> requestBookList = new ArrayList<BookHistory>();
		String sqlQuery = "select bookname,bookcategory,author,reqdate,bookid,bhid from book_history bh inner join books b on \r\n"
				+ "bh.bookid_fk=b.bookid where bh.idate is null";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlQuery);
			}
			if (preparedStatement != null) {
				resultSet = preparedStatement.executeQuery();

			}
			if (resultSet != null) {
				while (resultSet.next()) {
					bookhistory = new BookHistory();
					bookhistory.setBookname(resultSet.getString(1));
					bookhistory.setBookcategory(resultSet.getString(2));
					bookhistory.setAuthor(resultSet.getString(3));
					bookhistory.setReqdate(resultSet.getDate(4));
					bookhistory.setBookid_fk(resultSet.getInt(5));
					bookhistory.setBhid(resultSet.getInt(6));
					
					requestBookList.add(bookhistory);
					//return book;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestBookList;
	}

	@Override
	public Integer getBookQty(int id) {
		String sqlGetQty = "select bookqty from books where bookid=?";
		Integer bookQty = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlGetQty);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();

			}
			if (resultSet != null) {
				if (resultSet.next()) {
					bookQty=resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookQty;
	}

	@Override
	public String approveBook(Date idate, Date erdate, int libid,int bhid) {
		String sqlUpdateQuery = "UPDATE book_history SET idate=?, libid_fk=?, erdate=? WHERE bhid=?";
		String status = "failure";
		Integer rowsEffected = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setDate(1, idate);
				preparedStatement.setInt(2, libid);
				preparedStatement.setDate(3, erdate);
				preparedStatement.setInt(4, bhid);
				rowsEffected = preparedStatement.executeUpdate();
			}
			if(rowsEffected==1) {
				status="success";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String updateBookQty(int bookId) {
		String sqlUpdateQuery = "UPDATE books SET bookqty = bookqty - 1 WHERE bookid=?;";
		String status = "failure";
		Integer rowsEffected = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, bookId);
				rowsEffected = preparedStatement.executeUpdate();
			}
			if(rowsEffected==1) {
				status="success";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<BookHistory> getIssuedBookList(int id) {
		BookHistory bookhistory = null;
		List<BookHistory> requestBookList = new ArrayList<BookHistory>();
		String sqlQuery = "SELECT books.bookname,books.bookcategory,books.author, librarians.libfname,\r\n"
				+ "book_history.idate,book_history.bhid,book_history.penalty,\r\n"
				+ "book_history.amountstatus,book_history.erdate,book_history.bookid_fk\r\n"
				+ "FROM book_history\r\n"
				+ "INNER JOIN books ON book_history.bookid_fk = books.bookid\r\n"
				+ "INNER JOIN librarians ON book_history.libid_fk = librarians.libid where book_history.sid_fk=? and rdate is null;";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();

			}
			if (resultSet != null) {
				while (resultSet.next()) {
					bookhistory = new BookHistory();
					bookhistory.setBookname(resultSet.getString(1));
					bookhistory.setBookcategory(resultSet.getString(2));
					bookhistory.setAuthor(resultSet.getString(3));
					bookhistory.setLibfname(resultSet.getString(4));
					bookhistory.setIdate(resultSet.getDate(5));
					bookhistory.setBhid(resultSet.getInt(6));
					bookhistory.setErdate(resultSet.getDate(9));
					bookhistory.setBookid_fk(resultSet.getInt(10));
					
					requestBookList.add(bookhistory);
					//return book;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestBookList;
	}

	@Override
	public String updateBookQtyAccept(int bookid) {
		String sqlUpdateQuery = "UPDATE books SET bookqty = bookqty + 1 WHERE bookid=?;";
		String status = "failure";
		Integer rowsEffected = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, bookid);
				rowsEffected = preparedStatement.executeUpdate();
			}
			if(rowsEffected==1) {
				status="success";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String acceptBook(int bhid, int amount, String amountStatus, Date rdate) {
		String sqlUpdateQuery = "UPDATE book_history SET penalty=?, amountstatus=?, rdate=? WHERE bhid=?";
		String status = "failure";
		Integer rowsEffected = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, amount);
				preparedStatement.setString(2, amountStatus);
				preparedStatement.setDate(3, rdate);
				preparedStatement.setInt(4, bhid);
				rowsEffected = preparedStatement.executeUpdate();
			}
			if(rowsEffected==1) {
				status="success";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	
}
