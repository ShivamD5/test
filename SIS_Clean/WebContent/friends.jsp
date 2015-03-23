<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<html lang="en">

<head>



<link href="css/bootstrap.min.css"
	rel="stylesheet">

<link href="css/3-col-portfolio.css"
	rel="stylesheet">


</head>

<body>

		

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<s:property value="user_name"/><br> <small>Friends</small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->

		<div class="row">
		
				<s:if test="%{array_list.isEmpty()}">
				<div class="jumbotron text-center">
   				<h3 style="font-family: transformers;color:black">NO RESULT FOUND !!</h3>
   				</div>
				</s:if>
				
			<s:iterator value="array_list" status="stat">
				<div class="col-md-2 portfolio-item">
					&nbsp;&nbsp;<span style="font-family: georgia;"><a href="#"><b><font color = 'black'"><s:property value="name"/></font></b></a></span>
					
					<a href="#"> <img class="img-thumbnail" src=<s:property value="photo" /> alt="no" style="width: 180px; height: 180px;"/>
					</a>
					<br>&nbsp;&nbsp;&nbsp;
					<a href="<s:url namespace="/" action="deladdFriend"><s:param name="condition" value="friend" /><s:param name="friendid" value="userId" /><s:param name="name" value="name" /></s:url>"" class="btn btn-success glyphicon glyphicon-align-left">
					 <span style="font-family: transformers;color:black"><s:property value="friend" /></span>
  					</a>
					
				</div>
			</s:iterator>
		</div>
		



	<%-- 	<!-- Pagination -->
		<div class="row text-center">
			<div class="col-lg-12">
				<ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<s:iterator value="array_list" status="stat">
					<li><a href="<s:url namespace="/" action="getFreind"><s:param name="page" value="#stat.index" /></s:url>"><s:property value="#stat.index+1" /></a></li>
				</s:iterator>
				<li><a href="#">&raquo;</a></li>
					
				</ul>
			</div>
		</div>
		<!-- /.row -->  --%>



	

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

<sb:head/>

</html>
