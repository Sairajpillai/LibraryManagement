package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	private JdbcUtil() {
		// make the constructor private so that no one can create object of Utility
		// Class
	}

	static {
		// Loading and registering the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		String fileLoc = "G:\\INeuron\\EclipseWorkspaces\\Internship\\LibraryManagementProjectInternship\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		HikariConfig config = new HikariConfig(fileLoc);
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource.getConnection();
		 //return getPhysicalConnection();

	}

	@SuppressWarnings("unused")
	private static Connection getPhysicalConnection() throws FileNotFoundException, IOException, SQLException {
		// Step 2:Establish the connection
		// Take the data from properties File
		String fileLoc = "G:\\INeuron\\EclipseWorkspaces\\Internship\\LibraryManagementInternshipProject\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		FileInputStream fis = new FileInputStream(fileLoc);
		Properties pr = new Properties();
		pr.load(fis);

		// Connection con = DriverManager.getConnection(pr.getProperty("url"),
		// pr.getProperty("username"), pr.getProperty("password"));
		/*
		 * HikariConfig cg = new
		 * HikariConfig("src\\\\in\\\\ineuron\\\\properties\\\\application.properties");
		 * HikariDataSource ds = new HikariDataSource(cg); return ds.getConnection();
		 */

		String url = pr.getProperty("jdbcUrl");
		String username = pr.getProperty("user");
		String password = pr.getProperty("password");

		return DriverManager.getConnection(url, username, password);
	}

	/*
	 * public static void cleanUp(Connection con, Statement st, ResultSet rs) throws
	 * SQLException { // Step 6:Close the resources if (con != null) { con.close();
	 * } if (st != null) { st.close(); } if (rs != null) { rs.close(); } }
	 */

}
