package action;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import model.gradeUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.gradeDao;
import model.st_grade;


public class gradeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private st_grade sGrade;
	private String studentID;
	private String courseID;
	private String grade;
	private String course, studentId, facultyID, currentGrade = null;
	private ArrayList<String> courseList, studentList, previous_gradeList;
	private ArrayList<st_grade> sgrade_list;
	private ArrayList<String> listGrade;
	
	
	
	public ArrayList<String> getListGrade() {
		return listGrade;
	}

	public void setListGrade(ArrayList<String> listGrade) {
		this.listGrade = listGrade;
	}

	public ArrayList<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<String> courseList) {
		this.courseList = courseList;
	}

	private gradeUser gradeUser = new gradeUser();

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	

	public String insertGrade() throws SQLException {
		/*gradeUser.setCourse(course);
		gradeUser.setStudentID(studentId);
		gradeUser.setGrade(grade);*/
		gradeDao insert = new gradeDao();
		//insert.insertGrade(gradeUser);
		courseStudents();
		
		insert.insertGrade(studentList,listGrade,course,sgrade_list);
		courseStudents();
		return "success";
	}
	public String insertGradeUpdate() throws SQLException {
		gradeUser.setCourse(course);
		gradeUser.setStudentID(studentId);
		gradeUser.setGrade(grade);
		gradeDao insert = new gradeDao();
		insert.insertGradeUpdate(gradeUser);
		courseStudents();
		
		return "success";
	}

	public String fillCourse() throws SQLException {
		HttpSession session  =ServletActionContext.getRequest().getSession(false);
		ArrayList<String> temp = (ArrayList<String>) session.getAttribute("login");
		facultyID = temp.get(0);
		System.out.println(facultyID);
		gradeDao init = new gradeDao();
		setFacultyID(facultyID);
		ArrayList<String> a=init.fillCourse(facultyID);
		ArrayList<String> tmp = new ArrayList<String>();
		courseList=new ArrayList<String>();
		studentList=new ArrayList<String>();
		setCourseList(a);
		//setStudentList(tmp);
		return "success";
	}
	
	public String courseStudents() throws SQLException {
		HttpSession session  =ServletActionContext.getRequest().getSession(false);
		ArrayList<String> temp = (ArrayList<String>) session.getAttribute("login");
		facultyID = temp.get(0);
	//System.out.println(facultyID +"fid");
		//System.out.println("courseStudent");
		gradeDao callDao = new gradeDao();
		ArrayList<String> a=callDao.courseStudents(course);
		studentList=new ArrayList<String>();
		setStudentList(a);
		ArrayList<String> b=callDao.returnGrade(a, course);
		setPrevious_gradeList(b);
		sgrade_list = new ArrayList<st_grade>();
		
		for(int k=0;k<b.size();k++){
			sGrade = new st_grade();
			sGrade.grade=b.get(k);
			sGrade.s_Id=a.get(k);
			sgrade_list.add(sGrade);
			System.out.println(sGrade.grade + " " + sGrade.s_Id);
			
			
		}
		setSgrade_list(sgrade_list);
		a=callDao.fillCourse(facultyID);
		courseList=new ArrayList<String>();
		setCourseList(a);	
		return "success";
	}
	
	public String currentGrade() throws SQLException {
		gradeDao callDao = new gradeDao();
		String gradeNew=callDao.currentGrade(studentId, course);
		studentList=new ArrayList<String>();
		setCurrentGrade(gradeNew);
		//System.out.println(currentGrade + "currentGrade");
		courseStudents();
		return "success";
	}
	
	

	public ArrayList<String> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<String> studentList) {
		this.studentList = studentList;
	}

	public String getFacultyID() {
		//System.out.println(facultyID + "set");
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		System.out.println("set fid");
		this.facultyID = facultyID;
	}

	public String getCurrentGrade() {
		return currentGrade;
	}

	public void setCurrentGrade(String currentGrade) {
		this.currentGrade = currentGrade;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	public st_grade getsGrade() {
		return sGrade;
	}

	public void setsGrade(st_grade sGrade) {
		this.sGrade = sGrade;
	}

	public ArrayList<st_grade> getSgrade_list() {
		return sgrade_list;
	}

	public void setSgrade_list(ArrayList<st_grade> sgrade_list) {
		this.sgrade_list = sgrade_list;
	}

	public ArrayList<String> getPrevious_gradeList() {
		return previous_gradeList;
	}

	public void setPrevious_gradeList(ArrayList<String> previous_gradeList) {
		this.previous_gradeList = previous_gradeList;
	}


	

}
