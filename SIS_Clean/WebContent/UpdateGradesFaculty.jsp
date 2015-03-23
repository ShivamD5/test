<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<script type="text/javascript">
	function onCourseChange() {
		/* alert("jhg");  */
		document.studentsGrade.action = 'courseStudentsUpdate.action?facultyID=<s:property value="#session.login"/>';
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
	<br><br><br>
	<div class="jumbotron container" style="background: #558C89\">
<!-- 		<img alt="Course" src="img/slide1.jpg" height='200' width='200' -->
<!-- 			class='img-circle' align=right> -->
<!-- 		<div class="panel panel-info" style="background: #C63D0F\"> -->
<!-- 			<div class="panel-heading">Panel heading without title</div> -->
<!-- 			<div class="panel-body">Panel content</div> -->
<!-- 		</div> -->

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Enter Grades</h3>
			</div>
			<div class="panel-body" style="background: #74AFAD;">

				<div align="center">
					<font size=4> <s:form action="gradeInsertUpdate"
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
							<br>
							<div class="row" align="center">
								<div class="col-sm-6">
									<div class="col-sm-4" align="center">
										<label>Student Names</label>
									</div>

									<s:select theme="simple" name="studentId" key="studentid"
										list="studentList" cssStyle="width:250px;" required="true"
										onchange="onStudentChange()" />
								</div>
							</div>
							<br>
							<div class="row" align="center">
								<div class="col-sm-6">
									<div class="col-sm-4">
										<label>Current Grade</label>
									</div>
									<s:property value="currentGrade" />


								</div>
							</div>

							<input type="hidden" name="facultyID"
								value="<s:property value="#session.login"/>" />

							<br>
							<div class="row" align="center">
								<div class="col-sm-6">
									<div class="col-sm-4" align="center">
										<label>Select Grade</label>
									</div>
									<s:select theme="simple" name="grade" key="gradeid"
										list="#{'0':'Nil', '1':'A', '2':'B', '3':'C', '4':'D'}"
										cssStyle="width:250px;" placeholder="Course" />
								</div>
							</div>
							<br>
							<div class="row" align="center">
								<div class="col-sm-6">
									<s:submit class="btn btn-success" />
									<a href="faculty.jsp" class="btn btn-primary btn-md"> <span
										class="glyphicon glyphicon-repeat"></span> Back
									</a>
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