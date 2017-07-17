<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>

	<spring:url value="/resources/dataTable/js/jquery-1.12.4.js" var="jqueryJs" />
	<script src="${jqueryJs}"></script>
	
        <spring:url value="/resources/dataTable/js/jquery.dataTables.js" var="datatable" />
	<script src="${datatable}"></script>

