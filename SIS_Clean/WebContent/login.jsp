<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>

<title>Login</title>

<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<sb:head />
</head>

<% 
	//session s=request.getSession(false);
if(null != session.getAttribute("login"))
	response.sendRedirect("login");

System.out.println("uuuuuuu"+session.getAttribute("name"));
%>



<body style="background-color: #E6E6FA"
	background="img/3d-wide-wallpaper-1920x1080-015.jpg">



	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />

	<br>
	<br>
	<h2 style="color:white;text-align:center">Welcome To Student Information System</h2>
	<br>
	<br>
	
	
	<div class="row">
		<div class="col-sm-7">
		</div>

		<div class="col-sm-5">

			<div  style="width: 500px">
				<div style="background-color: #0066FF">
					<h3 class="panel-title "><span style="color:white">&nbsp; &nbsp;Login</span></h3>
				</div>
				<div class="panel-body" style="background-color: rgba(245, 245, 245, 0.4);">


					<s:form action="login" enctype="multipart/form-data"
						theme="bootstrap" cssClass="form-horizontal">


						<s:textfield key="username" label="Username" required="true" />
						<s:password key="userpass" label="Password" required="true" />

						<div class="col-sm-offset-3">
							<s:submit class="btn btn-primary" />
							<s:reset class="btn btn-danger" />
						</div>

					</s:form>
					<div class="form-group row" style="color:red">
							<div class="col-sm-offset-2 col-sm-6">
								<s:property value="msg"/>
							</div>
					</div>
			</div>
		</div>
	</div>

	<!-- Footer and Modal
    ==========================-->


	<div class="row">

		<div class="col-sm-12" align = "center">
			<div style="padding-top: 250px">
				<!-- <br><br><br><br><br><br><br><br><br><br> -->

				<hr  style="width: 1000px" >
				<p class = "pull-right" style = "padding-right: 20px">
					Copyright &copy; Student Information System. <a data-toggle="modal"
						href="#myModal"><font color="white">Terms and
								Conditions</font></a>
				</p>

				<!-- Modal -->
				<div class="modal fade hide" id="myModal" tabindex="-1" role="dialog"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h2>Terms and Conditions</h2>
							</div>
							<div class="modal-body">
								<p>The text will go here.....</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>