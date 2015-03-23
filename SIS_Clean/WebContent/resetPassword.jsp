<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%
	ArrayList<String> tmp = (ArrayList<String>) session.getAttribute("login"); 
String pass= tmp.get(2);
%>


<body onload="ld()">
	<script type="text/javascript">
check="false";
function ld() {
	
	
	
	document.getElementById("change").innerHTML = "";
		var s="<s:property value='result'/>";
		
		if(s=="changed"){
			document.getElementById("change").innerHTML = "Password Changed Successfully :)";
			document.getElementById("change").style.color = "green";
			}
		if(s=="no"){
			document.getElementById("change").innerHTML = "";
		}
	
	if(s=="false"){
		document.getElementById("change").innerHTML = "Something Went Wrong !! :(";
		document.getElementById("change").style.color = "red";
		
	}
		
	 
	}
	function rst(){
		//alert("jk");
		document.getElementById("change").innerHTML = "";
		document.getElementById("error").innerHTML = ""; 
	}
function validate(){
	check="false";
	document.getElementById("change").innerHTML = "";
	var pa="<%=pass%>";
			var s0 = document.getElementById("pass0").value;
			var s1 = document.getElementById("pass1").value;
			var s2 = document.getElementById("pass2").value;
			var res = true;
			if (pa != s0) {
				document.getElementById("error").innerHTML = "Wrong Current Password!!!";
				res = false;
			}
			if (s1 != s2) {
				document.getElementById("error").innerHTML = "Password Mismatch !!!!";
				res = false;

			}
			//alert("jk");
			return res;
		}
	</script>






	<br>
	<br>
	<br>
	<br>
	<br>

	<div style="margin-left: 400px;">
		<div class="row">


			<div class="col-sm-5">

				<div style="width: 500px">
					<div style="background-color: #0066FF">
						<h3 class="panel-title ">
							<span style="color: white">&nbsp; &nbsp;Change Password</span>
						</h3>
					</div>
					<div class="panel-body"
						style="background-color: rgba(245, 245, 245, 1.0);">


						<s:form action="ResetPassword" method="get"
							theme="bootstrap" cssClass="form-horizontal">
							<s:password key="userpass" label="Current Password"
								required="true" id="pass0" />
							<s:password key="pass1" label="New Password" required="true"
								id="pass1" />
							<s:password key="pass2" label="Confirm Password" required="true"
								id="pass2" />
							<p id="error" style="color: red" align="center"></p>
							<div class="col-sm-offset-4">
								<button class="btn btn-primary" onclick="return validate()">Submit</button>
								<s:reset class="btn btn-danger" onclick="rst()" />
							</div>

							<p id="change" style="color: red" align="center"></p>
					</div>
					</s:form>

				</div>
			</div>
		</div>
	</div>

	<sb:head />