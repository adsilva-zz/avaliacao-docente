<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Avaliação Docente</title>
</head>
<body>
	<center>
		<!-- Corpo do Site / Formulario -->
		<form:form action="adicionacurso" commandName="curso" method="post">
			<table>
				<tr class="meio">
					<td><label for="cadastrarcurso"><b>Nome do Curso:</b></label></td>
					<td><form:input path="nome_curso" id="cadastrarcurso" /> <form:errors
							path="nome_curso" cssClass="erros" element="div" /></td>
				</tr>

				<tr align="center">
					<td style="padding: 8px" class="erros" colspan="3">${errado}</td>
				</tr>

				<tr align="center">
					<td colspan="3"><input type="submit" value="Salvar"></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>