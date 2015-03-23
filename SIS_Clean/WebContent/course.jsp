<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<sx:head/>
<script type="text/javascript">

function clear(){
	document.getElementById("code").innerHTML = "";	
}
	function codeCheck() {
		
// 		var s="<s:property value='result'/>";
// 		alert(s);
// 		if(s=="yes"){
// 			document.getElementById("code").innerHTML = "";
// 		}
		document.subjectCode.action = 'subjectsCodeAction.action';
		document.subjectCode.submit(); /* document.getElementById("change").innerHTML = ""; *//* var a = "<s:property value="result"/>"; alert(a); if(a=="yes") { document.getElementById("error").innerHTML = "Same Course Code Already Exists!!!"; } else { document.getElementById("error").innerHTML = ""; } */
	}
</script>
<body style="background-color: #E6E6FA">
	<!-- Fixes Navigation Bar with drop down menu ======================================================-->
	<br>
	<br>
	<br>
	<br>
	<div class="jumbotron container" style="background:#E6E6FA ">
		
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Course Details</h3>
			</div>
			<div class="panel-body" style="background-color:">
				<font size=4> <s:form action="admin"
						enctype="multipart/form-data" theme="bootstrap" name="subjectCode"
						Class="form-horizontal">
						<%-- <s:textfield name="variable" value="%{demo}"/> --%>
						<div class="row">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="center">
									<label>Enter Course Code</label>
								</div>
								<s:textfield theme="simple" key="code" placeholder="Course Code"
									required="true" onchange="codeCheck()" id="code" name="code"/>
								<s:if test="%{result=='yes'}">
									<p style="font-size: 80%; color: red" align="left" onchange="clear();">Code
										Already Exists 
										</p>
								</s:if>
							</div>
							<div class="col-sm-6" align="center">
								<div class="col-sm-5" align="center">
									<label>Stream</label>
								</div>
								<s:select theme="simple" name="cid" key="cid" list="streamlist"
									cssStyle="width:230px;" placeholder=""
									property="selectedValues" multiple="false" />
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="center">
									<label>Enter Course Name</label>
								</div>
								<s:textfield theme="simple" label="" key="name"
									placeholder="Course name" required="true" />
							</div>
							<div class="col-sm-6" align="center">
								<div class="col-sm-5" align="center">
									<label>Course Credits</label>
								</div>
								<s:select theme="simple" name="credit" key="credit" list="{2,4}"
									cssStyle="width:230px;" placeholder="Enter the Credit"
									property="selectedValues" multiple="false" />
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="center">
									<label>Last Date of Registration</label>
								</div>
								<sx:datetimepicker name="register"  
										displayFormat="yyyy-MM-d" value="todayDate" />
							</div>
							<div class="col-sm-6" align="center">
								<div class="col-sm-5" align="center">
									<label>Faculty Name</label>
								</div>
								<s:select theme="simple" name="fid" key="fid" list="facultyList"
									cssStyle="width:230px;" placeholder="Faculty"
									property="selectedValues" multiple="true" />
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="center">
									<label>Syllabus</label>
								</div>
								<s:textarea theme="simple" key="syllabus" cols="23" rows="3"
									placeholder="Add Syllabus" />
							</div>
							<div class="col-sm-6" align="center">
								<div class="col-sm-5" align="center">
									<label>Enter Semester ID</label>
								</div>
								<s:select theme="simple" name="semid" key="semid" list="{1,2,3,4}"
									cssStyle="width:230px;" placeholder="Enter the Credit"
									property="selectedValues" multiple="false" />
								<hr>
								<s:submit class="btn btn-primary" />
								<s:reset class="btn btn-danger" />
							</div>
						</div>
					</s:form>
			</div>
		</div>
	</div>
	<!-- Footer and Modal ==========================-->
</body>
<sb:head />
</html>