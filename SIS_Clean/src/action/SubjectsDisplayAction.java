package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectsDisplayAction extends ActionSupport implements
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 452798531538109456L;
	/**
	 * 
	 */
	private static final String SHOW_ALL_COURSES = "Show All Courses";
	private static final String SHOW_ENROLLED_COURSES = "Show Enrolled Courses";
	private List<SubjectInfo> subjectInfoList;
	private List<String> subjectDisplayList;

List<String> facultyList;
	
String code;
	

	public String getSubjectDisplayChoice() {
		return subjectDisplayChoice;
	}

	public void setSubjectDisplayChoice(String subjectDisplayChoice) {
		this.subjectDisplayChoice = subjectDisplayChoice;
	}

	public void setSubjectInfoList(List<SubjectInfo> subjectInfoList) {
		this.subjectInfoList = subjectInfoList;
	}

	public List<SubjectInfo> getSubjectInfoList() {
		return subjectInfoList;
	}

	public void setSubjectDisplayList(List<String> subjectDisplayList) {
		this.subjectDisplayList = subjectDisplayList;
	}

	private String subjectDisplayChoice;
	/*
	 * { subjectDisplayList = new ArrayList<String>();
	 * subjectDisplayList.add(SHOW_ALL_COURSES);
	 * subjectDisplayList.add(SHOW_ENROLLED_COURSES);
	 * setSubjectDisplayList(subjectDisplayList); //
	 * setSubjectDisplayChoice(SHOW_ALL_COURSES); }
	 */
	private static String SUCCESS = "success";
	private Map<String, Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<String> getSubjectDisplayList() {
		return subjectDisplayList;
	}

	public static String getShowAllCourses() {
		return SHOW_ALL_COURSES;
	}

	public static String getShowEnrolledCourses() {
		return SHOW_ENROLLED_COURSES;
	}

	public String execute() throws SQLException {
		if (null == subjectDisplayChoice) {
			subjectDisplayChoice = SHOW_ALL_COURSES;
			subjectDisplayList = new ArrayList<String>();
			subjectDisplayList.add(SHOW_ALL_COURSES);
			subjectDisplayList.add(SHOW_ENROLLED_COURSES);
		}
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		ArrayList<String> temp = (ArrayList<String>) session
				.getAttribute("login");

		if (null == subjectDisplayChoice
				|| subjectDisplayChoice.equals(SHOW_ALL_COURSES))
			subjectInfoList = dao.SubjectsDisplay.getAllCourses();
		else
			subjectInfoList = dao.SubjectsDisplay.getEnrolledCourses(temp
					.get(0));

		return SUCCESS;
	}
	
	String code_syllabus;
	public String getCode_syllabus() {
		return code_syllabus;
	}

	public void setCode_syllabus(String code_syllabus) {
		this.code_syllabus = code_syllabus;
	}

	String result;
	//String code;
	public List<String> getFacultyList() {
		return facultyList;
	}

	public void setFacultyList(List<String> facultyList) {
		this.facultyList = facultyList;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	private String syllabus;

	
	  public String syllabus() throws SQLException  {
          System.out.println("SubCode "+ code_syllabus);
           setSyllabus(dao.SubjectsDisplay.getSyllabus(code_syllabus));
           
           
         return SUCCESS;
         }


	  private ArrayList<String> streamlist = new ArrayList<String>();
	public String codeCheck() throws SQLException {
		result = dao.SubjectsDisplay.CheckCode(code);
		
		
		System.out.println(result);
		dao.CourseDao codecheck = new dao.CourseDao();
		codecheck.initSubjects();
		streamlist=codecheck.streamlist;
		facultyList = codecheck.facultyList;
		setFacultyList(facultyList);
		if(result.equals("yes")){
			code="";
		}
		return SUCCESS;
	}
	
	//////////////////////Q2///////////////////////////////

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public ArrayList<String> getStreamlist() {
		return streamlist;
	}

	public void setStreamlist(ArrayList<String> streamlist) {
		this.streamlist = streamlist;
	}

}
