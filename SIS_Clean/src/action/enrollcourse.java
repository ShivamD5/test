package action;

import java.util.*;

import dao.enrollcoursedao;



public class enrollcourse {
	private List<String> semlist;
	private List<String> courselist;
	private int sem;
	private String username;
	private String msg;
	public String execute() throws Exception
	{	System.out.print(sem+"here");
		setSemlist(enrollcoursedao.semlist());
		setCourselist(enrollcoursedao.courselist(sem));
		return "success";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
