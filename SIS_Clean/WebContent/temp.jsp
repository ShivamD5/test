<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!--
*
* 
author: Shifali(MT2014112) 
*
*
-->
<%-- <%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
 --%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<!--<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>-->
	<script src="js/jquery.js"></script>


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
				<button type="buttton" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span>

				</button>
				<a href="Admin home.html" class="navbar-brand">Admin</a>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

					<li><a href="users.html">Add Users</a></li>
					<li class="active"><a href="course.jsp">Add course</a></li>
					<li><a href="faculty.html">Add faculty</a></li>
					<li><a href="grades.jsp">Assign grades</a></li>
					<li><a href="news.html">News/Announcement</a></li>
					<li><a href="search.jsp">Search</a></li>

				</ul>
			</div>

		</div>
	</div>


	<div class="jumbotron container" style="background: azure">
		<img alt="Course" src="new_courses.gif" align=right>


		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Course Details</h3>
			</div>
			<div class="panel-body" style="background-color: #E6CDFF;">


				<font size=4> <s:form action="admin"
						enctype="multipart/form-data" theme="bootstrap"
						Class="form-horizontal">
						
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
	<!-- 	<div id="magic">This is edit</div> -->


	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
<sb:head />
</html>