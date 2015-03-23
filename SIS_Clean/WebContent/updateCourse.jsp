
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<body style="background-color: #E6E6FA">

	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->
	
 	<br>
 	<br><br><br>

	<div class="jumbotron container" style="background:#E6E6FA">
		
		

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Course Details</h3>
			</div>
			<div class="panel-body" style="background-color:;">


				<font size=4> <s:form action="updateSubject"
						enctype="multipart/form-data" theme="bootstrap"
						Class="form-horizontal">
						

						<div class="row">
							<div class="col-sm-6" align="center">
								<div class="col-sm-5" align="center">
									<label>Course Code</label>
								</div>
								<s:select theme="simple" name="code" key="code" list="subjectList"
									cssStyle="width:230px;" placeholder="Code" />
							</div>
						</div>
						<br>
						

							<div class="row">
							<div class="col-sm-6" align="center">
								<div class="col-sm-5" align="center">
									<label>Faculty Name</label>
								</div>
								<s:select theme="simple" name="fid" key="fid" list="facultyList"
									cssStyle="width:230px;" placeholder="Faculty" property="selectedValues" multiple="true" />
							</div>
						</div>
						<br>

						<div class="row">
							<div class="col-sm-8" align="center">
								<div class="col-sm-9" align="right">
								<s:submit class="btn btn-primary" />
								<s:reset class="btn btn-danger" />
								</div>
							</div>
						</div>

					</s:form>
			</div>
		</div>
	</div>
	<!-- Footer and Modal
    ==========================-->

</body>
<sb:head />
</html>
