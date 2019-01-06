<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form:form action="adicionapergunta" commandName="pergunta"
			method="post">
			<table>
				<tr class="meio">
					<td><label for="pergunta"><b>Pergunta:</b></label></td>
					<td><form:textarea path="pergunta" rows="5" cols="50"
							id="pergunta" /></td>
				</tr>
				<tr>
					<td><label for="categoria"><b>Categoria:</b></label></td>
					<td><form:select path="categoria_pergunta"><form:options items="${listapergunta }"/></form:select>
			</table>
		</form:form>
	</center>
</body>
</html>