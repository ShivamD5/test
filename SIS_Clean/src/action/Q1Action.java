package action;
import action.Q2modelstreamsubject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Q1Action extends ActionSupport implements
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 452798531538109456L;
	/**
	 * 
	 */
	private static final String SHOW_ALL_COURSES = "Show All Courses";
	private String username;
	private String rollnumber;
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
		
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		ArrayList<String> temp = (ArrayList<String>) session.getAttribute("login");
		rollnumber=temp.get(0);
		username=dao.SubjectsDisplay.username(rollnumber);
		
		
		
		
		
		
		
		
		
			if (null == subjectDisplayChoice) {
				subjectInfoList=dao.SubjectsDisplay.Q1data(1);
			}else{
				subjectInfoList=dao.SubjectsDisplay.Q1data(Integer.parseInt(subjectDisplayChoice));
				
			}
//			
//		}
//		
//
//		if (null == subjectDisplayChoice
//				|| subjectDisplayChoice.equals(SHOW_ALL_COURSES))
//			subjectInfoList = dao.SubjectsDisplay.getAllCourses();
//		else
//			subjectInfoList = dao.SubjectsDisplay.getEnrolledCourses(temp
//					.get(0));
//
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
	////////Q2222222222222222222222qqqqqqqqqqqqqqq22222222222222222222222222222222  
	  private ArrayList<String> streamlist = new ArrayList<String>();
	  private ArrayList<Q2modelstreamsubject> stream_subject = new  ArrayList<Q2modelstreamsubject> ();
	  private String streamchoice;
	////////  
	  public String q2streamsubject() throws SQLException  {
		  dao.CourseDao codecheck = new dao.CourseDao();
			codecheck.initSubjects();
			setStreamlist(codecheck.streamlist);
			System.out.println(streamchoice);
			if (null == streamchoice) {
				System.out.println(streamlist);
				if(streamlist.size()>0)
				stream_subject=dao.SubjectsDisplay.q2streamsubject(streamlist.get(0));
				
					
				
			}else{
				stream_subject=dao.SubjectsDisplay.q2streamsubject(streamchoice);
				
			}
			
			
			
           
			
			
           
         return SUCCESS;
         }



	public String codeCheck() throws SQLException {
		result = dao.SubjectsDisplay.CheckCode(code);
		System.out.println(result);
		dao.CourseDao codecheck = new dao.CourseDao();
		codecheck.initSubjects();
		facultyList = codecheck.facultyList;
		setFacultyList(facultyList);
		if(result.equals("yes")){
			code="";
		}
		return SUCCESS;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public ArrayList<String> getStreamlist() {
		return streamlist;
	}

	public void setStreamlist(ArrayList<String> streamlist) {
		this.streamlist = streamlist;
	}

	public ArrayList<Q2modelstreamsubject> getStream_subject() {
		return stream_subject;
	}

	public void setStream_subject(ArrayList<Q2modelstreamsubject> stream_subject) {
		this.stream_subject = stream_subject;
	}

	public String getStreamchoice() {
		return streamchoice;
	}

	public void setStreamchoice(String streamchoice) {
		this.streamchoice = streamchoice;
	}

}
