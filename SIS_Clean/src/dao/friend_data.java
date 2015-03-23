package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class friend_data {

	Connection con;
	PreparedStatement preStmt;

	public friend_data() {
		//con = Pool.getConnection();
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sis","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}
	
	
	public String select_name(String userid) {
		
		String res=null;
		try {
			preStmt = con.prepareStatement("SELECT Name FROM user where UserId=?");
			preStmt.setString(1,userid);
			ResultSet result = preStmt.executeQuery();
			while (result.next()) {
				res=result.getString("Name");
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;

	}
	
	public ArrayList<name_list> select(String name,int page) {
		ArrayList<name_list> list = new ArrayList<name_list>();
		name_list temp;

		try {
			preStmt = con.prepareStatement("SELECT friendId tt,friendName,photo FROM sis.friend,student "
					+ "where friend.friendId=student.userId and friend.UserId=? "
					+ "union SELECT friend.UserId tt,name,photo FROM sis.friend,student "
					+ "where friend.UserId=student.userId and friend.friendId=?;");
			preStmt.setString(1,name);
			preStmt.setString(2,name);
			ResultSet result = preStmt.executeQuery();
			while (result.next()) {
				temp = new name_list(result.getString("friendName"),result.getString("photo"),"Unfriend",result.getString("tt") );
				list.add(temp);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public ArrayList<name_list> search(String name,int page) {
		ArrayList<name_list> list = new ArrayList<name_list>();
		try {
			preStmt = con.prepareStatement("SELECT Student.UserId,name,photo from Student,User where name like ? and Student.UserId=User.UserId;");
			preStmt.setString(1,name+"%");
			ResultSet result = preStmt.executeQuery();
			while (result.next()) {
			list.add(new name_list(result.getString("name"),result.getString("photo"),"Add Friend",result.getString("UserId")));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public String insert(String userid,String name,String friendid,String friendname) {
		try {
			preStmt = con.prepareStatement("INSERT INTO friend"+"(UserId,name,friendId,friendName) VALUES"+ "(?,?,?,?)");
			preStmt.setString(1,userid);
			preStmt.setString(2,name);
			preStmt.setString(3,friendid);
			preStmt.setString(4,friendname);
			preStmt.executeUpdate();
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return "suc";
		

	}
	public String delete(String userid,String friendid) {
		try {
			preStmt = con.prepareStatement("delete from friend where UserId=? and friendId=? ");
			//preStmt = con.prepareStatement("delete from friend where UserId=? and friendId=? ");
			preStmt.setString(1,userid);
			preStmt.setString(2,friendid);
			preStmt.executeUpdate();
			preStmt = con.prepareStatement("delete from friend where UserId=? and friendId=? ");
			preStmt.setString(1,friendid);
			preStmt.setString(2,userid);
			preStmt.executeUpdate();
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "suc";
		

	}
	
	public String notification_insert(String userid,String userid_request){
		
		try {
			preStmt = con.prepareStatement("INSERT INTO notification (UserId,UserId_request) values(?,?)");
			preStmt.setString(1,userid);
			preStmt.setString(2,userid_request);
			preStmt.executeUpdate();
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "suc";
	}
	
	public ArrayList<name_list> notification_select(String userid){
		System.out.println("Inside noitifcation select"+userid);
		ArrayList<name_list> list = new ArrayList<name_list>();
		try {
			preStmt = con.prepareStatement("SELECT user.UserId,Name,photo FROM sis.student,sis.notification,sis.user where student.UserId=notification.UserId_request and notification.userId=? and user.UserId=notification.UserId_request;");
			preStmt.setString(1,userid);
		
			
			ResultSet result = preStmt.executeQuery();
			
			while (result.next()) {
				list.add(new name_list(result.getString("Name"),result.getString("photo"),"confirm Friend",result.getString("UserId")));
			}
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
		
		
	}
	
	public String notification_delete(String userid,String userid_request){
		try {
			preStmt = con.prepareStatement("delete from notification where UserId=? and UserId_request=? ");
			preStmt.setString(1,userid);
			preStmt.setString(2,userid_request);
			preStmt.executeUpdate();
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "suc";
		
		
		
		
	}
	
	
	
	
	
	

}
