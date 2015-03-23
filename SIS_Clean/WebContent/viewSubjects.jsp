
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>


<body style="background-color: #E6E6FA">


	<br>
	<br>
	<br>
	<br>
	<div class="container">

		<br>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Choose from the list</h3>
			</div>
			<div class="panel-body" style="background-color:;">

				<div align="center">
					<s:form action="abc" method="get" name="subjectGrade"
						enctype="multipart/form-data" theme="bootstrap">
						<!-- <div class="col-sm-offset-2 col-lg-10"> <h2><font color="#333">Login</font></h2> </div> <hr/> -->
						<div class="row" align="center">
							<div class="col-sm-6">

								<s:select name="subjectDisplayChoice"
									list="{'Show All Courses', 'Show Enrolled Courses'}"
									cssStyle="width:250px;" onchange="onChoiceChange()">
								</s:select>
							</div>
						</div>

						<div class=table-responsive align=center>

							<table
								class=" table table-striped table-condensed table-hover table-bordered"
								border="1" style="margin: 0px auto">

								<div class="row" align="center">
									<div class="col-sm-8">
										<thead>
											<tr class="success">
												<td><b>Subject Code</b></td>
												<td><b>Subject</b></td>
												<td><b>Faculty Name</b></td>
												<td><b>Semester</b></td>
												<!-- <td><b>Enrolled</b></td>-->
												<td><b>Grade</b></td>
											</tr>
										</thead>
									</div>
								</div>
								<tbody>
									<div class="row" align="center">
										<div class="col-sm-8">
											<s:iterator value="subjectInfoList">
												<tr>
													<td><a href="<s:url namespace='/' action='syllabusAction'><s:param name='code_syllabus' value='subjectCode' /></s:url>">
													<s:property value="subjectCode" /></a></td>
													
													<td><s:property value="subjectName" /></td>
													<td><s:property value="facultyName" /></td>
													<td><s:property value="semester" /></td>
													<td><s:property value="grade" /></td>

												</tr>
											</s:iterator>
										</div>
									</div>

								</tbody>
							</table>
						</div>
					</s:form>
					<div col-xs-2></div>
				</div>
			</div>

			<!-- Footer and Modal
    ==========================-->

			<script type="text/javascript">
				function onChoiceChange() {
					document.subjectGrade.action = 'subjectsDisplayAction.action';
					document.subjectGrade.submit();
				}
			</script>
</body>
<sb:head />
</html>