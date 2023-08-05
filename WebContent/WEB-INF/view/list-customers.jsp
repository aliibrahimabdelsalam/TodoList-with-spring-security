<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>

<link   type="text/css" 
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
<h2> User::
<security:authentication property="principal.username" />
</h2>
<h2> ROle::
<security:authentication property="principal.authorities" />
</h2>

<div id="wrapper">
	<div id=header>
		<h2>CRM-Customer Relationship Manager</h2>
	</div>
</div>
<div id="container">
	<div id="content">
	<security:authorize access="hasRole('MANAGER')">	
	<input type="button" onclick="window.location.href='showFormForAdd';return false;" value="Add Customer" class="add-button" />
	</security:authorize>
	
	<form action="search" method="get">
	<input type="text" name="search" value="${param.search }" placeholder="Enter the Name " />
	<button>find</button>
	</form>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<security:authorize access="hasRole('ADMIN')">	
				<th>Action</th>
				</security:authorize>
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
			<c:url var="updateLink" value="/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>
			<c:url var="deleteLink" value="/showFormForDelete">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>
			<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
				<security:authorize access="hasRole('ADMIN')">	
				<td><a href="${updateLink}">Update</a></td>
				<td><a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want delete this customer?'))) return false">Delete</a></td>
				</security:authorize>
			</tr>
	
			</c:forEach>
		
		</table>
	
	 <form:form action="${pageContext.request.contextPath}/logout"
			method="post">
			
			<input type="submit" value="Logout" />
</form:form>
	
	</div>
</div>
</body>
</html>