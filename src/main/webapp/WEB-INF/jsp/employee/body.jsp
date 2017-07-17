<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
	<title>HR System R0</title>
</head>
<body>
<div>	
    <img class="dataTableExample" src="<c:url value='/resources/dataTable/images/xm.png'/>" style="max-height: 20%; width:  auto;" />
    <h1 align="center">HR System R1.0</h1>
</div>
<table id="example" class="display" cellspacing="0" width="100%" style="overflow-x:auto">
				<thead>
					<tr>
						<th>Name</th>
						<th>Desgination</th>
						<th>Salary</th>
						<th>Country</th>
					</tr>
				</thead>
			</table>
</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
	var data =eval('${employeeList}');
	var table = $('#example').DataTable( {
		  "aaData": data,
		  "aoColumns": [
		    { "mData": "name"},
		    { "mData": "desgination"},
		    { "mData": "salary"},
		    { "mData": "country"}
		  ],
		  "paging":true
		});
});
</script>