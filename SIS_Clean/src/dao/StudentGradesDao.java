package dao;

import java.sql.*;  
import java.util.ArrayList;

import action.StudentGradesAction;
public class StudentGradesDao {

	
ArrayList<StudentGradesAction> list=new ArrayList<StudentGradesAction>();

  
    public ArrayList<StudentGradesAction> displayGrades(String Id,int SemId) throws ClassNotFoundException
	{	Connection connection = null;
	PreparedStatement preparedStatement = null;ResultSet rs=null;
	
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");  
	    	    Connection con=DriverManager.getConnection(  
	    	    "jdbc:mysql://localhost:3306/SIS","root","");  
	    		
	    	 	String Query = "select distinct e.semId,e.StudentId,Name,GradeName from Enroll e,Course c,Grade g,Result r where r.CourseId=c.CourseId and r.GradeID=g.GradeId and e.StudentId=r.StudentId and e.semId=? and r.StudentId=?;";
	    	 
	    	 	
	    	 	preparedStatement = con.prepareStatement(Query);
	    	 	preparedStatement.setInt(1,SemId);
	    	 	preparedStatement.setString(2,Id);
	    	 	
	    	 	rs=preparedStatement.executeQuery();
	    	 	
	    	 	while(rs.next())
	    	 	{StudentGradesAction stg=new StudentGradesAction();
	    	 		stg.setSemId(rs.getInt(1));
	    	 		stg.setStudentId(rs.getString(2));
	    	 		stg.setCName(rs.getString(3));
	    	 		stg.setGrade(rs.getString(4));
	    	 		list.add(stg);

					
	    	 		
	    	 	}
	    	 	
	    	 	 for(StudentGradesAction i:list)
				 {
					 System.out.println(i.getCName()+"dao");
				 }
					
	    	 	}
	    	 	
	 			catch (SQLException e)
	 			{	
	
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





