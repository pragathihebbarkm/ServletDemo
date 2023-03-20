package com.mywebapp.utils;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mywebapp.model.Student;

public class StudentDataUtil {

	List<Student> students = new ArrayList<>();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	private DataSource datasource;
	
	
	public StudentDataUtil(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = this.datasource.getConnection();
			stmt = con.createStatement();
			ResultSet resultSet=stmt.executeQuery("select * from student order by id");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String fname = resultSet.getString("first_name");
				String lname = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				
				Student student = new Student(id,fname, lname, email);
				students.add(student);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(con,stmt,rs);
		}
		return students;
	}
	
	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(int studentId) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = this.datasource.getConnection();
			String sql="delete from student where id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			stmt.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(con,stmt,null);
		}
		
	}

	public Student getStudent(int studentId) {
		Student student = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = this.datasource.getConnection();
			String sql="delete from student where id=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String fname = resultSet.getString("first_name");
				String lname = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				
				student = new Student(id,fname, lname, email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(con,stmt,rs);
		}
		return student;
	}

	public void updateStudent(int studentId, String firstname, String lastname, String email) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = this.datasource.getConnection();
			String sql="update student set first_name=?, last_name=?, email=? where id=?";
			stmt = con.prepareStatement(sql);
	
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, email);
			stmt.setInt(4, studentId);
			
			stmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(con,stmt,null);
		}
	}
	
}
