package action.news;
import dao.MyGetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

//import org.apache.commons.lang.StringUtils;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;


public class AddNewsAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String newsTopic;
	private String newsDescription;
	private String newsInterestId; 
	private ArrayList<String> intrst = new ArrayList<String>();
	private String msg = null;
	/*
	public void validate()
	{
		if(StringUtils.isEmpty(getNewsTopic()))
		{
			System.out.println("Topic length is 0");
			addFieldError("newsTopic", "Topic Name is Empty");
		}
		
		if(StringUtils.isEmpty(getNewsDescription()))
		{
			System.out.println("Topic Description is 0");
			addFieldError("newsDescription", "Description Field is Empty");
		}
	}
*/	
	
	public ArrayList<String> getIntrst() {
		return intrst;
	}

	public String getNewsInterestId() {
		return newsInterestId;
	}

	public void setNewsInterestId(String newsInterestId) {
		this.newsInterestId = newsInterestId;
	}

	public void setIntrst(ArrayList<String> intrst) {
		this.intrst = intrst;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}

	public String getNewsTopic() {
		return newsTopic;
	}

	public void setNewsTopic(String newsTopic) {
		this.newsTopic = newsTopic;
	}
	
	public String execute() {
		Connection conn = MyGetConnection.con;
		try{
			PreparedStatement stmt = conn.prepareStatement("insert into news (Topic, Details, News_Interest) values (?, ?, ?)");
		
			stmt.setString(1, getNewsTopic());
			stmt.setString(2, getNewsDescription());
			stmt.setString(3, getNewsInterestId());
		
			stmt.executeUpdate();
		}
		catch(Exception e)
		{
			//System.out.println("Problem in execute update in news");
			//e.printStackTrace();
			setMsg("Same Topic name is already existed");
			interest();
			return ERROR;
		}
		
		System.out.println("Topic : " + getNewsTopic());
		System.out.println("Description : " + getNewsDescription());
		System.out.println("Interest : " + getNewsInterestId());
		interest();
		setMsg("Successfully Added");
		return SUCCESS;
	}
	
	public String interest()
	{
		System.out.println("IN interest");
		Connection conn = MyGetConnection.con;
		ResultSet rs = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement("select int_name from interest");
		
			rs = stmt.executeQuery();
			while(rs.next())
			{
				if(!rs.getString(1).equalsIgnoreCase("NULL"))
				{
					System.out.println("IN : " + rs.getString(1));
					intrst.add(rs.getString(1));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Problem in execute interest in news");
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
