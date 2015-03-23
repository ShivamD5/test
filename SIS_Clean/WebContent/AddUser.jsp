
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<sx:head/>
<body style="background-color: #E6E6FA">

	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->
	
 	<br>
 	<br><br><br>


<!-- Login
    ==========================-->
<!-- -------------------------- -->

<br>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h2 class="panel-title">
			<center>Add Student</center>

		</h2>
	</div>

	<div class="panel-body" style="background-color:;">


		<s:form id="FormAddUser" name="FormAddUser" action="AddUser"
			method="post" class="form-horizontal">

			<div class="row" align="center">
				<div class="col-sm-6" align="left">
					<div class="col-sm-4" align="right">
						<label>User ID</label>
					</div>

					<s:textfield theme="simple" name="UserId" required="true"
						cssStyle="width:230px;" class="form-control"></s:textfield>
				</div>


			</div>
			<br>
			<div class="row" align="center">
				<div class="col-sm-6" align="left">
					<div class="col-sm-4" align="right">
						<label>Name</label>
					</div>

					<s:textfield theme="simple" name="Name" required="true"
						cssStyle="width:230px;" class="form-control"></s:textfield>
				</div>
			</div>
			<div class="row" align="center">
			<div class="col-sm-6" align="left">
								<div class="col-sm-4" align="right">
									<label>Interest</label>
								</div>
								<s:select theme="simple" name="iid" key="iid" list="interest"
									cssStyle="width:230px;" placeholder="Select Interest"
									property="selectedValues" multiple="true" />
							</div>
						</div>	
							
			<br>
			<div class="row" align="center">
				<div class="col-sm-6" align="left">
					<div class="col-sm-4" align="right">
						<label>Address</label>
					</div>

					<s:textarea theme="simple" name="Address" required="true"
						cssStyle="width:230px;" class="form-control"></s:textarea>
				</div>
			</div>
			<br>
			<div class="row" align="center">
				<div class="col-sm-6" align="left">
					<div class="col-sm-4" align="right">
						<label>Birth date</label>
					</div>
					<sx:datetimepicker name="DOB"  
 										displayFormat="yyyy-MM-d" value="todayDate" /> 
				</div>
			</div>
			<br>
			<div class="row" align="center">
				<div class="col-sm-6" align="left">
					<div class="col-sm-4" align="right">
						<label>Password</label>
					</div>

					<s:password theme="simple" name="Password" required="true"
						cssStyle="width:230px;" class="form-control"></s:password>

				</div>
			</div>
			<br>
			<div class="row" align="center">
				<div class="col-sm-6" align="left">
					<div class="col-sm-4" align="right">
						<label>Email Id</label>
					</div>

					<s:textfield theme="simple" name="EmailId" class="form-control"
						cssStyle="width:230px;" required="true"
						placeholder="firstname.lastname@iiitb.org"></s:textfield>
				</div>
			</div>
			<br>
			<div class="row" align="center">
				<div class="col-sm-6" align="left">
					<div class="col-sm-4" align="right">
						<label>Specialization</label>
					</div>

					<s:select theme="simple" name="Specialization" key="Specialization" list="{'CS','DS','SE','NCE'}"
									cssStyle="width:230px;" placeholder="Enter the Credit"
									property="selectedValues" multiple="false" />
				</div>
			</div>
			<br>
			<div class="row" align="center">
				<div class="col-sm-6" align="left">
					<div class="col-sm-4" align="right">
						<label>Image</label>
					</div>
					<s:file name="Image" theme="simple" enctype="multipart/form-data"
						id="Image" key="Image" required="true" />

				</div>
			</div>
			<hr>



			<div align="center">
				<div class="col-sm-3">
					<a href="faculty.jsp" class="btn btn-info"> <span
						class="glyphicon glyphicon-repeat"></span> Back
					</a>
					<s:submit class="btn btn-success" label="Add" />
				</div>
			</div>


		</s:form>
		<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-6">
								<s:property value="msg"/>
							</div>
						</div>



		<div align="center"></div>
	</div>
</div>

<br>

<!-- ----- -->
<!-- Footer and Modal
    ==========================-->

<sb:head />
</body>
</html>