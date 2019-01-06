<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Corpo do Site / Formulario -->
	<center>
		<table>
			<tr class="meio">
				<td>Nome do Curso:</td>
			</tr>

			<tbody>
				<c:forEach items="${cursos}" var="curso">
					<tr>
						<td>${curso.nome_curso}</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>