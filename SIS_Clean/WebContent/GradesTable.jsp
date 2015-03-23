<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="s" uri="/struts-tags"%>

   
    
	<br>
				
	
				
	 <!-- Login
    ==========================-->

	<br><br><br>
	
	<div class="jumbotron container">
		<img alt="" src="new_courses.gif" align=right>
		<div class="panel panel-primary">
			<div class="panel-heading"><center>Grades Details</center></div>
			
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"></h3>
			</div>
			<div class="panel-body" style="background-color:;">

				<div align="center">
					<font size=4> <table class="table" >
			  <thead>
				<tr>
					<th>Semester</th><th>Student ID</th><th>Course</th><th>Grades</th>
					</tr>
					</thead>
					<s:iterator status="stat" value="list">
					<tbody>
					<tr class="danger" >
<td><s:property value="semId"/>  </td>   <td><s:property value="%{studentId}"/>  </td>
<td><s:property value="CName"/></td>  <td><s:property value="grade"/></td>

				</tr>
				</s:iterator></tbody>
			</table>
					</font>
				</div>
			</div>
		</div>
	</div>
	<%-- <div class="jumbotron container" style="background:#FFEFD5" >

	<h2><center><u><b>Grades Details</b></u></center></h2><br>
	<div style="text-align: left">
	
			<table class="table" >
			  <thead>
				<tr>
					<th>Semester</th><th>Student ID</th><th>Course</th><th>Grades</th>
					</tr>
					</thead>
					<s:iterator status="stat" value="list">
					<tbody>
					<tr class="danger" >
<td><s:property value="semId"/>  </td>   <td><s:property value="%{studentId}"/>  </td>
<td><s:property value="CName"/></td>  <td><s:property value="grade"/></td>

				</tr>
				</s:iterator></tbody>
			</table>




  </div>
</div>

</body>
</html>
			
	</div>




				
				
			</div>
	
	 --%>
	
	
	
	
    
   
    <sb:head/>
</body>
</html>