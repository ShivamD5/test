package action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import dao.friend_data;
import dao.name_list;


public class SearchUser {
	String current_userId; //To be taken from session variable
	int list_size;
	String user_search;
	String page; 
	ArrayList <name_list> array_list = new ArrayList<name_list>();
	
	public ArrayList<name_list> getArray_list() {
		return array_list;
	}
	public void setArray_list(ArrayList<name_list> array_list) {
		this.array_list = array_list;
	}
	public String getUser_search() {
		return user_search;
	}
	public void setUser_search(String user_search) {
		this.user_search = user_search;
	}
	
		
	public String execute() {
		HttpSession session  =ServletActionContext.getRequest().getSession(false);
		ArrayList<String> temp = (ArrayList<String>) session.getAttribute("login");

		current_userId=(temp.get(0));
		
		if(page==null){
			page="1";
		}
		friend_data fd = new friend_data();
		ArrayList<name_list> temp_user=fd.search(user_search,Integer.parseInt(page));
		fd = new friend_data();
		ArrayList<name_list>temp_friend=fd.select(current_userId,Integer.parseInt(page));//need to change value of 1 here
		
		System.out.println(temp_user.size());
		System.out.println(temp_friend.size());
		for(int i=0;i<temp_user.size();i++){
			boolean flag = true;
			for(int k=0;k<temp_friend.size();k++){
				System.out.println(temp_user.get(i).userId+" "+temp_friend.get(k).userId+" "+temp_friend.get(k).friend);
				if((temp_user.get(i).userId.trim()).equalsIgnoreCase(temp_friend.get(k).userId.trim())){
					array_list.add(temp_friend.get(k));
					System.out.println("inside");
					flag=false;
					break;
				}
		}
			if(flag)
			array_list.add(temp_user.get(i));
	}
		for(int k=0;k<array_list.size();k++){
			if((current_userId.trim()).equalsIgnoreCase(array_list.get(k).userId.trim())){
				array_list.remove(k);
				break;
				
				
			}
			
		}
		list_size=array_list.size();
		setList_size(list_size);
		setArray_list(array_list);
		System.out.println(array_list);
		return "success";
		}
	public int getList_size() {
		return list_size;
	}
	public void setList_size(int list_size) {
		this.list_size = list_size;
	}
	}
