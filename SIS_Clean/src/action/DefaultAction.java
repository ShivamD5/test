package action;
import dao.*;

import java.util.*;
import dao.*;
public class DefaultAction {
	private ArrayList<String> interest = new ArrayList<String>();
	private String msg;
    private String ins;
	public String ViewGrades(){
		return "success";
	}
	
	public String resetPassword(){
		return "success";
	}
	
	public String AdminAddUser(){
		AddUser_DAO ob = new AddUser_DAO();
		interest=ob.select_interest();
		return "success";
	}
	public String Q2AddStream(){
		
		return "success";
	}
	
	public String addInterest(){
		
		AddInterest ob = new AddInterest();
		msg="";
		if(ins!=null)
		msg=ob.interest(ins);
		
		return "success";
	}
	
	
	public String AdminAddFaculty(){
		return "success";
	}
	
	public String AdminAddNews(){
		return "success";
	}
	
	public String AdminAddAnnouncemet(){
		return "success";
	}

	public ArrayList<String> getInterest() {
		return interest;
	}

	public void setInterest(ArrayList<String> interest) {
		this.interest = interest;
	}

	public String getIns() {
		return ins;
	}

	public void setIns(String ins) {
		this.ins = ins;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
