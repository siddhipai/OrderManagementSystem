<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quality Control</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link href="http://fonts.googleapis.com/css?family=Abel"
	rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">
  javascript:window.history.forward(1);
</script>
<body>
<%
Boolean logg=(Boolean)session.getAttribute("Logged");
if(logg==null||logg==false)
{
	System.out.println("logged null");

%>

<jsp:forward page="/index.jsp"></jsp:forward>

<%} else{%>

<div id="outer"><%@include file="/loggerDetails.jsp" %>
<div id="wrapper">

<div id="mainbody">
<div id="page">
<fieldset><legend align="center"></legend>

<div align="center">

<form action="ViewOrdersManagerQuality" method="post">
<input type="submit" value="PENDING ORDERS" name="pendingOrders" />
<input type="submit" value="VIEW HISTORY" name="auditlog"/>
</form>
</div>
</fieldset>

<% } %>
<br class="clearfix" />
<br class="clearfix" />
<br class="clearfix" />
<br class="clearfix" />
<br class="clearfix" />
</div>
<br class="clearfix" />

</div>
</div>


<%@ include file="/footer.jsp"%></div>
</body>
</html>