<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saving Lead</title>
</head>
<body>
	<h2>
	    	<c:choose>
	        <c:when test="${not empty lead.id}">
	            Update Lead Form
	        </c:when>
	        <c:otherwise>
	            Saving Lead Form
	        </c:otherwise>
	    	</c:choose>
	</h2>
	<form action="${empty lead.id ? 'saveLead' : 'updateLead'}" method="post">
			<input type="hidden" name="id" value="${lead.id}"> 
			First Name <input type="text" name="firstName" value="${lead.firstName}"> 
			Last Name <input type="text" name="lastName" value="${lead.lastName}"> 
			Email <input type="text" name="email" value="${lead.email}"> 
			Mobile <input type="text" name="mobile" value="${lead.mobile}"> 
    			<input type="submit" value="${empty lead.id ? 'Save' : 'Update'}">
	</form>
	${msg}
</body>
</html>