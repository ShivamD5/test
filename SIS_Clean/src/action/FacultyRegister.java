package action;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.RegisterDao;

public class FacultyRegister extends ActionSupport implements 
ServletRequestAware{
	private String id,name,quali,cabin,password,email,lastlogin;
	private String pic;
	private String imageURL;
	


	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	private HttpServletRequest servletRequest;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuali() {
		return quali;
	}

	public void setQuali(String quali) {
		this.quali = quali;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) throws FileNotFoundException {
		this.pic=pic;
	} 
	String destPath;


	

	


	public String execute() throws FileNotFoundException,NamingException, SQLException
	{   /* Copy file to a safe location */
		destPath = "/D:/OOAD_temp/SIS_Clean/WebContent";
		String s = servletRequest.getServletContext().getRealPath("/") + pic;
		//System.out.println("Src File name: " + Image);
		//System.out.println("Dst File name: " + Image);
		String name ="img/"+id+".jpg";
		File myFile = new File(s);
		File destFile = new File(destPath, name);
		try {
			FileUtils.copyFile(myFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FinalPath = name;

		this.setImageURL(name);
	    int i=RegisterDao.insert(this);  
	    System.out.println(i);
	    if(i>0){  
	    	
	    	System.out.println("success");
	    return "success";  
	    }  
	    return "error";  
	}


	public void setServletRequest(HttpServletRequest req) {
	    this.servletRequest = req;

	  }
	
	 
}
