
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<body style="background-color: #E6E6FA">

	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->
 	<br>
 	<br><br><br>
	<!-- News
    ==========================-->

	<div class="container" >
		<font size=4>
			<form action="addNewsAction" class="form-horizontal">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Add News</h3>
					</div>
					<div class="panel-body" style="background-color:;">
 
						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-2">
								<b><font color="#333">Interest : </font></b>
							</div>
							
							<div class="col-sm-6">
								<s:select 
									theme="simple"
									key = "newsInterestId"
									list="intrst"
									cssStyle="width:200px"/>					
							</div>
						</div>

 
						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-2">
								<b><font color="#333">Topic : </font></b>
							</div>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="newsTopic"
									placeholder="Enter Topic Name..." required />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-2">
								<b><font color="#333">Description : </font></b>
							</div>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="newsDescription"
									placeholder="Enter Description..." required />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-6">
								<button type="submit" class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-success">Clear</button>
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-6">
								<s:property value="msg"/>
							</div>
						</div>
						
					</div>
					</div>
			</form>
		</font>
	</div>

</body>
<sb:head/>
</html>