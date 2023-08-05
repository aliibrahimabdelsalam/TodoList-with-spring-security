<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
</head>
<body>
welcome back




	<p>
	User: <security:authentication property="principal.username"/>
	</p>
	<p>
	Role: <security:authentication property="principal.authorities"/>
	</p>
	<security:authorize access="hasRole('MANAGER')">
		<p>
		<a href="${pageContext.request.contextPath}/leader">For Leaders </a>
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<p>
		<a href="${pageContext.request.contextPath}/system">For Admins </a>
		</p>
	</security:authorize>
 <form:form action="${pageContext.request.contextPath}/logout"
			method="post">
			
			<input type="submit" value="Logout" />
</form:form>
<%--  <% response.sendRedirect("showMyLoginPage"); %>  --%>

 </body>
</html>