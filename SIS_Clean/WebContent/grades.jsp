<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<html>
<head>
<script type="text/javascript">
function onCourseChange() {
/* alert("jhg"); */
document.studentsGrade.action = 'courseStudents.action';
document.studentsGrade.submit();
}
</script>
<title>Assign Grades</title>

<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link
href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<body style="background-color: #E6E6FA">




<!-- Fixes Navigation Bar with drop down menu
======================================================-->

<br><br><br>
<div class="jumbotron container" style="background: #558C89\">
<!-- <img alt="Course" src="img/slide1.jpg" height='200' width='200' -->
<!-- class='img-circle' align=right> -->
<!-- <div class="panel panel-info" style="background: #C63D0F\"> -->
<!-- <div class="panel-heading">Panel heading without title</div> -->
<!-- <div class="panel-body">Panel content</div> -->
<!-- </div> -->

<div class="panel panel-info">
<div class="panel-heading">
<h3 class="panel-title">Enter Grades</h3>
</div>
<div class="panel-body" style="background: #74AFAD;">

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
border="1" style="margin: 0px auto">

<div class="row" align="center">
<div class="col-sm-8">
<thead>
<tr class="success">
<td><b>Subject Name</b></td>
<td><b>Current Grades</b></td>
<td><b>Grade</b></td>

</tr>
</thead>
</div>
</div>
<tbody>
<s:iterator value="sgrade_list">
<div class="row" align="center">
<div class="col-sm-8">
<s:if test="grade=='Nil'">
<tr>
<td><s:property value="s_Id" /></td>
<td><s:property value="grade" /></td>



<td><s:select theme="simple" name="listGrade"
key="gradeid"
list="#{'0':'Nil', '1':'A', '2':'B', '3':'C', '4':'D'}"
cssStyle="width:200px;" placeholder="Course" /></td>

</tr>
</s:if>
</div>
</div>
</s:iterator>
</tbody>
</table>
<div class="row" align="center">
<div class="col-sm-12" align="center">
<s:submit class="btn btn-success" />
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
<sb:head/>
</html>