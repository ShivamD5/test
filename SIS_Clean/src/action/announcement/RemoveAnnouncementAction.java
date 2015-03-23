package action.announcement;
import dao.MyGetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


public class RemoveAnnouncementAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> ancList = new LinkedList<String>();
	private String ancId;
	private String msg;
	
	public String execute() {
		try {
			Connection conn = MyGetConnection.con;
			PreparedStatement stmt = conn
					.prepareStatement("delete from announcement where anc = ?");
			stmt.setString(1, getAncId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error in RemoveAnnouncement");
			//e.printStackTrace();
			getAnc();
			setMsg("Unable to Remove");
			return ERROR;
		}
		
		setMsg("Seccussfully Removed");
		getAnc();
		return SUCCESS;
	}

		
	public String getAnc() 
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
		
		return SUCCESS;
	}
	
	public String getAncId() {
		return ancId;
	}

	public void setAncId(String ancId) {
		this.ancId = ancId;
	}

	public List<String> getAncList() {
		return ancList;
	}

	public void setAncList(List<String> ancList) {
		this.ancList = ancList;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
}
