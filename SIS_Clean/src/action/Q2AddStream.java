package action;
import dao.MyGetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

//import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;


public class Q2AddStream extends ActionSupport{
	
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
		System.out.println("add stream");
		
		Connection conn = MyGetConnection.con;
		try{
			PreparedStatement stmt = conn.prepareStatement("insert into  stream(stream113) values (?)");
		
			stmt.setString(1, getAncTopic());
		
			stmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Stream already present");
			e.printStackTrace();
			setMsg("Stream already present");
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
