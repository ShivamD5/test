<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<title>Twitter Bootstrap 3 - Creativity Tuts</title>

<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<body style="background-color: #E6E6FA">

	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->


	<br>
	<br>
	<br>
	<br>
		<br>
	<br>
	<br>
	<br>
		<br>
	<br>
	<br>
	<br>

	<div class="container">
		<font size=4>
			<form action="Q2AddStreamdao" class="form-horizontal">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Add Stream</h3>
					</div>
					<div class="panel-body" style="background-color:;">

						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-3">
								<b><font color="#333">Add Stream </font></b>
							</div>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="ancTopic"
									placeholder="Enter Stream" required />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-6">
								<button type="submit" class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-success">Clear</button>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-6">
								<s:property value="msg" />
							</div>
						</div>
					</div>
				</div>


			</form>
		</font>
	</div>

	<!-- Footer and Modal
    ==========================-->


</body>
<sb:head />
</html>