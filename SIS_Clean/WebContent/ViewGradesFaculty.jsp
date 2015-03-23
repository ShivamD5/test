<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<html>
<head>
<script type="text/javascript">
	function onCourseChange() {
		/* alert("jhg");  */
		document.studentsGrade.action = 'courseStudentsView.action?facultyID=<s:property value="#session.login"/>';
		document.studentsGrade.submit();
	}

	function onStudentChange() {

		document.studentsGrade.action = 'currentGrade.action?facultyID=<s:property value="#session.login"/>';
		document.studentsGrade.submit();
	}
</script>

</head>

<body style="background-color: #E6E6FA">




	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->
<br>
<br>
	<br>
	<div class="jumbotron container" style="background: #558C89\">
		<!-- <img alt="Course" src="img/slide1.jpg" height='200' width='200'
			class='img-circle' align=right>
		<div class="panel panel-info" style="background: #C63D0F\">
			<div class="panel-heading">Panel heading without title</div>
			<div class="panel-body">Panel content</div>
		</div> -->

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Enter Grades</h3>
			</div>
			<div class="panel-body" style="background: #74AFAD\;">

				<div align="center">
					<font size=4> <s:form action="gradeInsert"
							name="studentsGrade" enctype="multipart/form-data"
							theme="bootstrap" Class="form-horizontal">
							<br>
							<div class="row" align="center">
								<div class="col-sm-6">
									<div class="col-sm-4" align="right">
										<label>Enter Course</label>
									</div>

									<s:select theme="simple" name="course" key="courseid"
										list="courseList" cssStyle="width:250px;"
										onchange="onCourseChange()" required="true" />
								</div>
							</div>


							<input type="hidden" name="facultyID"
								value="<s:property value="#session.login"/>" />

							<hr>
							<div class=table-responsive align=center>

								<table
									class=" table table-striped table-condensed table-hover table-bordered"
									border="1">

									<div class="row" align="center">
										<div class="col-sm-6">
											<thead>

												<tr class="info">
													<td><b>Subject Name</b></td>
													<td><b>Current Grades</b></td>


												</tr>
											</thead>
										</div>
									</div>
									<tbody>
										<s:iterator value="sgrade_list">
											<div class="row" align="center">
												<div class="col-sm-6">
													<s:if test="s_Id !='Select Student'">
														<tr>
															<td><s:property value="s_Id" /></td>
															<td><s:property value="grade" /></td>

														</tr>
													</s:if>

												</div>
											</div>
										</s:iterator>
									</tbody>
								</table>
								<div class="row" align="center">
									<div class="text-center">

										<a href="faculty.jsp" class="btn btn-primary btn-md"> <span
											class="glyphicon glyphicon-repeat"></span> Back
										</a>

									</div>
								</div>
							</div>
						</s:form>
					</font>
				</div>

			</div>
		</div>
	</div>
	<!-- Footer and Modal
    ==========================-->
</body>
<sb:head />
</html>