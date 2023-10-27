package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Book;
import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDAOImpl implements IStudentDAO {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public String saveStudent(Student student) {
		String status = "failure";
		String insertQuery = "insert into students(`sfname`,`slname`,`password`,`fk_libid`,`date`,`role`) values(?,?,?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(insertQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setString(1, student.getSfname());
				preparedStatement.setString(2, student.getSlname());
				preparedStatement.setString(3, student.getPassword());
				preparedStatement.setInt(4, student.getFk_libid());
				preparedStatement.setDate(5, student.getDate());
				preparedStatement.setString(6, student.getRole());

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
	public Student getStudent(int id) {
		Student student = null;
		String selectQuery = "select sid,sfname,slname,password,fk_libid,date from students where sid=?";
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
					student = new Student();
					student.setSid(resultSet.getInt(1));
					student.setSfname(resultSet.getString(2));
					student.setSlname(resultSet.getString(3));
					student.setPassword(resultSet.getString(4));
					student.setDate(resultSet.getDate(6));
					return student;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		String sqlUpdateQuery = "update students set sfname=?,slname=?,password=?,fk_libid=?,date=? where sid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (preparedStatement != null) {
				preparedStatement.setString(1, student.getSfname());
				preparedStatement.setString(2, student.getSlname());
				preparedStatement.setString(3, student.getPassword());
				preparedStatement.setInt(4, student.getFk_libid());
				preparedStatement.setDate(5, student.getDate());
				preparedStatement.setInt(6, student.getSid());

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
	public String deleteStudent(int id) {
		String sqlDeleteQuery = "delete from students where sid=?";
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
	public String verifyStudent(int id,String password) {
		String role=null;
		String selectQuery = "select role from students where sid=? and password=?";
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
