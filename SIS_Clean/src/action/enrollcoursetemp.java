package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import dao.enrollcoursedao;
public class enrollcoursetemp {

	private List<String> semlist;
	private List<String> courselist;
	private int sem;
	private String course;
	private String StudentID;
	private String msg="";
	public String execute() throws Exception
	{	//System.out.print(sem+"here"+StudentID+"das"+course);
		HttpSession session  =ServletActionContext.getRequest().getSession(false);
		ArrayList<String> temp = (ArrayList<String>) session.getAttribute("login");
		StudentID=(temp.get(0));
		setSemlist(enrollcoursedao.semlist());
		setCourselist(enrollcoursedao.courselist(sem));
		enrollcoursedao.insertenrolltemp(sem,course,StudentID);
		setMsg(enrollcoursedao.msg);
		return "success";
	}
	
	public String getStudentID() {
		return StudentID;
	}
	public void setStudentID(String StudentID) {
		this.StudentID = StudentID;
	}
	

	public List<String> getSemlist() {
		return semlist;
	}

	public void setSemlist(List<String> semlist) {
		this.semlist = semlist;
	}

	public List<String> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<String> courselist) {
		this.courselist = courselist;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
