<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="IncludeExt" />
</head>

<body style="background-color: #E6E6FA">

   <tiles:insertAttribute name="navBar" /><br/>
   <tiles:insertAttribute name="body" /><br/>
   <tiles:insertAttribute name="footer" /><br/>
</body>
</html>