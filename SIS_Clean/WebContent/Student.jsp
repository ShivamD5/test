<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<br></br><br>
	<br>
	<br>

	<div align="center">
	<div class="row">
		<div class=" col-sm-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Announcement</h3>
				</div>
				<div class="panel-body" style="background-color:;">

					<div align="center">

						<marquee direction="up" onmouseover="this.stop();"
							onmouseout="this.start();">
							<ol>
								<s:iterator value="ancList" status="announcementsItem">
									<li><b> <s:property />

									</b></li>
									<br />
								</s:iterator>
							</ol>
						</marquee>
					</div>
				</div>
			</div>

		</div>


		<div class=" col-sm-8">


			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Welcome, <s:iterator status="stat" value="list"> <s:property value="studentName" /> !</s:iterator></h3>
				</div>
<div class="panel-body" style="background-color:;">

				<div align="center">
					<font size=4> <s:iterator status="stat" value="list">

							<img src=<s:property value="Photo" /> 'height='200' width='200' class = "thumbnail"
								alt="sdf">
							<br>
							
						</s:iterator>
						</font>
				</div>
				<div  align="center">
					<font size=4>
						<table class="table table-hover table-bordered" border="1" style="margin: 0px auto" width="5" >
							<s:iterator status="stat" value="list">
								<thead>


									<tr class="info">
										<th>DOB</th>
										<td><s:property value="dob" /></td>
									</tr>
									<tr class="">
										<th>Address</th>
										<td><s:property value="address" /></td>
									</tr>
									<tr class="info">
										<th>Email</th>
										<td><s:property value="Email" /></td>
									</tr>
									<tr class="">
										<th>Specialization</th>
										<td><s:property value="specializ" /></td>
									</tr>
									 <tr class="info">
										<th>Last Logged</th>
										<td><s:property value="lastLogged" /></td>
									</tr> 

								</thead>
							</s:iterator>
						</table>
					</font>
				</div>
				
			</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">News</h3>
				</div>
				<div class="panel-body" style="background-color:;">

					<div align="center">

						<marquee direction="up" onmouseover="this.stop();"
							onmouseout="this.start();">
							<ol>
								<s:iterator value="newsList" var="element">
									<li><b><a href="<s:url namespace="/" action="getNews"><s:param name="topic" value="#element" /></s:url>"><s:property />
										</a> </b></li>
									<br />
								</s:iterator>
							</ol>
						</marquee> 
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<input id='menuParent' type='hidden' value='home' />
