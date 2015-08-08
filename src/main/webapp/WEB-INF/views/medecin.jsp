 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Medecin</title>
</head>
	<body>
	<c:forEach items="${medecins}" var="m">
		<p>${m.nom}</p><br/>
	</c:forEach>
	</body>
</html>