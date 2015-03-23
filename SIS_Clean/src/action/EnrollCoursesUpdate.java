package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import dao.MyGetConnection;
import model.EnrollInfo;


import com.opensymphony.xwork2.ActionSupport;

public class EnrollCoursesUpdate extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EnrollInfo> enrollList = new LinkedList<EnrollInfo>();
	private String[] checkedYes;
	private String[] checkedNo;

	public String execute() {
		//System.out.println("in EnrollCoursesUpdate");
		try {
			Connection conn = MyGetConnection.con;
			ResultSet rs = null;
			PreparedStatement stmt = null;

			if (checkedYes != null) {
				for (String s : checkedYes) {
			//		System.out.println(s);

					stmt = conn
							.prepareStatement("select StudentId, CourseId, SemId from SIS.tempEnroll where S_tempEnrollId = ?");
					stmt.setString(1, s);
					rs = stmt.executeQuery();
					if (rs.next()) {
						stmt = conn
								.prepareStatement("insert into SIS.Enroll (StudentId, CourseId, SemId) values (?,?,?)");
						stmt.setString(1, rs.getString(1));
						stmt.setString(2, rs.getString(2));
						stmt.setString(3, rs.getString(3));
						stmt.executeUpdate();
						
						stmt = conn.prepareStatement("insert into result(StudentId, CourseId, GradeId) values (?,?,?)");
						stmt.setString(1, rs.getString(1));
						stmt.setString(2, rs.getString(2));
						stmt.setInt(3, 0);
						stmt.executeUpdate();
						
						stmt = conn
								.prepareStatement("delete from SIS.tempEnroll where S_tempEnrollId = ?");
						stmt.setString(1, s);
						stmt.executeUpdate();
					}

				}
			}

			if (checkedNo != null) {
				for (String str : checkedNo) {
					stmt = conn
							.prepareStatement("delete from SIS.tempEnroll where S_tempEnrollId = ?");
					stmt.setString(1, str);
					stmt.executeUpdate();
					System.out.println(str);
				}
			}
			stmt = conn.prepareStatement("select * from SIS.tempEnroll");
			rs = stmt.executeQuery();
			while (rs.next()) {
				// System.out.println("Problem : " + rs.getString(1));
				EnrollInfo abc = new EnrollInfo();
				abc.setEnrollId(rs.getString(1));
				abc.setStudentId(rs.getString(2));
				abc.setCourseId(rs.getString(3));
				abc.setSem(rs.getString(4));
				enrollList.add(abc);
			}
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("Error in EnrollCoursesUpdate");
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

	public String[] getCheckedYes() {
		return checkedYes;
	}

	public void setCheckedYes(String[] checkedYes) {
		this.checkedYes = checkedYes;
	}

	public String[] getCheckedNo() {
		return checkedNo;
	}

	public void setCheckedNo(String[] checkedNo) {
		this.checkedNo = checkedNo;
	}
}
