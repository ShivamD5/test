package dao;

import java.sql.*;
import java.util.ArrayList;

import action.FacultyRegister;
import action.Login;
import action.StudentGradesAction;

public class RegisterDao {

	public static int insert(FacultyRegister r) {
		int status = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SIS", "root", "");

			PreparedStatement ps = con
					.prepareStatement("insert into Faculty values(null,?,?,?,?)");
			PreparedStatement ps1 = con
					.prepareStatement("insert into User values(null,?,?,?,?,'F',null)");
			ps.setString(1, r.getId());
			ps.setString(2, r.getQuali());
			ps.setString(3, r.getCabin());
			ps.setString(4, r.getImageURL());
			ps1.setString(2, r.getName());
			ps1.setString(1, r.getId());
			ps1.setString(3, r.getPassword());
			ps1.setString(4, r.getEmail());

			ps1.executeUpdate();

			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	ArrayList<Login> list;

	public ArrayList<Login> displayfacultyDetails(String facultyId)
			throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String Name = "", Photo;
		list = new ArrayList<Login>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SIS", "root", "");

			String Query = "select Name,Photo,Qualification,CabinNo,Email from User,Faculty where UserId=? and FacultyId=UserId";

			preparedStatement = con.prepareStatement(Query);
			preparedStatement.setString(1, facultyId);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Login l = new Login();

				l.setFacultyName(rs.getString(1));
				l.setPhoto(rs.getString(2));
				l.setQuali(rs.getString(3));
				l.setCabin(rs.getString(4));
				l.setEmail(rs.getString(5));
				list.add(l);

			}

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}
	public ArrayList<Login> displayStudentDetails(String studentId) throws ClassNotFoundException
	{	Connection connection = null;
	PreparedStatement preparedStatement = null;ResultSet rs=null;String Name="",Photo;
	list = new ArrayList<Login>();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	
	
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");  
	    	    Connection con=DriverManager.getConnection(  
	    	    "jdbc:mysql://localhost:3306/SIS","root","");  
	    		
	    	 	String Query = "select Name,Photo,Email,Address,DOB,Specialization, LastLogged from User,student where User.UserId=? and user.UserId=student.UserId";
	    	 
	    	 	
	    	 	preparedStatement = con.prepareStatement(Query);
	    	 	preparedStatement.setString(1,studentId);
	  
	    	 	
	    	 	rs=preparedStatement.executeQuery();
	    	 	
	    	 	while(rs.next())
	    	 	{Login l=new Login();
    	 		
    	 		l.setStudentName(rs.getString(1));
    	 		l.setPhoto(rs.getString(2));
    	 		l.setEmail(rs.getString(3));
    	 		l.setAddress(rs.getString(4));
    	 		l.setDob(rs.getString(5));
    	 		l.setSpecializ(rs.getString(6));
    	 		java.util.Date date = rs.getTimestamp(7);
    	 		l.setLastLogged(sdf.format(date));
    	 		list.add(l);				
	    	 	}
	    	 	
	    	 
					
	    	 	}
	    	 	
	 			catch (SQLException e)
	 			{	
	 				
	 				//e.printStackTrace();
	 				System.out.println(e.getMessage());
		 
	 			}
	finally {
			try {
				if (preparedStatement != null) {
				preparedStatement.close();
					}
				if (connection != null) {
				connection.close();
				
					}
		} catch (SQLException e) {
			e.printStackTrace();
				}
			}
	
		return list;
		
	}

}
