package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import dao.MyGetConnection;
import model.EnrollInfo;


import com.opensymphony.xwork2.ActionSupport;

public class EnrollCourses extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EnrollInfo> enrollList = new LinkedList<EnrollInfo>();

	public String execute() {
		try {
			Connection conn = MyGetConnection.con;
			PreparedStatement stmt = conn
					.prepareStatement("select * from SIS.tempEnroll order by StudentId");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				 System.out.println("Problem : " + rs.getString(1));
				EnrollInfo abc = new EnrollInfo();
				abc.setEnrollId(rs.getString(1));
				abc.setStudentId(rs.getString(2));
				abc.setCourseId(rs.getString(3));
				abc.setSem(rs.getString(4));
				enrollList.add(abc);
			}
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("Error in EnrollCourses");
			e.printStackTrace();
			return ERROR;
		}

	}

	public List<EnrollInfo> getEnrollList() {
		return enrollList;
	}

	public void setEnrollList(List<EnrollInfo> enrollList) {
		this.enrollList = enrollList;
	}
}
