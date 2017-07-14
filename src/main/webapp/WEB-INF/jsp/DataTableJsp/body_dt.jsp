<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<%@page import="com.mikex.guest.*"%>
<jsp:useBean id="guestDao" type="com.mikex.guest.GuestDao" scope="request" />

<html>
<head>
	<title>JQuery Datatable + Spring MVC JPA</title>
</head>
<body>
<div>
	<img class="dataTableExample" src="resources/images/JQueryDatatableandSpringMVC.png">
</div>
<table id="example" class="display" cellspacing="0" width="100%" style="overflow-x:auto">
				<thead>
					<tr>
						<th>Name</th>
						<th>Signing Date</th>
						
					</tr>
				</thead>
			</table>
</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
	var data =eval('${guestDao.getAllGuests()}');
	var table = $('#example').DataTable( {
		  "aaData": data,
		  "aoColumns": [
		    { "mData": "name"},
		    { "mData": "Signing Date"},
		    
		  ],
		  "paging":false
		});
});
</script>