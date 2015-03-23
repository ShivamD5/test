package action;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import  dao.*;
public class ResetPassword {
	String pass2;
	String result;
	//int count=0;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	public String action(){
		HttpSession session  =ServletActionContext.getRequest().getSession(false);
		ArrayList<String> tmp = (ArrayList<String>) session.getAttribute("login");
		System.out.println(tmp);
		String username=tmp.get(0);
		
		dao.ResetPassword ps = new dao.ResetPassword();
		System.out.println("u===>"+username);
		System.out.println("===>"+pass2);
		if(pass2==null){
			result="no";
			return "success";
		}
		int res=ps.reset(username, pass2);
		//pass2=null;
		//System.out.println("===>"+pass2);
		System.out.println("res"+res);
	if(res==-1){
		result="false";
	}
	else{
		result="changed";
	}
	
	//setResult(result);
	return "success";
	}
	

}
