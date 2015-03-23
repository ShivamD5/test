
//first time when the user click on notification.

package action;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import dao.friend_data;
import dao.name_list;


public class NotificationFriend {
	ArrayList <name_list> array_list = new ArrayList<name_list>();
	String user_name;
	String page;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public ArrayList<name_list> getArray_list() {
		return array_list;
	}
		public void setArray_list(ArrayList<name_list> array_list) {
		this.array_list = array_list;
	}
	public String execute() {
		HttpSession session  =ServletActionContext.getRequest().getSession(false);
		ArrayList<String> tmp = (ArrayList<String>) session.getAttribute("login");
		System.out.println(tmp);
		user_name=tmp.get(0);
		System.out.println(user_name);
		if(page==null){
			page="1";
		}
		friend_data fd = new friend_data();
		System.out.println("username "+user_name);
		ArrayList<name_list> array_list=fd.notification_select(user_name);
		
		
		//System.out.println(array_list.get(0).photo);
		setArray_list(array_list);
		return "success";
	}
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
