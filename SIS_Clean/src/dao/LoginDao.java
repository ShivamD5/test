package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.sun.jmx.snmp.Timestamp;

public class LoginDao {

	public static String validate(String username, String userpass) {
		String status = "null";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SIS", "root", "");

			PreparedStatement ps = con
					.prepareStatement("select * from user where UserId=? and password=?");
			ps.setString(1, username);
			ps.setString(2, userpass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = rs.getString(6);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public String logOutTime() {
		String status = "null";
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		ArrayList<String> temp = (ArrayList<String>) session
				.getAttribute("login");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SIS", "root", "");
			Calendar cal = Calendar.getInstance();
			java.util.Date Now = cal.getTime();
			// Timestamp ct = new Timestamp(Now.getTime());
			java.sql.Timestamp ct = new java.sql.Timestamp(Now.getTime());

			PreparedStatement ps = con
					.prepareStatement("update user set LastLogged = ? where UserId = ?; ");
			ps.setTimestamp(1, ct);
			ps.setString(2, temp.get(0));
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}