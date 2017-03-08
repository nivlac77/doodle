package dao;

import java.sql.*;

import MyBeans.*;

public class DBConnection {
	Connection conn = null;

	private void open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/doodledb?useSSL=false", "root", "root");
			System.out.println("Connection established");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception:" + e);
		} catch (SQLException e) {
			System.out.println("Exception:" + e);
		}
	}

	private void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Exception:" + e);
		}

	}

	public void insertUser(User user) {
		open();
		String insertNewRecord = "Insert into user "
				+ "(username, password)"
				+ " values(?,?)";
		PreparedStatement prepStmt = null;

		try {
			prepStmt = conn.prepareStatement(insertNewRecord);
			prepStmt.setString(1, user.getUsername());
			prepStmt.setString(2, user.getPassword());
			prepStmt.executeUpdate();
			System.out.println("new record added");
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally {
			close();
		}
	}
	
	public void insertEvent(Event event) {
		open();
		String insertNewRecord = "Insert into event "
				+ "(name, description, organizer)"
				+ " values(?,?,?)";
		PreparedStatement prepStmt = null;

		try {
			prepStmt = conn.prepareStatement(insertNewRecord);
			prepStmt.setString(1, event.getName());
			prepStmt.setString(2, event.getDescription());
			prepStmt.setString(3, event.getOrganizer());
			prepStmt.executeUpdate();
			System.out.println("new record added");
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally {
			close();
		}
	}
	
	public boolean findUsername(String username){
		open();
		Statement stmt = null;
		boolean userExists = false;
		String selectRecords = "select * from user";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectRecords);
			while(rs.next()){
				if(rs.getString("name") == username)
					userExists = true;
			}
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally{
			close();
		}
		
		return userExists;
	}
	
	public void insertDetail(Detail detail) {
		open();
		String insertNewRecord = "Insert into detail "
				+ "(date, start_time, end_time, event_id)"
				+ " values(?,?,?,?)";
		PreparedStatement prepStmt = null;

		try {
			prepStmt = conn.prepareStatement(insertNewRecord);
			prepStmt.setString(1, detail.getDate());
			prepStmt.setString(2, detail.getStartTime());
			prepStmt.setString(3, detail.getEndTime());
			prepStmt.setInt(3, detail.getEventFK());
			prepStmt.executeUpdate();
			System.out.println("new record added");
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally {
			close();
		}
	}
}
