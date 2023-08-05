<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>
<h3>My Register Page</h3>

<h4>${registerError } </h4>
 <form:form action="${pageContext.request.contextPath}/register/RegistrationProcessing" method="post" modelAttribute="users">
			
	<p>
	UserName: <input type="text" name="userName"  />
	</p>
	<p>
	Password: <input type="password" name="password"  />
	</p>
	<input type="hidden" name="enabled" value="1" />
	<input type="submit" value="Register" />
</form:form> 


</body>
</html>