package dao;

/*
 *
 * 
 author: Shifali(MT2014112) 
 *
 *
 */
import model.gradeUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import model.st_grade;
public class gradeDao extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String driverName = "com.mysql.jdbc.Driver";

	static final String URL = "jdbc:mysql://localhost:3306/SIS";
	private static final String username = "root";
	private static final String password = "";

	private List<String> courseList, studentList, gradeList;

	public List<String> getcourseList() {
		return courseList;
	}

	public void setcourseList(List<String> courseList) {
		this.courseList = courseList;
	}

	/**
	 * this method creates the database connection
	 * 
	 * @return Connection
	 */

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

	PreparedStatement preparedStatement = null;

	public String insertGradeUpdate(gradeUser gradeUsr) throws SQLException

	{		
		System.out.println(gradeUsr.getGrade());
		if(gradeUsr.getGrade() == null){
			return "success";
		}
		
		if (gradeUsr.getStudentID().equals("Select Student")) {
			return "success";
		}
		ArrayList<Parameter> params = new ArrayList<Parameter>(); 
		ConnectionManager cm = new ConnectionManager();
		params.add(new Parameter<String>(gradeUsr.getCourse(), PARAMETER_TYPE.STRING));
		String query = "select courseID from course where name = ?";
		
		ResultSet rs = cm.executeQuery(query, params);
		int courseID = -1;
		if (rs.next()) {
			courseID = rs.getInt(1);
		}
		
		rs = null;
		params.clear();
		query = "select GradeID from result where StudentId = ? and CourseId = ?";
		params.add(new Parameter<String>(gradeUsr.getStudentID(), PARAMETER_TYPE.STRING));
		params.add(new Parameter<Integer>(courseID, PARAMETER_TYPE.INT));

		rs = cm.executeQuery(query, params);

		params.clear();
		if (!rs.next()) {
			query = "insert into result( StudentId, CourseId, GradeID)"
					+ " values(?,?,?);";
			params.add(new Parameter<String>(gradeUsr.getStudentID(), PARAMETER_TYPE.STRING));
			params.add(new Parameter<Integer>(courseID, PARAMETER_TYPE.INT));
			params.add(new Parameter<String>(gradeUsr.getGrade(), PARAMETER_TYPE.STRING));
			cm.executeUpdate(query, params);
		} else {
			query = "update result set GradeID = ?"
					+ " where  StudentId = ? and CourseId = ?;";
			params.add(new Parameter<String>(gradeUsr.getGrade(), PARAMETER_TYPE.STRING));
			params.add(new Parameter<String>(gradeUsr.getStudentID(), PARAMETER_TYPE.STRING));
			params.add(new Parameter<Integer>(courseID, PARAMETER_TYPE.INT));
			cm.executeUpdate(query, params);
		}
		return "success";

	}
	public String insertGrade(ArrayList<String> sList, ArrayList<String> gList, String course,ArrayList<st_grade> sgradeList) throws SQLException

	{		
		
		if(gList == null){
			return "success";
		}
		//System.out.println(sList + "  " + gList);
		ArrayList<Parameter> params = new ArrayList<Parameter>(); 
		ConnectionManager cm = new ConnectionManager();
		params.add(new Parameter<String>(course, PARAMETER_TYPE.STRING));
		String query = "select courseID from course where name = ?";
		
		ResultSet rs = cm.executeQuery(query, params);
		int courseID = -1;
		if (rs.next()) {
			courseID = rs.getInt(1);
		}
		System.out.println(sgradeList.get(1).grade);
		rs = null;
		int gIndex = 0;
		for(int k = 1; k<sList.size();k++){
			params.clear();
			if(!sgradeList.get(k).grade.equals("Nil")){
				continue;
			}
			query = "select GradeID from result where StudentId = ? and CourseId = ?";
			params.add(new Parameter<String>(sList.get(k), PARAMETER_TYPE.STRING));
			params.add(new Parameter<Integer>(courseID, PARAMETER_TYPE.INT));
			System.out.println("select GradeID from result where StudentId = "+sList.get(k)+ "and CourseId = " + course);
			rs = cm.executeQuery(query, params);
			params.clear();
			if (!rs.next()) {
				query = "insert into result( StudentId, CourseId, GradeID)"
						+ " values(?,?,?);";
				params.add(new Parameter<String>(sList.get(k), PARAMETER_TYPE.STRING));
				params.add(new Parameter<Integer>(courseID, PARAMETER_TYPE.INT));
				params.add(new Parameter<String>(gList.get(gIndex), PARAMETER_TYPE.STRING));
				gIndex++;
				cm.executeUpdate(query, params);
			} else {
				query = "update result set GradeID = ?"
						+ " where  StudentId = ? and CourseId = ?;";
				params.add(new Parameter<String>(gList.get(gIndex), PARAMETER_TYPE.STRING));
				params.add(new Parameter<String>(sList.get(k), PARAMETER_TYPE.STRING));
				params.add(new Parameter<Integer>(courseID, PARAMETER_TYPE.INT));
				gIndex++;
				cm.executeUpdate(query, params);
			}
		}
		
		
		return "success";

	}

	/*public String insertGrade1(gradeUser gradeUsr) throws SQLException

	{
		
		System.out.println(gradeUsr.getGrade());
		if(gradeUsr.getGrade() == null){
			return "success";
		}
		
		if (gradeUsr.getStudentID().equals("Select Student")) {
			return "success";
		}
		Connection connection = null;
		connection = getConnection();
		String preQuery = "select courseID from course where name = ?";
		preparedStatement = connection.prepareStatement(preQuery);
		preparedStatement.setString(1, gradeUsr.getCourse());
		ResultSet rs = preparedStatement.executeQuery();
		int courseID = -1;
		if (rs.next()) {
			courseID = rs.getInt(1);
		}
		rs = null;
		preQuery = "select GradeID from result where StudentId = ? and CourseId = ?";
		preparedStatement = connection.prepareStatement(preQuery);
		preparedStatement.setString(1, gradeUsr.getStudentID());
		preparedStatement.setInt(2, courseID);
		rs = preparedStatement.executeQuery();

		if (!rs.next()) {
			String Query = "insert into result( StudentId, CourseId, GradeID)"
					+ " values(?,?,?);";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setString(1, gradeUsr.getStudentID());
			preparedStatement.setInt(2, courseID);
			preparedStatement.setString(3, (gradeUsr.getGrade()));
			preparedStatement.executeUpdate();
		} else {
			String Query = "update result set GradeID = ?"
					+ " where  StudentId = ? and CourseId = ?;";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setString(1, gradeUsr.getGrade());
			preparedStatement.setString(2, gradeUsr.getStudentID());
			preparedStatement.setInt(3, courseID);
			preparedStatement.executeUpdate();
		}
		return "success";

	}*/

	public String currentGrade(String studentId, String course)
			throws SQLException

	{
		Connection connection = null;

		connection = getConnection();
		String preQuery = "select courseID from course where name = ?";
		preparedStatement = connection.prepareStatement(preQuery);
		preparedStatement.setString(1, course);
		ResultSet rs = preparedStatement.executeQuery();
		int courseID = -1;
		if (rs.next())
			courseID = rs.getInt(1);

		rs = null;
		//System.out.println(studentId + " " + (courseID));
		preQuery = "select GradeID from result where StudentId = ? and CourseId = ?";
		preparedStatement = connection.prepareStatement(preQuery);
		preparedStatement.setString(1, studentId);
		preparedStatement.setInt(2, courseID);
		rs = preparedStatement.executeQuery();
		int gradeID = -1;
		if (rs.next())
			gradeID = rs.getInt(1);
		//System.out.println(gradeID);

		if (gradeID == -1) {
			return null;
		} else {

			String Query = "select GradeName from grade where GradeId = ?";
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, gradeID);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
			return "success";
		}

	}

	public ArrayList<String> fillCourse(String facultyID) throws SQLException {

		Connection connection = null;

		// System.out.println("fillcourse" + facultyID);
		courseList = new ArrayList<String>();
		courseList.add("Select Course ");
		connection = getConnection();
		String fquery = "select distinct name from course,coursefac where coursefac.facultyID = ? and coursefac.code=course.code;";
		preparedStatement = connection.prepareStatement(fquery);
		preparedStatement.setString(1, facultyID);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			courseList.add(rs.getString(1));
		}

		/*
		 * for(String s : courseList) System.out.println(s);
		 */

		return (ArrayList<String>) courseList;
	}
	
	public ArrayList<String> returnGrade(ArrayList<String> sList, String course) throws SQLException {
		gradeList = new ArrayList<String>();
		for( String s: sList){

			gradeList.add(currentGrade(s, course));
		}
		/*
		 * for(String s : studentList) System.out.println(s);
		 */
		return (ArrayList<String>) gradeList;
	}
	public ArrayList<String> courseStudents(String course) throws SQLException {
		// System.out.println(course + "COURSE sTRUNDET  CALLED");
		Connection connection = null;
		
		setStudentList(new ArrayList<String>());
		connection = getConnection();
		String fquery = "select studentID from enroll where "
				+ "courseID in (select courseID from course where name = ? );";
		// System.out.println(fquery);
		preparedStatement = connection.prepareStatement(fquery);
		preparedStatement.setString(1, course);
		ResultSet rs = preparedStatement.executeQuery();
		//studentList.add("Select Student");
		studentList.add("Select Student");
		while (rs.next()) {
			studentList.add(rs.getString(1));
		}
		
		/*
		 * for(String s : studentList) System.out.println(s);
		 */
		return (ArrayList<String>) studentList;
	}

	public List<String> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<String> studentList) {
		this.studentList = studentList;
	}

	public List<String> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<String> gradeList) {
		this.gradeList = gradeList;
	}

}
