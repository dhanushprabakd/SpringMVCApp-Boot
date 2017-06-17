package trng.imcs.app.respirotories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trng.imcs.app.model.Employee;

public class DBQueryExecution {

	public Employee getEmployeeRecords(int empNo) {
		String sqlQuery = "SELECT employees.emp_no,employees.first_name,employees.last_name,employees.gender,dept_name,salary "
				+ "FROM employees inner JOIN dept_emp ON employees.emp_no = dept_emp.emp_no "
				+ "INNER JOIN departments ON departments.dept_no = dept_emp.dept_no "
				+ "INNER JOIN salaries ON employees.emp_no = salaries.emp_no where employees.emp_no = ?";
		// System.out.println(sqlQuery);
		System.out.println(JDBCConnectionFactory.getConnection());
		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setInt(1, empNo);
			ResultSet rs = pstmnt.executeQuery();
			Employee emp = new Employee();

			while (rs.next()) {
				emp.setNumber(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setGender(rs.getString(4));
				emp.setDeptName(rs.getString(5));
				emp.setSalary(rs.getDouble(6));
				
			}

			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
