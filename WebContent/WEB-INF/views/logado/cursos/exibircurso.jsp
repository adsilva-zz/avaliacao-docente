<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Editar Curso ${curso.id_curso }</h3>

	<form:form action="editarcurso" commandName="curso" methodo="post">
		<table>
			<tr class="meio">
				<td><form:input path="id_curso" value="${curso.id_curso}" type="hidden"/></td>
				<td><form:label path="nome_curso"><b>Nome do Curso:</b></form:label></td>
				<td><form:input path="nome_curso" /><br>
					<form:errors path="nome_curso" cssClass="erros" element="div" /></td>
			</tr>
			<tr>
				<td colspan="3">
						<input type="submit" class="btn btn-primary" value="Editar">
						<input type="submit" class="btn btn-default" value="Cancelar"  formaction="./administrador?pagina=curso">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>