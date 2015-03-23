package action.announcement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import dao.MyGetConnection;

import com.opensymphony.xwork2.ActionSupport;


public class ShowAnnouncement extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> ancList = new LinkedList<String>();

	public List<String> getAncList() {
		return ancList;
	}

	public void setAncList(List<String> ancList) {
		this.ancList = ancList;
	}
	
	public String execute() 
	{
		try{
		Connection conn = MyGetConnection.con;
		PreparedStatement stmt = conn.prepareStatement("select anc from announcement");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			ancList.add(rs.getString(1));
		}
		}catch(Exception e)
		{
			System.out.println("Problem in Remove Announcement Action");
			e.printStackTrace();
			return ERROR;
		}
		setAncList(ancList);
		return SUCCESS;
		
	}
	
}
