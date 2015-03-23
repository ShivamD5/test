
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>


	<br>
	<br>
	<br>
	<br><br><br>

<body style="background-color: #E6E6FA">

	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->

	<div class="jumbotron container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Choose from the list</h3>
			</div>
			<div class="panel-body" style="background-color:;">
				<div align="center">
					<s:form action="enrollCourseUpdate" method="post"
						name="enrollSubject" theme="bootstrap">
						<div class=table-responsive align=center>
							<table
								class=" table table-striped table-condensed table-hover table-bordered"
								border="1" style="margin: 0px auto">
								<div class="row" align="center">
									<div class="col-sm-8">
										<thead>
											<tr class="success">
												<td><b>Student Id</b></td>
												<td><b>Course Id</b></td>
												<td><b>Semester</b></td>
												<td><b>Yes</b></td>
												<td><b>No</b></td>
											</tr>
										</thead>
									</div>
								</div>
								<tbody>
									<div class="row" align="center">
										<div class="col-sm-8">
											<s:iterator value="enrollList">
												<tr>
													<td><s:property value="StudentId" /></td>
													<td><s:property value="CourseId" /></td>
													<td><s:property value="sem" /></td>
													<%-- <td><s:property value="grade" /></td> --%>
													<td><s:checkbox name="checkedYes"
															fieldValue="%{EnrollId}" /></td>
													<td><s:checkbox name="checkedNo"
															fieldValue="%{EnrollId}" /></td>

												</tr>
											</s:iterator>
										</div>
									</div>

								</tbody>
							</table>

							<div class="row" align="left">
								<div class="col-sm-8">
									<s:submit />
								</div>
							</div>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer and Modal
    ==========================-->
</body>
<sb:head />
</html>