<!DOCTYPE html>

<%@page import="dao.LoginDao"%>
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
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%

LoginDao ld = new LoginDao();
ld.logOutTime();
	request.getSession().invalidate();
	response.sendRedirect("login.jsp");
%>
<html>
<head>
<title>Log Out</title>

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

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span>

			</button>

		</div>
		<s:property value="admin" />
		<div class="navbar-collapse collapse col-sm-offset-1">
			<ul class="nav navbar-nav">
				<li><a href="Admin home.jsp" class="navbar-brand">Admin</a></li>
				<li><a href="AddUser.jsp">Add Users</a></li>
				<li><a href="initSubjectsAction">Add course</a></li>
				<li><a href="addfaculty.jsp">Add faculty</a></li>

				<li><a href="news.jsp">Add News</a></li>
				<li><a href="removeNewsAction">Remove News</a></li>

				<li><a href="announcement.jsp">Add Announcement</a></li>
				<li><a href="removeAnnouncementAction">Remove Announcement</a></li>

				<li><a href="enrollCourses">Approve course</a></li>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp"> <span
						class="glyphicon glyphicon-log-out" class="navbar-brand"></span>
						Log Out
				</a></li>
			</ul>
		</div>

	</div>

	<br>
	<br>
	<br>
	<br>

</body>
</html>