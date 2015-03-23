
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<body style="background-color: #E6E6FA">

	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->


	<br>
	<br>
	<br>
	<br>



	<!-- Login
    ==========================-->
<div class = "container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">
				<center>Add Faculty</center>
			
			</h3>
		</div>
		<div class="panel-body" style="background-color:;">

			<div align="center">
				<font size=4> <s:form action="register" theme="bootstrap"
						Class="form-horizontal">
						<br>
		
			<div class="row" align="center">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="right">
									<label>Enter ID</label>
								</div>
								<s:textfield theme="simple" name="id" class="form-control"
									placeholder="Enter ID..." cssStyle="width:230px;"></s:textfield>

							</div>


						</div>
						<br>
						<div class="row" align="center">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="right">
									<label>Enter Name</label>
								</div>
								<s:textfield theme="simple" cssStyle="width:230px;" name="name" class="form-control"
									placeholder="Enter Name..." ></s:textfield>

							</div>
						</div>
						<br>
						<div class="row" align="center">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="right">
									<label>Enter Email</label>
								</div>
								<s:textfield theme="simple" cssStyle="width:230px;" name="email" class="form-control"
									placeholder="Enter Email..."></s:textfield>

							</div>
						</div>
						<br>
						<div class="row" align="center">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="right">
									<label>Enter Qualification</label>
								</div>
								<s:textfield  theme="simple" cssStyle="width:230px;" name="quali" class="form-control"
									placeholder="Enter Qualification..."></s:textfield>
							</div>
						</div>
						<br>
						<div class="row" align="center">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="right">
									<label>Enter Cabin No.</label>
								</div>
								<s:textfield theme="simple" cssStyle="width:230px;" name="cabin" class="form-control"
									placeholder="Enter Cabin No..."></s:textfield>

							</div>
						</div>
						<br>
						<div class="row" align="center">
								<div class="col-sm-6" align="left">
									<div class="col-sm-4" align="right">
										<label>Enter Password</label>
									</div>
									<s:password theme="simple" cssStyle="width:230px;" name="password"  class="form-control" placeholder="Enter Password..."></s:password>  
		
									
								</div>
							</div>
							<br>
						<div class="row" align="center">
							<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="right">
									<label>Choose Picture</label>
								</div>
								<s:file theme="simple" name="pic" enctype="multipart/form-data"></s:file>
							</div>
						</div>
						<br>
						
						
						<hr>



						<div align="center">
							<div class="col-sm-3">
								<s:submit class="btn btn-primary" />
								<a href="admin.jsp" class="btn btn-primary btn-md"> <span
									class="glyphicon glyphicon-repeat"></span> Back
								</a>							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-6">
								<s:property value="msg"/>
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