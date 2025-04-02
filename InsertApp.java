package in.abc.main;

//rt.jar => jdk s/w
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//MYSQL-JAR => given by mysql db vendor
import com.mysql.cj.jdbc.Driver;

public class InsertApp {

	public static void main(String[] args) throws SQLException {

		// 1.Loading and Register the Driver
//		Driver driver = new Driver();
//		DriverManager.registerDriver(driver);

		// resources used in jdbc application
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// 2. Establish the Connection
		String url = "jdbc:mysql://localhost:3306/enterprisejavabatch1";
		String user = "root";
		String password = "root";

		try {

			connection = DriverManager.getConnection(url, user, password);

			if (connection != null) {

				// 3. Creation of Statement Object to move to the location using connection)
				statement = connection.createStatement();

				if (statement != null) {

					String insertSqlQuery = "insert into student(sname,sage,saddr) values('prateek','27','ckp')";

					// 4.Using Statement Object execute the Query
					int noOfRows = statement.executeUpdate(insertSqlQuery);
					System.out.println("No of rows affected is :: " + noOfRows);

				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. closing the resources used

			if (resultSet != null) {
				resultSet.close();

			}
			if (statement != null) {
				statement.close();

			}
			if (connection != null) {
				connection.close();

			}
		}

	}

}
