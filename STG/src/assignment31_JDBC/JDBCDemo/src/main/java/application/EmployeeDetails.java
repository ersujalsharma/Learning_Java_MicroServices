package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmployeeDetails {
	private static final Log LOGGER = LogFactory.getLog(EmployeeDetails.class);

	public static void main(String[] args) {
		//Replace 3rd and 4th parameters with your database credentials.
		DatabaseCredentials dc = new DatabaseCredentials("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/jdbc_demo", "root", "root");
		
		
		String sql = "select * from employee";

		try (
				// Opening a connection
				Connection connection = DriverManager.getConnection(dc.dbUrl(), dc.username(), dc.password());

				Statement statement = connection.createStatement();
				// Executing the query
				ResultSet resultset = statement.executeQuery(sql)) {
			// Registering the JDBC driver
			Class.forName(dc.jdbcDriver());
			
			// Extracting the result
			// The next() method moves the cursor forward by one row from it current
			// position in the resultset
			while (resultset.next()) {
				// getInt() gets the value of a column as integer
				// getString() gets the value of a column as string
				// Retrieve by column id
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				int age = resultset.getInt(3);

				// Displaying the values
				LOGGER.info("Id: " + id + ", Name: " + name + ", Age: " + age);

			}
		} catch (SQLException se) {
			// This handles errors for JDBC
			LOGGER.info(se);
		} catch (Exception e) {
			// This handles errors for Class.forName
			LOGGER.info(e);
		}
	}
}
