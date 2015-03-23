<%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<body style="background-color:#E6E6FA">
	 <!-- Login
    ==========================-->
	<br><br><br><br>
		<div class="container">
		
<br>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"> View Grades</h3>
			</div>
			<div class="panel-body" style="background-color:;">

				<div align="center">
					<font size=4> <s:form action="studentGradesAction"
							 enctype="multipart/form-data"
							theme="bootstrap" Class="form-horizontal">
							<br>
							<div class="row" align="center">
								<div class="col-sm-6">
									<div class="col-sm-4" align="right">
										<label>Choose Sem</label>
									</div>
									
									<s:select theme="simple" name="semId" key="semId"
										list="#{'1':'1', '2':'2', '3':'3', '4':'4'}"
										cssStyle="width:250px;" placeholder="Select Semester" />
								
								</div>
							</div>
							<br>
							<div class="row" align="center">
								<div class="col-sm-8">
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
	
</body>
<sb:head/>
</html>