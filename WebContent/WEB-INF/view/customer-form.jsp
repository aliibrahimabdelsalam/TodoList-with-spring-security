<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Add Customer</title>
<link 
type="text/css" rel=stylesheet"
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
<link 
type="text/css" rel=stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
		<h2>CRM Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer" method="post">
			<table>
				<tbody>
					<form:hidden path="id"/>
					<tr> 
						<td><label>First Name:</label></td>
						<form:input path="firstName"/>
					</tr>
					<tr> 
						<td><label>last Name:</label></td>
						<form:input path="lastName"/>
					</tr>
					<tr> 
						<td><label>Email:</label></td>
						<form:input path="email"/>
					</tr>
					<tr> 
						<td><label>submit</label></td>
						<input type="submit" value="Save" class="save" />
						
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;">
			<p>
			<a href="${pageContext.request.contextPath}/">Back to List </a>
			</p>
		</div>
	</div>
</body>
</html>