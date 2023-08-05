<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>
<h3>My Custom Login Page</h3>

 <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			method="post">
			
			<!--  this is if the username or password is wrong  -->
	<c:if test="${param.error !=null }">
	<i> sorry! your Username or Password is wrong</i>
	</c:if>
	<c:if test="${param.logout !=null }">
	<i> you have been logout</i>
	</c:if>
	<p>
	UserName: <input type="text" name="username"  />
	</p>
	<p>
	Password: <input type="password" name="password"  />
	</p>
	<input type="submit" value="Login" />
</form:form> 


<a href="${pageContext.request.contextPath}/register/Registration-form">Register</a>




</body>
</html>