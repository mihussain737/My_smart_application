<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Leads</title>
</head>
<body>
	<h2>List Of Leads</h2>
	<table border="1">
		<tr>
			<th hidden>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Actions</th>
			<th>Mail</th>
		</tr>
		<c:forEach var="lead" items="${leads}">
			<tr>
				<td hidden>${lead.id}</td>
				<td>${lead.firstName}</td>
				<td>${lead.lastName}</td>
				<td>${lead.email}</td>
				<td>${lead.mobile}</td>
				<td><a href="delete?id=${lead.id}">Delete</a>
				<a href="update?id=${lead.id}">Update</a>
				</td>
				<td>
    					<form action="sendMail" method="post">
        					<input type="hidden" name="id" value="${lead.id}">
        					<input type="text" name="emailMessage" placeholder="Enter message">
        					<button type="submit">SendMail</button>
    					</form>
    					 <c:if test="${lead.id == sentLeadId}">
        					<span style="color:green;">${sentMsg}</span>
    					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>