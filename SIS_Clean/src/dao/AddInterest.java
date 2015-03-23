package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import action.AddUser;

public class AddInterest {
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

	public String interest(String ins)
		{
		String ret = "";
		try {

			String query = "INSERT INTO interest (int_name) VALUES (?);";
			PreparedStatement preStmt = null;
			AddUser_DAO dc = new AddUser_DAO();
			Connection con = dc.connect();
			preStmt = con.prepareStatement(query);
			preStmt.setString(1,ins);
			preStmt.executeUpdate();

		} catch (Exception e) {
			
			ret="Error Occurred";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret="Successfully Inserted";
		return ret;

	}
}
