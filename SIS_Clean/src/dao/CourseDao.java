package dao;
/*
*
* 
author: Shifali(MT2014112) 
*
*
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.opensymphony.xwork2.ActionSupport;

public class CourseDao extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String driverName="com.mysql.jdbc.Driver";
	
	static final String URL = "jdbc:mysql://localhost:3306/SIS";
	private static final String username="root";
	private static final String password="";
	private String cid;
	private  String code;
	private  String name;
	private  String credit;
	private String register;
//	private String fid;
	public List<String> facultyList;
	private List<String> subjectList;
	private String semid;
	static private String syllabus;
	private String demo;
	private List<String> fid;

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	

	

	/*public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}*/

	public List<String> getFacultyList() {
		return facultyList;
	}

	public List<String> getFid() {
		return fid;
	}

	public void setFid(List<String> fid) {
		this.fid = fid;
	}

	public void setFacultyList(List<String> facultyList) {
		this.facultyList = facultyList;
	}

	public String getSemid() {
		return semid;
	}

	public void setSemid(String semid) {
		this.semid = semid;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	/**
	 * this method creates the database connection
	 * @return Connection
	 */
	
	public  static Connection getConnection()
	{

		Connection connection = null;
		try
		{
			Class.forName(driverName);
			
			connection=	DriverManager.getConnection(URL,username,password);

		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	PreparedStatement preparedStatement = null;
	public String execute() throws SQLException
	
	{
		//setDemo("abc");
		initSubjects();
		Connection connection = null;
		
		
	    	
	    	 	connection = getConnection();
	    	 	/*String fquery="select UserId from User where UserType='F' ;";
	    	 	preparedStatement = connection.prepareStatement(fquery);
	    	 	ResultSet rs=preparedStatement.executeQuery();
	    	 	while(rs.next())
	    	 	{
	    	 		facultyList.add(rs.getString(1));
	    	 	}*/
	    	 	String Query="insert into Course( CourseId ,Code ,Name ,Credits, LastDate ,FacultyId ,SemId ,Syllabus)" +
	    	 			" values(?,?,?,?,?,?,?,?);";
	    	 	preparedStatement = connection.prepareStatement(Query);
	    	 	System.out.println(getCid());
	    	 	System.out.println(getRegister());
	    	 	System.out.println(getCode());
	    	 	System.out.println(getCredit());
	    	 	System.out.println(getFid());
	    	 	System.out.println(getSyllabus());
	    	 	preparedStatement.setString(1, getCid() );
	    	 	
	    	 	preparedStatement.setString(2, getCode() );
	    	 	preparedStatement.setString(3, getName() );
	    	 	preparedStatement.setInt(4, Integer.parseInt(getCredit()) );
	    	 	preparedStatement.setString(5, getRegister() );
	    	 	preparedStatement.setString(6, null);
	    	 	/*if(fid.equalsIgnoreCase("Faculty Not Available"))
	    	 	preparedStatement.setString(6, "");
	    	 	else
	    	 	preparedStatement.setString(6, getFid() );*/
	    	 	preparedStatement.setInt(7, Integer.parseInt(getSemid()) );
	    	 	preparedStatement.setString(8, getSyllabus() );
	    	 	preparedStatement.executeUpdate();
	    	 	String query="insert into coursefac values(?,?);";
	    	 	int i=0;
	    	 	if(fid.size()==0)
	    	 	{
	    	 		preparedStatement=connection.prepareStatement(query);
		    	 	preparedStatement.setString(1,code );
		    	 	preparedStatement.setString(2,"");
		    	 	preparedStatement.executeUpdate();
	    	 	}
	    	 	
	    	 	while(i<fid.size())
	    	 	{
	    	 		preparedStatement=connection.prepareStatement(query);
		    	 	preparedStatement.setString(1,code );
		    	 	if(fid.get(i).toString().equalsIgnoreCase("Faculty Not Available"))
		    	 		preparedStatement.setString(2,"");
		    	 	else
		    	 	preparedStatement.setString(2, fid.get(i).toString());
		    	 	preparedStatement.executeUpdate();
		    	 	System.out.println(fid.get(i));
		    	 	i++;
	    	 	}
	    	 	return "success";
	    	 	
	    	 	
	  
	}
	public ArrayList<String> streamlist = new ArrayList<String>();
	public String initSubjects() throws SQLException {
		
		Connection connection = null;
	
    	facultyList=new ArrayList<String>();
    	facultyList.add("Faculty Not available");
	 	connection = getConnection();
	 	String fquery="select UserId from User where UserType='F' ;";
	 	preparedStatement = connection.prepareStatement(fquery);
	 	ResultSet rs=preparedStatement.executeQuery();
	 	while(rs.next())
	 	{
	 		facultyList.add(rs.getString(1));
	 	}
	 	connection = getConnection();
	 	//String fquery="select UserId from User where UserType='F' ;";
	 	preparedStatement = connection.prepareStatement(fquery);
	 	ResultSet rs1=preparedStatement.executeQuery("select stream113 from stream; ");
	 	while(rs1.next())
	 	{
	 		streamlist.add(rs1.getString(1));
	 	}
		
		return SUCCESS;
	}
	public String updateSubjects() throws SQLException
	{
		subjectList=new ArrayList<String>();
		facultyList=new ArrayList<String>();
		Connection connection = null;
		connection = getConnection();
		String  query="select Code from coursefac where FacultyId='';";
		preparedStatement = connection.prepareStatement(query);
	 	ResultSet rs=preparedStatement.executeQuery();
	 	while(rs.next())
	 	{
	 		subjectList.add(rs.getString(1));
	 	}
	 	query="select UserId from User where UserType='F' ;";
	 	preparedStatement = connection.prepareStatement(query);
	 	 rs=preparedStatement.executeQuery();
	 	while(rs.next())
	 	{
	 		facultyList.add(rs.getString(1));
	 	}
		return SUCCESS;
		
	}
	
	//function when faculty for the subject is introduced
	public String update() throws SQLException
	{
		Connection connection = null;
		connection = getConnection();
		String query="delete from coursefac where Code=? && FacultyId='';";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, code);
		preparedStatement.executeUpdate();
		
		query="insert into coursefac values(?,?);";
		int i=0;
		while(i<fid.size())
		{
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,code );
		preparedStatement.setString(2, fid.get(i).toString());
		i++;
		preparedStatement.executeUpdate();
		}
		return SUCCESS;
	}
	
	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	public List<String> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
	}
	//String syllabus;

	public ArrayList<String> getStreamlist() {
		return streamlist;
	}

	public void setStreamlist(ArrayList<String> streamlist) {
		this.streamlist = streamlist;
	}
	


	/*public List<String> getFid() {
		return fid;
	}

	public void setFid(List<String> selectedValues) {
		this.fid = fid;
	}*/
	  

}

