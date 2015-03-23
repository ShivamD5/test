package action;
//dynamic controller
import dao.LoginDao;
import dao.RegisterDao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import action.announcement.ShowAnnouncement;
import action.news.ShowNews;

public class Login implements SessionAware {
	private String msg;
	private String username, userpass;
	SessionMap<String, ArrayList<String>> sessionmap;
	private String facultyName, Photo, Quali, Cabin, Email, address, dob, specializ, studentName;
	String lastLogged;
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	private List<String> ancList, newsList;

	public String getQuali() {
		return Quali;
	}

	public void setQuali(String quali) {
		Quali = quali;
	}

	public String getCabin() {
		return Cabin;
	}

	public void setCabin(String cabin) {
		Cabin = cabin;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	ArrayList<Login> list = new ArrayList<Login>();

	public ArrayList<Login> getList() {
		return list;
	}

	public void setList(ArrayList<Login> list) {
		this.list = list;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String execute() throws NumberFormatException,
			ClassNotFoundException {

		ArrayList<String> temp;
		try {
			msg="";
			HttpSession session = ServletActionContext.getRequest().getSession(
					false);
			temp = new ArrayList<String>();
			temp = (ArrayList<String>) session.getAttribute("login");

			if (temp.get(0).equalsIgnoreCase("admin")) {	
				System.out.println("admin");
				return "admin";
			}
			if (temp.get(1).equalsIgnoreCase("F")) {
				RegisterDao rd = new RegisterDao();
				list = rd.displayfacultyDetails(temp.get(0));
				return "faculty";

			}
			if (temp.get(1).equalsIgnoreCase("S")) {
				newsList = new LinkedList<String>();
				ancList = new LinkedList<String>();
				RegisterDao rd = new RegisterDao();
		
				ShowAnnouncement sh = new ShowAnnouncement();
				ShowNews sn = new ShowNews();
				sn.execute(temp.get(0));
				sh.execute();
				ancList = sh.getAncList();
				newsList = sn.getNewsList();
				setAncList(ancList);
				rd = new RegisterDao();
				list = rd.displayStudentDetails(temp.get(0));
				return "student";
			}
			

		} catch (Exception E) {
			msg="";
E.printStackTrace();
			if (LoginDao.validate(username, userpass).equalsIgnoreCase("A")) {
				temp = new ArrayList<String>();
				temp.add("admin");
				temp.add("ty");
				temp.add(userpass);
				sessionmap.put("login", temp);
				return "admin";
			} else if (LoginDao.validate(username, userpass).equalsIgnoreCase(
					"S")) {
				newsList = new LinkedList<String>();
				ancList = new LinkedList<String>();
				RegisterDao rd = new RegisterDao();
				list = rd.displayStudentDetails(username);
				ShowAnnouncement sh = new ShowAnnouncement();
				ShowNews sn = new ShowNews();
				sn.execute(username);
				sh.execute();
				ancList = sh.getAncList();
				newsList = sn.getNewsList();
				setAncList(ancList);
				temp = new ArrayList<String>();
				temp.add(username);
				temp.add("S");
				temp.add(userpass);
				sessionmap.put("login", temp);
				String name = username;
				return "student";
			} else if (LoginDao.validate(username, userpass).equalsIgnoreCase(
					"F")) {
				RegisterDao rd = new RegisterDao();
				String name = username;
				list = rd.displayfacultyDetails(username);
				temp = new ArrayList<String>();
				temp.add(username);
				// temp.add(list.get(0));
				temp.add("F");
				temp.add(userpass);
				sessionmap.put("login", temp);

				return "faculty";
			} else {
				//temp = new ArrayList<String>();
				//temp.add("false");
				//sessionmap.put("login", temp);
				System.out.println("INsiseeeeee errrorrrr");
				msg="Check Username or Password";
				return "error";
			}
		}
		return "error";
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public void setSession(Map map) {
		sessionmap = (SessionMap) map;

	}

	public String logout() {
		sessionmap.invalidate();
		return "success";
	}

	public List<String> getAncList() {
		return ancList;
	}

	public void setAncList(List<String> ancList) {
		this.ancList = ancList;
	}

	public List<String> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<String> newsList) {
		this.newsList = newsList;
	}

	public String getLastLogged() {
		return lastLogged;
	}

	public void setLastLogged(String string) {
		this.lastLogged =  string;
	}

	public String getSpecializ() {
		return specializ;
	}

	public void setSpecializ(String specializ) {
		this.specializ = specializ;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
