package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class enrollcoursedao {

	public static String msg = "";

	public static ArrayList<String> semlist() {
		ArrayList<String> semlist = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SIS", "root", "");

			PreparedStatement ps = con
					.prepareStatement("select distinct SemId from course");
			// System.out.print(username);
			// ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				semlist.add(rs.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return semlist;
	}

	public static ArrayList<String> courselist(int sem) {
		ArrayList<String> course = new ArrayList<String>();
		// System.out.print("ewe");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SIS", "root", "");
				if(sem==0){
					sem=1;
				}
			PreparedStatement ps = con
					.prepareStatement("select Code from course where SemId=?");
			// System.out.print(username);
			System.out.println(sem);
			ps.setInt(1, sem);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				course.add(rs.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

	public static void insertenrolltemp(int semId, String coursename,
			String StudentId) {
		int courseId = 0;
		int count = 0;

		// System.out.print("ewe");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SIS", "root", "");

			PreparedStatement cont = con
					.prepareStatement("Select count(*) as count "
							+ "from (Select StudentID from tempenroll where StudentID=? and SemId=? "
							+ "UNION ALL select StudentID from enroll where StudentID=? and SemId=?)as Stcount");
			cont.setString(1, StudentId);
			cont.setInt(2, semId);
			cont.setString(3, StudentId);
			cont.setInt(4, semId);
			ResultSet rscount = cont.executeQuery();
			if(rscount.next()){
				count = rscount.getInt(1);
			}
			System.out.println(count);
			if (count >= 4)
				msg = "Already registered for 4 courses";
			else {

			//	PreparedStatement ps = con
				//		.prepareStatement("select CourseId from course where Name=?");
				//ps.setString(1, coursename);
				//ResultSet rs = ps.executeQuery();
				//if(rs.next())
				//courseId = rs.getString(1);
				// System.out.print(courseId+"hheheh");
				PreparedStatement pps = con
						.prepareStatement("insert into enroll (StudentId,CourseId,SemId) values(?,?,?)");
				pps.setString(1, StudentId);
				pps.setInt(3, semId);
				pps.setString(2, coursename);
				pps.executeUpdate();
				msg = "Successfully inserted";
			}
		} catch (Exception e) {
			e.printStackTrace();
			//qry = alter table sis.tempenroll add constraint CK_per unique (StudentId,CourseId);
			//for composite ket S_ID and c_ID
			msg = "Already Registered for the course";
		}

	}

}
