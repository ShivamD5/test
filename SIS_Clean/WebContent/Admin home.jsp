<!DOCTYPE html>

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
	<!-- Carousel
    =========================-->

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>

		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner col-sm-offset-2" role="listbox">
			<div class="item active">
				<img src="img/3d-wide-wallpaper-1920x1080-015.jpg" height='1000' width='1000' align="middle" class = 'img-circle' alt = 'Cinque Terre'>
			</div>

			<div class="item">
				<img src="img/3d-wide-wallpaper-1920x1080-020.jpg" height='1000' width='1000' align="middle" class = 'img-circle' alt = 'Cinque Terre'>
			</div>

			<div class="item">
				<img src="img/3d-wide-wallpaper-1920x1080-020.jpg" height='1000' width='1000' align = "middle" class = 'img-circle' alt = 'Cinque Terre'>
			</div>


		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<!-- Footer and Modal
    ==========================-->

</body>
<sb:head />
</html>
