<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletPostNewUniversity" method="post">
		Nombre Universidad:<input type="text" name="name" /> 
		Pagina Web:<input type="text" name="webpage" /> 
		<input type="submit" value="Registrar" />
	</form>
</body>
</html>