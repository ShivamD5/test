package action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import action.Q2modelsubjectstudent;
public class Q2showstudent {
	private String courseid;

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	Connection con;
	public Connection connect() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SIS", "root", "");
			System.out.println("connection established");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return con;
	}
	
	private ArrayList <Q2modelsubjectstudent> subject_student = new ArrayList <Q2modelsubjectstudent>();
	public String execute(){
		Connection connection = connect();
		
		PreparedStatement ps = null;
		try {
			System.out.println("this is the"+courseid);
			ps = connection.prepareStatement("SELECT enroll.StudentId,user.Name,student.photo from enroll,user,student where student.UserId = enroll.StudentId and user.UserId=enroll.StudentId and enroll.CourseId=?;");
			//setQuery("All");
			ps.setString(1,courseid);
			ResultSet rs = ps.executeQuery();
			//createSubjectInfoListFromResultSet(rs, subjectInfoList);
			int count=1;
			while (rs.next()) {
				System.out.println("yes");
				subject_student.add(new Q2modelsubjectstudent(count+"",rs.getString(1),rs.getString(2),rs.getString(3)));
				count++;
			}
			setSubject_student(subject_student);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "success";
		
		
		
		
		
		
		
		
		
		
		
	}

	public ArrayList<Q2modelsubjectstudent> getSubject_student() {
		return subject_student;
	}

	public void setSubject_student(ArrayList<Q2modelsubjectstudent> subject_student) {
		this.subject_student = subject_student;
	}

}
