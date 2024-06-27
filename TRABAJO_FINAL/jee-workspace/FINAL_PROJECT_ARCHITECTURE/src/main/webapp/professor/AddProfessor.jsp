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
	<form action="ServletPostNewProfessor" method="post">
		Nombre:<input type="text" name="name" />
		Apellido:<input type="text" name="lastname" /> 
		Facultad:<input type="text" name="faculty" /> 
		<input type="submit" value="Registrar" />
	</form>
</body>
</html>