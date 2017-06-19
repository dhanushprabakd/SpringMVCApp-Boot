package trng.imcs.app.respirotories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSalaryDao {
	public double getSalary(int empNo) {
		String sqlQuery = "Select Salary from salaries where emp_no=?";
		// System.out.println(sqlQuery);

		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setInt(1, empNo);
			ResultSet rs = pstmnt.executeQuery();

			while (rs.next()) {
				return rs.getDouble(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}

	public boolean addEmployeeSalary(Double salary, int number, Date hireDate) {

		String sqlQuery = "Insert into salaries (emp_no,salary,from_date) values (?,?,?)";
		// System.out.println(sqlQuery);

		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setInt(1, number);
			pstmnt.setDouble(2, salary);
			pstmnt.setDate(3, hireDate);
			int rowCount = pstmnt.executeUpdate();

			if (rowCount > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateEmployeeSalary(double salary, int number, Date hireDate) {

		String sqlQuery = "update salaries set salary = ? where emp_no = ?";
		// System.out.println(sqlQuery);

		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setDouble(1, salary);
			pstmnt.setInt(2, number);
			
			int rowCount = pstmnt.executeUpdate();

			if (rowCount > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

}
