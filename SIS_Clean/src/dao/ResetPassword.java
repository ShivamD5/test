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

public class ResetPassword {
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

	public int reset(String username, String password)
		{
		int ret = -1;
		try {

			String query = "Update sis.user SET Password=? where UserId=?";
			PreparedStatement preStmt = null;
			AddUser_DAO dc = new AddUser_DAO();
			Connection con = dc.connect();
			preStmt = con.prepareStatement(query);
			preStmt.setString(1,password);
			preStmt.setString(2,username);

			ret = preStmt.executeUpdate();
			con.close();
			ret=0;
			HttpSession session  =ServletActionContext.getRequest().getSession(false);
			ArrayList<String> tmp = (ArrayList<String>) session.getAttribute("login");
			System.out.println(tmp);
			ArrayList<String> tmp_new = new ArrayList<String>();
			tmp_new.add(tmp.get(0));
			tmp_new.add(tmp.get(1));
			tmp_new.add(password);
			session.removeAttribute("login");
			session.setAttribute("login", tmp_new);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;

	}
}
