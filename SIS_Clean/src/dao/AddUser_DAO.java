package dao;
import action.AddUser;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.naming.NamingException;

public class AddUser_DAO {
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

	public void InsertStudent() {

	}

	public void addInterest(List<String> list,String userid) {
		 PreparedStatement ps = null;
         Connection connection=connect();
		 try {
				//ps = connection.prepareStatement("select int_name from interest");
			 
			 for(int i=0;i<list.size();i++)
				 
				 
			 {
				 ps=connection.prepareStatement("INSERT INTO student_interest (student_id,interest) VALUES (?,?);");
				 ps.setString(1, userid);
				 ps.setString(2,list.get(i) );
				 ps.executeUpdate();
				 
				 
				 
			 }
			 
	          
	          
			
	          }
			
	          catch (SQLException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
		

	}
	
	public  ArrayList<String> select_interest(){
		ArrayList<String> list=new ArrayList<String>();
		
		 PreparedStatement ps = null;
         Connection connection=connect();
         
          try {
			ps = connection.prepareStatement("select int_name from interest");
		
         ResultSet rs = ps.executeQuery();
          while(rs.next())
          {
              list.add(rs.getString(1));
          }
		
          }
		
          catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
		
		return list;
		
	}

	public int UserTableInsert(AddUser newUser) throws NamingException,
			SQLException, FileNotFoundException {
		int ret=-1;
		try {
			
			Calendar cal = Calendar.getInstance();
			java.util.Date Now = cal.getTime();
			// Timestamp ct = new Timestamp(Now.getTime());
			java.sql.Timestamp ct = new java.sql.Timestamp(Now.getTime());
			String query = "insert into User(UserId,Name,Password,Email,UserType,LastLogged) values(?,?,?,?,?,?)";
			PreparedStatement preStmt = null;
			AddUser_DAO dc = new AddUser_DAO();
			Connection con = dc.connect();
			preStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preStmt.setString(1, newUser.getUserId());
			preStmt.setString(2, newUser.getName());
			preStmt.setString(3, newUser.getPassword());
			preStmt.setString(4, newUser.getEmailId());
			preStmt.setString(5, "S");
			preStmt.setTimestamp(6, ct);// Because Student
			
			
			ret = preStmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public int StudentTableInsert(AddUser newUser) throws NamingException, SQLException,
	FileNotFoundException {
	String query = "insert into Student(UserId,Photo,Address,DOB,Specialization) values(?,?,?,?,?)";
	PreparedStatement preStmt = null;
	AddUser_DAO dc = new AddUser_DAO();
	int ret =-1;
	try {
		Connection con = dc.connect();
		preStmt = con.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS);
		preStmt.setString(1, newUser.getUserId());
		/*Code For BLOB insert into database
		 * String filePath = servletRequest.getSession().getServletContext()
				.getRealPath("/");
		System.out.println("Server path:" + filePath);
		File fileToCreate = new File(filePath, this.userImageFileName);

		FileUtils.copyFile(this.UserImage, fileToCreate);
		FileInputStream inputStream = new FileInputStream(fileToCreate);
		
		
		preStmt.setBlob(2, inputStream);
		*/
		preStmt.setString(2, newUser.getFinalPath());
		preStmt.setString(3, newUser.getAddress());

		if (null == newUser.getDOB()) 
		{
			newUser.setDOB("11/09/1989");
		}
	/*	Date dobDate = null;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dobDate = new Date(formatter.parse(newUser.getDOB()).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		String arr[] = newUser.getDOB().split("T");
		preStmt.setString(4, arr[0]);
	/*	preStmt.setDate(4, dobDate);*/
		preStmt.setString(5, newUser.getSpecialization());
		ret = preStmt.executeUpdate();
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ret;


}}