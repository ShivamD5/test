
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
				<h3 class="panel-title">Student detail below</h3>
			</div>
			<div >

				<div align="center">
					<s:form action="abc" method="get" name="subjectGrade"
						enctype="multipart/form-data" theme="bootstrap">
						<!-- <div class="col-sm-offset-2 col-lg-10"> <h2><font color="#333">Login</font></h2> </div> <hr/> -->
<!-- 						<div class="row" align="center"> -->
<!-- 							<div class="col-sm-6"> -->
<!-- 								<br><br><br> -->
<%-- 								<s:select name="streamchoice" --%>
<%-- 									list="streamlist" --%>
<%-- 									cssStyle="width:250px;" onchange="onChoiceChange()"> --%>
<%-- 								</s:select> --%>
<!-- 							</div> -->
<!-- 						</div> -->

						<div style="height:10cm ;overflow:scroll" >

							<table
								class=" table table-striped table-condensed table-hover table-bordered"
								border="1" style="margin: 0px auto">

								<div class="row" align="center">
									<div class="col-sm-8">
										<thead>
											<tr class="success">
												<td><b>S.NO</b></td>
												<td><b>Student Id</b></td>
												<td><b>Student Name</b></td>
												<td><b>Student Photo</b></td>
												
											</tr>
										</thead>
									</div>
								</div>
								<tbody>
									<div class="row" align="center">
										<div class="col-sm-8">
											<s:iterator value="subject_student">
												<tr>
<%-- 													
<%-- <td><a href="<s:url namespace='/' action='syllabusAction'><s:param name='code_syllabus' value='subjectCode' /></s:url>"> --%>
													<td><s:property value="sno" /></td>
													<td><s:property value="id" /></td>
													<td><s:property value="name" /></td>
													
												<td><img class="img-thumbnail" src=<s:property value="photo" /> alt="no" style="width: 80px; height: 80px;"/></td>
													
													

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
					document.subjectGrade.action = 'Q2streamsubject.action';
					document.subjectGrade.submit();
				}
			</script>
</body>
<sb:head />
</html>