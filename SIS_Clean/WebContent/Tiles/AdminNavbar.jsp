<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<String> temp = new ArrayList<String>();
	temp = (ArrayList<String>) session.getAttribute("login");
	String name = temp.get(0);
	System.out.print("login" + name);
	if (name.equals("admin")) {
	} else {
		response.sendRedirect("login");
	}
%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
	style="background: primary\">

	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Student Information System</a>
	</div>
	<br> <br>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<s:property value="admin" />
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav pull-left">
			<li><a href="login" class="navbar-brand"><span
					class="glyphicon glyphicon-home" class="navbar-brand"></span>Home</a></li>
			<li><a href="AdminAddUser">Add Users</a></li>
			<li><a href="initSubjectsAction">Add course</a></li>
			<li><a href="AdminAddFaculty">Add faculty</a></li>

			<li><a href="AdminAddNews">Add News</a></li>
			<li><a href="removeNewsAction">Remove News</a></li>

			<li><a href="AdminAddAnnouncemet">Add Announcement</a></li>
			<li><a href="removeAnnouncementAction">Remove Announcement</a></li>

			<li><a href="enrollCourses">Approve course</a></li>
			<li><a href="updateSubjectsAction">Update course</a></li>
			<li><a href="addinterest">Add Interest</a></li>
			<li><a href="Q2AddStream">Add Stream</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="logOut.jsp"> <span
					class="glyphicon glyphicon-log-out" class="navbar-brand"></span>
					Log Out
			</a></li>
		</ul>

	</div>
</nav>
<br><br>
<sb:head/>
