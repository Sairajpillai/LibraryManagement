package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Librarian;
import in.ineuron.util.JdbcUtil;

public class LibrarianDAOImpl implements ILibrarianDAO {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public String saveLibrarian(Librarian librarian) {
		String status = "failure";
		String insertQuery = "insert into librarians(`libfname`,`liblname`,`libdoj`,`password`,`role`) values(?,?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(insertQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setString(1, librarian.getLibfname());
				preparedStatement.setString(2, librarian.getLiblname());
				preparedStatement.setDate(3, (Date) librarian.getDoj());
				preparedStatement.setString(4, librarian.getPassword());
				preparedStatement.setString(5, librarian.getRole());

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
	public Librarian getLiberarian(int id) {
		Librarian lib = null;
		String selectQuery = "select libid,libfname,liblname,libdoj from librarians where libid=?";
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
					lib = new Librarian();
					lib.setLibid(resultSet.getInt(1));
					lib.setLibfname(resultSet.getString(2));
					lib.setLiblname(resultSet.getString(3));
					lib.setDoj(resultSet.getDate(4));
					return lib;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lib;
	}

	@Override
	public String updateLibrarian(Librarian librarian) {
		String sqlUpdateQuery = "update librarians set libfname=?,liblname=? where libid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setString(1, librarian.getLibfname());
				preparedStatement.setString(2, librarian.getLiblname());
				preparedStatement.setInt(3, librarian.getLibid());

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
	public String deleteLibrarian(int sid) {
		String sqlDeleteQuery = "delete from librarians where libid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlDeleteQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, sid);
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
	public String verifyLibrarian(int id,String password) {
		String role=null;
		String selectQuery = "select role from librarians where libid=? and password=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(selectQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, password);
				resultSet = preparedStatement.executeQuery();

			}
			if (resultSet != null) {
				if (resultSet.next()) {
					role = resultSet.getString(1);
					return role;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return role;
	}

}
