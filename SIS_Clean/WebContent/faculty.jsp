<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>


<body style="background-color: #E6E6FA">

	<!-- Fixes Navigation Bar with drop down menu
    ======================================================-->


	<br></br>


<br><br><br><br>
	<div class="container">


		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"></h3>
			</div>
			<div class="panel-body" style="background-color:;">

				<div align="center">
					<font size=4> <s:iterator status="stat" value="list">

							<img src=<s:property value="Photo"/> 'height='200' width='200'
								alt="sdf">
							<br>
							<div class="col-sm-12" align="center">
								<h3>
									<s:property value="facultyName" />
								</h3>
							</div>
						</s:iterator>
						</font>
				</div>
				<div align="center">
					<font size=4>
						<table class="table" width="2" align="right">
							<s:iterator status="stat" value="list">
								<thead>


									<tr class="danger">
										<th>Qualification</th>
										<td><s:property value="Quali" /></td>
									</tr>
									<tr class="danger">
										<th>Cabin No.</th>
										<td><s:property value="Cabin" /></td>
									</tr>
									<tr class="danger">
										<th>Email</th>
										<td><s:property value="Email" /></td>
									</tr>

								</thead>
							</s:iterator>
						</table>
					</font>
				</div>
				
			</div>
		</div>
	</div>


	<!-- Carousel
    =========================-->
	<%-- 
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>

		</ol>

		<!-- Wrapper for slides -->
		<!-- <div class="carousel-inner col-sm-offset-2" role="listbox">
			<div class="item active">
				<img src="img/slide1.jpg" height='1000' width='1000' align="middle" class = 'img-circle' alt = 'Cinque Terre'>
			</div>

			<div class="item">
				<img src="img/slide2.jpg" height='1000' width='1000' align="middle" class = 'img-circle' alt = 'Cinque Terre'>
			</div>

			<div class="item">
				<img src="img/slide3.jpg" height='1000' width='1000' align = "middle" class = 'img-circle' alt = 'Cinque Terre'>
			</div>


		</div>
 -->
		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div> --%>





	<!-- Footer and Modal
    ==========================-->

</body>
<sb:head />
</html>
