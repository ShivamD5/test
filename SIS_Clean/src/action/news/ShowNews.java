package action.news;
import dao.MyGetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;


public class ShowNews extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> newsList = new LinkedList<String>();
	private String newsDescription, topic;

	public String execute(String username) {

		Connection conn = MyGetConnection.con;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn .prepareStatement("select distinct Topic from news,student_interest where student_interest.student_id = '" + username + "' and student_interest.interest=news.News_Interest order by S_NewsId desc");
//			stmt = conn
//					.prepareStatement("select Topic from news,student_interest where student_interest.student_id = " + username + " and student_interest.interest=news.News_Interest order by S_NewsId desc");

			rs = stmt.executeQuery();

			while (rs.next()) {
				newsList.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println("Problem in ShowNews Action");
			e.printStackTrace();
			return ERROR;
		}
		try{
			rs.close();
		}catch(Exception e)
		{
			System.out.println("Problem in ShowNews Action in Closing the ResultSet");
			e.printStackTrace();
			return ERROR;
		}
		setNewsList(newsList);
		return SUCCESS;
	}
	
	public String getNews(){
		
		Connection conn = MyGetConnection.con;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("select Details from news where topic = ?;");
			stmt.setString(1, topic);
			rs = stmt.executeQuery();

			if (rs.next()) {
				newsDescription = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println("Problem in ShowNews Action");
			e.printStackTrace();
			return ERROR;
		}
		try{
			rs.close();
		}catch(Exception e)
		{
			System.out.println("Problem in ShowNews Action in Closing the ResultSet");
			e.printStackTrace();
			return ERROR;
		}
		setNewsDescription(newsDescription);
		return SUCCESS;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<String> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<String> newsList) {
		this.newsList = newsList;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}

}