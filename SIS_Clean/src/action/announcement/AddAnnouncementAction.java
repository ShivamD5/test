package action.announcement;
import dao.MyGetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

//import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;


public class AddAnnouncementAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String msg = null;
	private String ancTopic;
	
	
/*	public void validate()
	{
		if(StringUtils.isEmpty(getAncTopic()))
		{
			System.out.println("Topic length is 0");
			addFieldError("ancTopic", "Topic Name is Empty");
		}
	}*/

	public String execute() {
		System.out.println("in Announcememt Action");
		
		Connection conn = MyGetConnection.con;
		try{
			PreparedStatement stmt = conn.prepareStatement("insert into  announcement(anc) values (?)");
		
			stmt.setString(1, getAncTopic());
		
			stmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Problem in execute update in Announcement");
			e.printStackTrace();
			setMsg("Unable to add announcement");
			return ERROR;
		}
		
		System.out.println("Topic : " + getAncTopic());
		setMsg("Successfully added");
		return SUCCESS;
	}



	public String getAncTopic() {
		return ancTopic;
	}



	public void setAncTopic(String ancTopic) {
		this.ancTopic = ancTopic;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
