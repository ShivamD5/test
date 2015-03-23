package action.news;
import dao.MyGetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


public class RemoveNewsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> newsList = new LinkedList<String>();
	private String msg = null;
	private String newsId;
	
	public String execute()
	{
		System.out.println("IN REMOVE NEWS");
		Connection conn = MyGetConnection.con;
		PreparedStatement stmt = null;
		try{

			stmt = conn.prepareStatement("delete from SIS.news where Topic= ?");
			System.out.println(getNewsId());
			stmt.setString(1, getNewsId());
			stmt.executeUpdate();
			
		}catch(Exception e)
		{
	//		System.out.println("Error in Remove News");
			//e.printStackTrace();
			getNews();
			setMsg("Unable to Remove");
			return ERROR;
		}
		setMsg("Successfully Removed");
		getNews();
		return SUCCESS;
	}
	
	
	public String getNews() {

		Connection conn = MyGetConnection.con;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn
					.prepareStatement("select Topic from news order by S_NewsId desc");

			rs = stmt.executeQuery();

			while (rs.next()) {
				newsList.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println("Problem in Remove News Action");
			//e.printStackTrace();
			return ERROR;
		}
		try{
			rs.close();
		}catch(Exception e)
		{
			System.out.println("Problem in Remove News Action in Closing the ResultSet");
			//e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}


	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}	
	public List<String> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<String> newsList) {
		this.newsList = newsList;
	}
}