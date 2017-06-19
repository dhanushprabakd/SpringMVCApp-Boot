package trng.imcs.app.respirotories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trng.imcs.app.model.Employee;

public class EmployeeDao {

	public Employee getEmployeeRecords(int empNo) {
		String sqlQuery = "SELECT employees.emp_no,employees.first_name,employees.last_name,employees.gender,employees.birth_date,employees.hire_date from employees.employees where employees.emp_no = ?";
		// System.out.println(sqlQuery);
		System.out.println(JDBCConnectionFactory.getConnection());
		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setInt(1, empNo);
			ResultSet rs = pstmnt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();

				emp.setNumber(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setGender(rs.getString(4));
				emp.setBirthDate(rs.getDate(5));
				emp.setHireDate(rs.getDate(6));
				return emp;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
	
	public boolean AddEmployeeRecord(Employee emp) {
		String sqlQuery = "Insert into Employees (emp_no,birth_date,first_name,last_name,gender,hire_date) values(?,?,?,?,?,?)";
		// System.out.println(sqlQuery);
		System.out.println(JDBCConnectionFactory.getConnection());
		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setInt(1, emp.getNumber());
			pstmnt.setDate(2,new Date(emp.getBirthDate().getTime()));
			pstmnt.setString(3, emp.getFirstName());
			pstmnt.setString(4,emp.getLastName());
			pstmnt.setString(5,emp.getGender());
			pstmnt.setDate(6,new Date(emp.getHireDate().getTime()));
			int row = pstmnt.executeUpdate();
			
			if(row>0)
				return true;
			else 
				return false;

			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmployeeRecord(Employee emp) {
		String sqlQuery = "update Employees set emp_no = ?, birth_date = ?,first_name = ? ,last_name =? ,gender = ? , hire_date =? where emp_no = ?";
		// System.out.println(sqlQuery);
		System.out.println(JDBCConnectionFactory.getConnection());
		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setInt(1, emp.getNumber());
			pstmnt.setDate(2,new Date(emp.getBirthDate().getTime()));
			pstmnt.setString(3, emp.getFirstName());
			pstmnt.setString(4,emp.getLastName());
			pstmnt.setString(5,emp.getGender());
			pstmnt.setDate(6,new Date(emp.getHireDate().getTime()));
			pstmnt.setInt(7, emp.getNumber());

			int row = pstmnt.executeUpdate();
			
			if(row>0)
				return true;
			else 
				return false;

			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}


}

