<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<script type="text/javascript">
	function onSemChange() {

		document.enrollcourses.action = 'enrollcourse.action';
		document.enrollcourses.submit();
	}

	function onInsert() {
		document.enrollcourses.action = 'enrollcourseinsert.action';
		document.enrollcourses.submit();
	}
</script>
</head>
<body style="background-color: #E6E6FA">

	<br></br>
<sb:head/>
	<br></br>



	<!-- Login
    ==========================-->

	
	<div class="container">
<br>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"> Enroll Courses</h3>
			</div>
			<div class="panel-body" style="background-color:;">

				<div align="center">
					<font size=4> <s:form action="enrollcourse" name="enrollcourses"
							enctype="multipart/form-data" theme="bootstrap"
							Class="form-horizontal">
							<br>
							<div class="row" align="center">

								<s:select key="semid" list="{'1','2','3','4'}" name="sem"
									onchange="onSemChange()"></s:select>
								<s:select key="courseid" list="courselist" name="course"
									required="true"></s:select>
								<s:submit label="Add" Class="btn-success" onclick="onInsert()" />
							</div>
							<br>
							<div><s:property value="msg"></s:property></div>

						</s:form>
					</font>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
<input id='menuParent' type='hidden' value='home' />