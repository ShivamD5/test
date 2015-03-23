<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!--
*
* 
author: Azad Krishna 
*
*
-->
<%-- <%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
 --%>
 <%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<title>Add Course</title>

<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<body style="background-color: #E6E6FA">




	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->

	<div class="navbar navbar-default navbar-fixed-top navbar-hover"
		style="background: #6495ED\">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span>

				</button>
				
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="Admin home.jsp" class="navbar-brand">Admin</a></li>
					<li><a href="users.html">Add Users</a></li>
					<li><a href="course.jsp" >Add course</a></li>
					<li><a href="faculty.html">Add faculty</a></li>
					<li><a href="grades.jsp">Assign grades</a></li>
					<li><a href="news.html">News/Announcement</a></li>
					<li class = "active"><a href="search.jsp" class = "active">Search</a></li>

				</ul>
			</div>

		</div>
	</div>


	<div class="jumbotron container" style="background: azure">
		<img alt="Course" src="new_courses.gif" align=right>
		<div class="panel panel-primary">
			<div class="panel-heading">Panel heading without title</div>
			<div class="panel-body">Panel content</div>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading" >
				<h3 class="panel-title">Course Details</h3>
			</div>
			<div class="panel-body" style="background-color:#E6CDFF;">


				<font size=4> <s:form action="admin"
						enctype="multipart/form-data" theme="bootstrap"
						Class="form-horizontal">
						<%-- <s:textfield name="variable" value="%{demo}"/> --%>

						<div class="row">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="center">
									<label>By Name</label>
								</div>

								<s:textfield theme="simple" key="cid" placeholder="Course Id"
									label="Enter Name..." required="true" />
							</div>

						</div>
						<br>
						<div class="row">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="center">
									<label>By ID</label>
								</div>
								<s:textfield theme="simple" label="" key="name"
									placeholder="Enter ID..." required="true" />
							</div>



						</div>

					<br>
			
						
				
	
						
					</s:form>
			</div>
		</div>
	</div>
	<!-- Footer and Modal
    ==========================-->

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<hr />
				<p>
					Copyright &copy; Student Information System. <a data-toggle="modal"
						href="#myModal">Terms and Conditions</a>
				</p>

				<!-- Modal -->
				<div class="modal fade" id="myModal" tabinex="-1" role="dialog"
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
<sb:head/>
</html>