package trng.imcs.app.respirotories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentNameDao {

	public String getDepartmentName(String deptNo) {
		String sqlQuery = "select departments.dept_name from departments where departments.dept_no= ?";
		// System.out.println(sqlQuery);

		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setString(1, deptNo);
			ResultSet rs = pstmnt.executeQuery();

			while (rs.next()) {
				return rs.getString(1);
				
			}

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getDepartmentNumber(int empNo) {
		String sqlQuery = "select dept_emp.dept_no from dept_emp where dept_emp.emp_no = ?";
		// System.out.println(sqlQuery);

		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setInt(1, empNo);
			ResultSet rs = pstmnt.executeQuery();

			while (rs.next()) {
				return rs.getString(1);
				
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	public String findDeptNumber(String deptName) {
		String sqlQuery = "select departments.dept_no from departments where departments.dept_name like ?";
		// System.out.println(sqlQuery);

		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setString(1, deptName);
			ResultSet rs = pstmnt.executeQuery();

			while (rs.next()) {
				return rs.getString(1);
				
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	public boolean addEmployeeDept(String deptName,int empNo, Date date) {
		String deptNo = findDeptNumber(deptName);
		
		String sqlQuery = "Insert into dept_emp (emp_no,dept_no,from_date) values (?,?,?)";
		// System.out.println(sqlQuery);
		
		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setInt(1, empNo);
			pstmnt.setString(2, deptNo);
			pstmnt.setDate(3, date);
			int rowcount = pstmnt.executeUpdate();
			if(rowcount > 0)
				return true;
			else
				return false;

			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean updateEmplpyeeDept(String deptName, int number, Date hireDate) {
		String deptNo = findDeptNumber(deptName);

		String sqlQuery = "update dept_emp set dept_no = ? where emp_no = ?";
		// System.out.println(sqlQuery);
		
		try (Connection conn = JDBCConnectionFactory.getConnection();
				PreparedStatement pstmnt = conn.prepareStatement(sqlQuery)) {
			pstmnt.setString(1, deptNo);
			pstmnt.setInt(2, number);
			
			int rowcount = pstmnt.executeUpdate();
			if(rowcount > 0)
				return true;
			else
				return false;

			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	}
}
