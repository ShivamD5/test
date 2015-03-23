package action;
import java.util.*;

import dao.AddUser_DAO;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddUser extends ActionSupport implements ServletRequestAware {
	/**
	 * 
	 */
	
	
	private ArrayList <String> iid;
	private ArrayList <String> interest;
	//private String interest;
	private static final long serialVersionUID = 1L;
	private int S_StudentId;
	private String UserId, Name, Address, DOB, Specialization, EmailId,
			Password,msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private String FinalPath;

	public String getFinalPath() {
		return FinalPath;
	}

	public void setFinalPath(String finalPath) {
		FinalPath = finalPath;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	String fileUploadContentType;
	private String fileUploadFileName;
	File UserImage;
	private String Image, destPath;
	AddUser_DAO dc = new AddUser_DAO();

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	private HttpServletRequest servletRequest;

	public String execute() throws IOException {
		//System.out.println("DOB"+DOB);
		
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		ArrayList<String> temp = (ArrayList<String>) session.getAttribute("login");
		String userid = (temp.get(0));
		System.out.println("execute");
		FixImage();
		try {
			AddUser_DAO dc = new AddUser_DAO();
			int status1 = dc.UserTableInsert(this);
			int status2 = dc.StudentTableInsert(this);
			dc.addInterest(iid,UserId);
			
			if (status1 == 1 && status2 == 1) {
				msg="User Successfully Added";
				
				AddUser_DAO ob = new AddUser_DAO();
				interest=ob.select_interest();
				
				return "success";
				
			} else
				msg="User Already Exists";
				return "error";
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg="User Already Exists";
		return "error";

	}

	public void FixImage() {
		destPath = "/D:/OOAD_temp/SIS_Clean/WebContent";
		String s = servletRequest.getServletContext().getRealPath("/") + Image;
		System.out.println("Src File name: " + Image);
		System.out.println("Dst File name: " + Image);
		String name ="img/"+UserId+".jpg";
		File myFile = new File(s);
		File destFile = new File(destPath, name);
		try {
			FileUtils.copyFile(myFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FinalPath = name;

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getS_StudentId() {
		return S_StudentId;
	}

	public void setS_StudentId(int s_StudentId) {
		S_StudentId = s_StudentId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return UserImage;
	}

	public void setFileUpload(File UserImage) {
		this.UserImage = UserImage;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	private Map<String, Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	public File getUserImage() {
		return UserImage;
	}

	public void setUserImage(File userImage) {
		this.UserImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	private String userImageContentType;
	private String userImageFileName;

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

//	public String getInterest() {
//		return interest;
//	}
//
//	public void setInterest(String interest) {
//		this.interest = interest;
//	}

	public ArrayList<String> getIid() {
		return iid;
	}

	public void setIid(ArrayList<String> iid) {
		this.iid = iid;
	}

	public ArrayList <String> getInterest() {
		return interest;
	}

	public void setInterest(ArrayList <String> interest) {
		this.interest = interest;
	}
}
