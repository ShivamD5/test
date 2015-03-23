<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
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
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav pull-left">
			<li class="active"><a href="login"> <span
					class="glyphicon glyphicon-home" class="navbar-brand"></span> Home

			</a></li>
			<li><a href="initGradeAction">Grades</a></li>
			<li><a href="initViewGradeAction">View Grades</a></li>

			<li><a href="initUpdateGradeAction">Update grades</a></li>
			<li><a href="ResetPassword_faculty">Reset Password</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="logOut.jsp"> <span
					class="glyphicon glyphicon-log-out" class="navbar-brand"></span>
					Log Out
			</a></li>
			
		</ul>

		<form class="navbar-form pull-right" role="search" action="SearchUser">
			<div class="input-group" Style="padding-bottom: 10px;">
				<input type="text" class="form-control" placeholder="Search Friends"
					name="user_search" Style="height: 24px;">
				<div class="input-group-btn">
					<button class="btn btn-primary" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>

	</div>
</nav>
<sb:head />