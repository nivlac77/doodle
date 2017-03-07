package exercise1;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
	Connection conn = null;
	private void open(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/company?useSSL=false", "root", "root");
			System.out.println("Connection established");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void close(){
		try{
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void insertEmployee(Employee employee){
		open();
		String insertNewRecord = "Insert into employee "+
									"(name, dept, gender, country, salary)" +
									" values(?,?,?,?,?)";
		PreparedStatement prepStmt = null;
		
		try {
			prepStmt = conn.prepareStatement(insertNewRecord);
			prepStmt.setString(1, employee.getName());
			prepStmt.setString(2, employee.getDepartment());
			prepStmt.setString(3, employee.getGender());
			prepStmt.setString(4, employee.getCountry());
			prepStmt.setDouble(5, employee.getSalary());
			prepStmt.executeUpdate();
			System.out.println("new record added");
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally{
			close();
		}
		
	}
	
	public ArrayList<Employee> findAllEmployees(){
		open();
		Statement stmt = null;
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String selectRecords = "select * from employee";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectRecords);
			while(rs.next()){
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setDepartment(rs.getString("dept"));
				employee.setGender(rs.getString("gender"));
				employee.setCountry(rs.getString("country"));
				employee.setSalary(rs.getDouble("salary"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally{
			close();
		}
		
		return employees;
	}
	
	public void deleteEmployee(int id){
		open();
		String deleteRecord = "delete from employee " +
							  "where id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(deleteRecord);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Record deleted");
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally{
			close();
		}
	}
	
	public Employee findEmployeeById(int id){
		open();
		Employee returnEmp = new Employee();
		String getEmployee = "select * from employee " +
							  "where id = " + id;
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(getEmployee);
			while(rs.next()){
				returnEmp.setId(rs.getInt("id"));
				returnEmp.setName(rs.getString("name"));
				returnEmp.setDepartment(rs.getString("dept"));
				returnEmp.setGender(rs.getString("gender"));
				returnEmp.setCountry(rs.getString("country"));
				returnEmp.setSalary(rs.getDouble("salary"));

			}
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally{
			close();
		}
		return returnEmp;
	}
	
	public void updateEmployee(Employee emp){
		open();
		String updateRecord = "update employee " +
							  "set name = ?, " +
							  "dept = ?, " +
							  "gender = ?, " +
							  "country = ?, " +
							  "salary = ? " +
							  "where id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(updateRecord);
			stmt.setString(1, emp.getName());
			stmt.setString(2, emp.getDepartment());
			stmt.setString(3, emp.getGender());
			stmt.setString(4, emp.getCountry());
			stmt.setDouble(5, emp.getSalary());
			stmt.setInt(6, emp.getId());
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Record updated");
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally{
			close();
		}
	}
}
