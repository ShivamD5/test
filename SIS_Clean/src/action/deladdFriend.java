package action;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import dao.name_list;
import dao.ConnectionManager;
import dao.friend_data;

public class deladdFriend {

	private ArrayList<name_list> array_list;
	String name;
	String condition;
	String friendid;
	String userid;
	String username;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		ArrayList<String> temp = (ArrayList<String>) session
				.getAttribute("login");
		userid = (temp.get(0));
		friend_data fd = new friend_data();
		username = fd.select_name(userid); // take from session

		fd = new friend_data();
		if (condition.equals("Add Friend")) {
			String update_status = fd.notification_insert(friendid, userid);
			System.out.println(update_status);
		}
		if (condition.equals("Unfriend")) {
			System.out.println("unfriend");
			String update_status = fd.delete(userid, friendid);

		}
		ActionFriend ob = new ActionFriend();
		String s = ob.execute();
		array_list = ob.getArray_list();
		setArray_list(array_list);
		return s;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getFriendid() {
		return friendid;
	}

	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<name_list> getArray_list() {
		return array_list;
	}

	public void setArray_list(ArrayList<name_list> array_list) {
		this.array_list = array_list;
	}

}
