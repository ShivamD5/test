package dao;
import action.Q2modelstreamsubject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import action.Q2AddStream;
import action.SubjectInfo;
import action.Q2modelstreamsubject;
public class SubjectsDisplay {
	private static final String driverName = "com.mysql.jdbc.Driver";
	/*
	 * private static final String ENROLLED_COURSES_QUERY=
	 * "select Course.CourseId,Course.Code,Course.Name,Course.SemId,User.Name,Grade.GradeName "
	 * + "from Course, User, Result,Grade " +
	 * "where Result.StudentId=? && Course.CourseId=Result.CourseId && UserType='F' && Course.FacultyId=User.UserId && Result.GradeId=Grade.GradeId ;"
	 * ;
	 */
	private static final String ENROLLED_COURSES_QUERY = "select distinct course.CourseId,course.Code,course.Name,course.SemId,user.Name,grade.GradeName from course, user, result, grade,coursefac where result.StudentId= ? && course.CourseId=result.CourseId && user.UserType='F' && coursefac.FacultyId=user.UserId && result.GradeId=grade.GradeId;";

	private static final String ALL_COURSES_QUERY = "select distinct course.CourseId,course.Code,course.Name,course.SemId,user.Name "
			+ "from course, user,coursefac where UserType='F' && coursefac.FacultyId=user.UserId;";
	

	static final String URL = "jdbc:mysql://localhost:3306/SIS";
	private static final String username = "root";
	private static final String password = "";
	private static String user;
	private static String query;
	
//vaneet	private static final String ENROLLED_COURSES_QUERY = "select distinct course.CourseId,course.Code,course.Name,course.SemId,user.Name,grade.GradeName from course, user, result, grade,coursefac where result.StudentId= ? && course.CourseId=result.CourseId && user.UserType='F' && course.Code=coursefac.Code && coursefac.FacultyId=user.UserId && result.GradeId=grade.GradeId;";

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		SubjectsDisplay.user = user;
	}

	private static Map<String, Object> session;

	public static Map<String, Object> getSession() {
		return session;
	}

	public static void setSession(Map<String, Object> session) {
		SubjectsDisplay.session = session;
	}

	public static Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName(driverName);

			connection = DriverManager.getConnection(URL, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static String CheckCode(String code) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = null;
		String query = "select Code from course;";
		ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("DBCODE " + rs.getString(1));
			System.out.println("USER " + code);
			if (rs.getString(1).equalsIgnoreCase(code))
				return "yes";
		}
		return "no";
	}

	private static void createSubjectInfoListFromResultSet(ResultSet rs,
			List<SubjectInfo> subjectInfoList) throws SQLException {
		int count=1;
		while (rs.next()) {
			String courseId = Integer.toString(rs.getInt(1));
			String subjectCode = rs.getString(2);
			String subjectName = rs.getString(3);
			int semester = rs.getInt(4);
			String facultyName = rs.getString(5);
			String grade;
			if (getQuery().equals("Enrolled")) {
				grade = rs.getString(6);
				System.out.println(grade);
			} else
				grade = null;
			System.out.println(subjectCode);
			// String enrolledVal = rs.getString("student_id");
			// String enrolled = (null == enrolledVal) ? "N" : "Y";
			// String gradeVal = rs.getString("grade_name");
			// String grade = (null == gradeVal) ? "NA" : gradeVal;
			SubjectInfo subjectInfo = new SubjectInfo(courseId, subjectCode,
					subjectName, facultyName, semester, grade);// , enrolled,
																// grade);
			subjectInfoList.add(subjectInfo);
			count++;
		}
	}

	public static List<SubjectInfo> getEnrolledCourses(String user) {
		List<SubjectInfo> subjectInfoList = null;
		PreparedStatement ps = null;
		setUser(user);
		System.out.println("USEr=" + getUser());
		try {
			Connection connection = getConnection();
			subjectInfoList = new ArrayList<SubjectInfo>();
			ps = connection.prepareStatement(ENROLLED_COURSES_QUERY);
			ps.setString(1, getUser());
			ResultSet rs = ps.executeQuery();
			setQuery("Enrolled");
			createSubjectInfoListFromResultSet(rs, subjectInfoList);
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
		return subjectInfoList;
	}

	public static List<SubjectInfo> getAllCourses() {
		Connection connection = getConnection();
		List<SubjectInfo> subjectInfoList = null;
		PreparedStatement ps = null;
		try {
			subjectInfoList = new ArrayList<SubjectInfo>();
			ps = connection.prepareStatement(ALL_COURSES_QUERY);
			setQuery("All");
			ResultSet rs = ps.executeQuery();
			createSubjectInfoListFromResultSet(rs, subjectInfoList);
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
		return subjectInfoList;
	}
	static String syllabus;
	
	public static String getSyllabus(String subjectCode) throws SQLException
    {
         PreparedStatement ps = null;
         Connection connection=getConnection();
         System.out.println(subjectCode);
          ps = connection.prepareStatement("select Syllabus from Course where Code=?");
          ps.setString(1, subjectCode);
          ResultSet rs = ps.executeQuery();
          while(rs.next())
          {
              syllabus=rs.getString(1);
          }
        return syllabus;
    }
	////////////////////////----new my testt change
	public static String username(String rollnumber) throws SQLException
    {	String temp="";
         PreparedStatement ps = null;
         Connection connection=getConnection();
        // System.out.println(subjectCode);
          ps = connection.prepareStatement("select Name from user where UserId=?");
          ps.setString(1, rollnumber);
          ResultSet rs = ps.executeQuery();
          while(rs.next())
          {
              temp=rs.getString(1);
          }
        return temp;
    }
	public static List<SubjectInfo> Q1data(int semid) {
		Connection connection = getConnection();
		List<SubjectInfo> subjectInfoList = null;
		PreparedStatement ps = null;
		try {
			subjectInfoList = new ArrayList<SubjectInfo>();
			ps = connection.prepareStatement("select distinct course.code,course.Name,user.Name from course, user,coursefac where course.SemId=?  && user.UserType='F' && course.code=coursefac.Code && coursefac.FacultyId=user.UserId");
			//setQuery("All");
			ps.setInt(1,semid);
			ResultSet rs = ps.executeQuery();
			//createSubjectInfoListFromResultSet(rs, subjectInfoList);
			int count=1;
			while (rs.next()) {
				String courseId = rs.getString(1);
				String subjectCode = "";
				String subjectName = rs.getString(2);
				int semester = 1;
				String facultyName = rs.getString(3);
				String grade=count+"";
				//courseId = "kj";
				//System.out.println(subjectCode);
				// String enrolledVal = rs.getString("student_id");
				// String enrolled = (null == enrolledVal) ? "N" : "Y";
				// String gradeVal = rs.getString("grade_name");
				// String grade = (null == gradeVal) ? "NA" : gradeVal;
				SubjectInfo subjectInfo = new SubjectInfo(courseId, subjectCode,
						subjectName, facultyName, semester, grade);// , enrolled,
																	// grade);
				subjectInfoList.add(subjectInfo);
				count++;
			}
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
		return subjectInfoList;
	}
	
	
	public static ArrayList <Q2modelstreamsubject> q2streamsubject(String stream) throws SQLException
    {	ArrayList <Q2modelstreamsubject> stream_subject = new  ArrayList <Q2modelstreamsubject>();
         PreparedStatement ps = null;
         Connection connection=getConnection();
         //System.out.println(subjectCode);
          ps = connection.prepareStatement("select Code,Name from Course where CourseId=?");
          ps.setString(1, stream);
          ResultSet rs = ps.executeQuery();
          int count=1;
          while(rs.next())
          {
        	  
				 stream_subject.add(new Q2modelstreamsubject(count+"",rs.getString(1),rs.getString(2)));
				 
				 count++;
              
          }
        return stream_subject;
    }
	
	
	
	
	
	



	/*
	 * public static List<SubjectInfo> getEnrolledCourses() {
	 * 
	 * List<SubjectInfo> subjectInfoList1= null; if
	 * (session.containsKey("user")) { String user = (String)
	 * session.get("user"); //User loggedInUser = (User) this.session.get(USER);
	 * subjectInfoList1=
	 * 
	 * return subjectInfoList1; }
	 */

	public static String getQuery() {
		return query;
	}

	public static void setQuery(String query) {
		SubjectsDisplay.query = query;
	}

}
