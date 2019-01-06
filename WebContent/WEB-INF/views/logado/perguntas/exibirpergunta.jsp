<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Editar Pergunta ${pergunta.id_pergunta }</h3>

	<form:form action="editarpergunta" commandName="pergunta" methodo="post">
		<table>
			<tr class="meio">
				<td><input name="id_pergunta" value="${pergunta.id_pergunta}" type="hidden"/></td>
				<td><label for="editarpergunta"><b>Pergunta:</b></label></td>
				<td><form:input path="pergunta"/><br>
					<form:errors path="pergunta" cssClass="erros" element="div" /></td>
			</tr>
			<tr>
				<td colspan="3">
						<input type="submit" class="btn btn-primary" value="Editar">
						<input type="submit" class="btn btn-default" value="Cancelar"  formaction="./administrador?pagina=pergunta">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>