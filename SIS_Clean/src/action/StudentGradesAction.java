package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import dao.StudentGradesDao;

public class StudentGradesAction {

	private String CName, grade, studentId;
	private int semId;

	public int getSemId() {
		return semId;
	}

	public void setSemId(int semId) {
		this.semId = semId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	private HttpServletRequest servletRequest;

	ArrayList<StudentGradesAction> list = new ArrayList<StudentGradesAction>();

	public String execute() throws FileNotFoundException, NamingException,
			SQLException, ClassNotFoundException {
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		ArrayList<String> temp = new ArrayList<String>();
		temp = (ArrayList<String>) session.getAttribute("login");
		studentId = temp.get(0);

		StudentGradesDao stdao = new StudentGradesDao();
		list = stdao.displayGrades(studentId, semId);

		for (StudentGradesAction i : list) {
			System.out.println(i.getCName() + "action");
		}

		System.out.println("success");
		return "success";

	}

	public ArrayList<StudentGradesAction> getList() {
		return list;
	}

	public void setList(ArrayList<StudentGradesAction> list) {
		this.list = list;
	}

}
